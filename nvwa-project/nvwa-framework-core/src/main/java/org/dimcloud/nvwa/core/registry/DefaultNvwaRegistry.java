package org.dimcloud.nvwa.core.registry;

import lombok.NonNull;
import org.dimcloud.nvwa.core.base.*;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Registry default implement
 *
 * @author hehe
 * 2020/10/26 7:09 下午
 **/
public class DefaultNvwaRegistry implements Registry{

    private final Map<Class<Query<?>>,Invoker> queryInvokers = new ConcurrentHashMap<>();

    private final Map<Class<Command<?>>,Invoker> commandInvokers = new ConcurrentHashMap<>();

    private final Map<Class<Event>, CopyOnWriteArraySet<Invoker>> eventInvokers = new ConcurrentHashMap<>();

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void regist(@NonNull Object listener){
        Method[] methods = listener.getClass().getDeclaredMethods();
        try {
            lock.lock();
            for(Method method : methods){
                if(method.isAnnotationPresent(QueryHandler.class)){
                    Class clazz = getParameter(method);
                    queryInvokers.remove(clazz);
                }else if(method.isAnnotationPresent(EventHandler.class)){
                    Class clazz = getParameter(method);
                    commandInvokers.remove(clazz);
                }else if(method.isAnnotationPresent(CommandHandler.class)){
                    Class clazz = getParameter(method);
                    CopyOnWriteArraySet<Invoker> invokers = eventInvokers.get(clazz);
                    if(invokers != null && !invokers.isEmpty()){
                        invokers.removeIf( invoker -> invoker.getListener() == listener && invoker.getMethod() == method);
                        eventInvokers.put(clazz,invokers);
                    }
                }
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void unRegist(Object listener){
        Method[] methods = listener.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(QueryHandler.class)){
                registQueryInvoker(listener,method);
            }else if(method.isAnnotationPresent(EventHandler.class)){
                registEventInvokers(listener,method);
            }else if(method.isAnnotationPresent(CommandHandler.class)){
                registCommandInvoker(listener,method);
            }
        }
    }

    private void registEventInvokers(@NonNull Object listener,@NonNull Method method) {
        Class clazz = getParameter(method);
        synchronized (this){
           CopyOnWriteArraySet<Invoker> invokers = eventInvokers.getOrDefault(clazz,new CopyOnWriteArraySet<>());
           invokers.add(new Invoker(listener,method));
           eventInvokers.put(clazz,invokers);
        }
    }

    private void registCommandInvoker(@NonNull Object listener,@NonNull Method method) {
        Class clazz = getParameter(method);
        synchronized (this){
            if(commandInvokers.containsKey(clazz)){
                throw new IllegalArgumentException("@CommandHandle annotation must has exactly one listener method");
            }
            Invoker invoker = new Invoker(listener,method);
            commandInvokers.put(clazz,invoker);
        }
    }

    private void registQueryInvoker(@NonNull Object listener,@NonNull Method method) {
        Class clazz = getParameter(method);
        synchronized (this){
            if(queryInvokers.containsKey(clazz)){
                throw new IllegalArgumentException("@QueryHandle annotation must has exactly one listener method");
            }
            Invoker invoker = new Invoker(listener,method);
            queryInvokers.put(clazz,invoker);
        }
    }

    @Override
    public CopyOnWriteArraySet<Invoker> getInvokers(Event event) {
        return eventInvokers.get(event.getClass());
    }

    @Override
    public Invoker getInvoker(Command command) {
        return commandInvokers.get(command.getClass());
    }

    @Override
    public Invoker getInvoker(Query query) {
        return queryInvokers.get(query.getClass());
    }

    private Class getParameter(Method method){
        Class[] parameters = method.getParameterTypes();
        if(parameters.length != 1){
            throw new IllegalArgumentException("Method " + method + " has @EventHandle or @CommandHandler or @QueryHandler annotation, but subscriber methods must require a single argument.");
        }
        return parameters[0];
    }
}
