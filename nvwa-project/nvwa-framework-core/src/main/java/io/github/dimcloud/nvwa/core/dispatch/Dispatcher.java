package io.github.dimcloud.nvwa.core.dispatch;

import io.github.dimcloud.nvwa.core.base.Command;
import io.github.dimcloud.nvwa.core.base.Event;
import io.github.dimcloud.nvwa.core.base.Query;
import io.github.dimcloud.nvwa.core.registry.Invoker;

import java.util.concurrent.CompletableFuture;

/**
 * dispatcher
 *
 * @author hehe
 * @since 1.0.1
 */
public interface Dispatcher {

    /**
     * dispatch event
     * @param event domain event
     * @param invoker invoke method
     */
    void dispatch(Event event, Invoker invoker);


    /**
     * dispatch command sync
     * @param command domain command
     * @param invoker invoke method
     */
    <T> T dispatch(Command<T> command, Invoker invoker);

    /**
     * dispatch event async
     * @param command domain command
     * @param invoker invoke method
     * @return CompletedFuture
     */
    <T> CompletableFuture<T> dispatchAsync(Command<T> command, Invoker invoker);


    /**
     * dispatch event sync
     * @param command domain command
     * @param invoker invoke method
     * @param callback result callback
     */
    <T> void dispatchAsync(Command<T> command,Invoker invoker,DispatchCallback<T> callback);


    /**
     * dispatch query sync
     * @param query domain query
     * @param invoker invoke method
     */
    <T> T dispatch(Query<T> query,Invoker invoker);

    /**
     * dispatch query async
     * @param query domain query
     * @param invoker invoke method
     * @return CompletedFuture
     */
    <T> CompletableFuture<T> dispatchAsync(Query<T> query,Invoker invoker);


    /**
     * dispatch query sync
     * @param query domain query
     * @param invoker invoke method
     * @param callback result callback
     */
    <T> void dispatchAsync(Query<T> query,Invoker invoker,DispatchCallback<T> callback);

}
