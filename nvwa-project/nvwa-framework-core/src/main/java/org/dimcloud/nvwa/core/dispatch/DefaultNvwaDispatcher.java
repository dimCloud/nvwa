package org.dimcloud.nvwa.core.dispatch;

import org.dimcloud.nvwa.core.base.Command;
import org.dimcloud.nvwa.core.base.Event;
import org.dimcloud.nvwa.core.base.Query;
import org.dimcloud.nvwa.core.registry.Invoker;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * dispatcher implement
 *
 * @author hehe
 * 2020/10/26 7:27 下午
 **/
public class DefaultNvwaDispatcher implements Dispatcher{

    private final Executor defaultExecutor;

    public DefaultNvwaDispatcher(){
        //TODO
        defaultExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void dispatch(Event event, Invoker invoker) {
        CompletableFuture.runAsync( () -> invoker.invoke(event),defaultExecutor);
    }

    @Override
    public <T> T dispatch(Command<T> command, Invoker invoker) {
        return (T)invoker.invoke(command);
    }

    @Override
    public <T> CompletableFuture<T> dispatchAsync(Command<T> command, Invoker invoker) {
        return CompletableFuture.supplyAsync( () -> (T) invoker.invoke(command),defaultExecutor);
    }

    @Override
    public <T> void dispatchAsync(Command<T> command, Invoker invoker, DispatchCallback<T> callback) {
        CompletableFuture.supplyAsync( () -> (T) invoker.invoke(command),defaultExecutor)
        .whenComplete( (ret,throwable) -> callback.callback(ret,throwable));
    }

    @Override
    public <T> T dispatch(Query<T> query, Invoker invoker) {
        return (T)invoker.invoke(query);
    }

    @Override
    public <T> CompletableFuture<T> dispatchAsync(Query<T> query, Invoker invoker) {
        return CompletableFuture.supplyAsync( () -> (T) invoker.invoke(query),defaultExecutor);
    }

    @Override
    public <T> void dispatchAsync(Query<T> query, Invoker invoker, DispatchCallback<T> callback) {
        CompletableFuture.supplyAsync( () -> (T) invoker.invoke(query),defaultExecutor)
                .whenComplete( (ret,throwable) -> callback.callback(ret,throwable));
    }
}
