package io.github.dimcloud.nvwa.core.bus;

import io.github.dimcloud.nvwa.core.dispatch.DispatchCallback;
import io.github.dimcloud.nvwa.core.dispatch.Dispatcher;
import io.github.dimcloud.nvwa.core.exception.NvwaInvokerException;
import io.github.dimcloud.nvwa.core.registry.Registry;
import lombok.AllArgsConstructor;
import io.github.dimcloud.nvwa.core.base.Command;
import io.github.dimcloud.nvwa.core.base.Event;
import io.github.dimcloud.nvwa.core.base.Query;
import io.github.dimcloud.nvwa.core.registry.Invoker;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * NvwaBus default implement
 *
 * @author hehe
 * 2020/10/26 7:18 下午
 **/
@AllArgsConstructor
public class DefaultNvwaBus implements NvwaBus{

    private Registry registry;

    private Dispatcher dispatcher;


    @Override
    public <T> T dispatch(Command<T> command) {
        Invoker invoker = registry.getInvoker(command);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by command %s",command.getClass().getName());
        }
        return dispatcher.dispatch(command,invoker);
    }

    @Override
    public <T> CompletableFuture<T> dispatchAsync(Command<T> command) {
        Invoker invoker = registry.getInvoker(command);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by command %s",command.getClass().getName());
        }
        return dispatcher.dispatchAsync(command,invoker);
    }

    @Override
    public <T> void dispatchAsync(Command<T> command, DispatchCallback<T> callback) {
        Invoker invoker = registry.getInvoker(command);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by command %s",command.getClass().getName());
        }
        dispatcher.dispatchAsync(command,invoker,callback);
    }

    public <T> T dispatch(Query<T> query) {
        Invoker invoker = registry.getInvoker(query);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by query %s",query.getClass().getName());
        }
        return dispatcher.dispatch(query,invoker);
    }

    @Override
    public <T> CompletableFuture<T> dispatchAsync(Query<T> query) {
        Invoker invoker = registry.getInvoker(query);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by query %s",query.getClass().getName());
        }
        return dispatcher.dispatchAsync(query,invoker);
    }

    @Override
    public <T> void dispatchAsync(Query<T> query, DispatchCallback<T> callback) {
        Invoker invoker = registry.getInvoker(query);
        if(invoker == null){
            throw new NvwaInvokerException("can't find invoker by query %s",query.getClass().getName());
        }
        dispatcher.dispatchAsync(query,invoker,callback);
    }

    @Override
    public void dispatch(Event event) {
        CopyOnWriteArraySet<Invoker> invokers = registry.getInvokers(event);
        if(invokers == null || invokers.isEmpty()){
            throw new NvwaInvokerException("can't find invokers by event %s",event.getClass().getName());
        }
        invokers.forEach( invoker -> dispatcher.dispatch(event,invoker));
    }
}
