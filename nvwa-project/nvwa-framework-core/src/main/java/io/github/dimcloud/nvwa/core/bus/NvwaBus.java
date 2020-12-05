package io.github.dimcloud.nvwa.core.bus;

import io.github.dimcloud.nvwa.core.base.Command;
import io.github.dimcloud.nvwa.core.base.Event;
import io.github.dimcloud.nvwa.core.base.Query;
import io.github.dimcloud.nvwa.core.dispatch.DispatchCallback;

import java.util.concurrent.CompletableFuture;

/**
 * bus core
 *
 * @author hehe
 * 2020/10/26 7:16 下午
 **/
public interface NvwaBus {


    /**
     * dispatch command
     */
    <T> T dispatch(Command<T> command);


    /**
     * dispatch command async
     */
    <T> CompletableFuture<T> dispatchAsync(Command<T> command);


    /**
     * dispatch command async
     */
    <T> void dispatchAsync(Command<T> command, DispatchCallback<T> callback);


    /**
     * dispatch query
     */
    <T> T dispatch(Query<T> query);

    /**
     * dispatch query async
     */
    <T> CompletableFuture<T> dispatchAsync(Query<T> query);

    /**
     * dispatch query async
     */
    <T> void dispatchAsync(Query<T> command, DispatchCallback<T> callback);


    /**
     * dispatch eventW
     */
    void dispatch(Event event);

}
