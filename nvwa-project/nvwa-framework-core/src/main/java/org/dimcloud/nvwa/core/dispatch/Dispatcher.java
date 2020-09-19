package org.dimcloud.nvwa.core.dispatch;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.dimcloud.nvwa.core.base.Command;
import org.dimcloud.nvwa.core.base.Event;
import org.dimcloud.nvwa.core.base.Query;

/**
 * dispatcher
 *
 * @author hehe
 * @since 1.0.0
 */
public interface Dispatcher {

    /**
     * dispatch event
     * @param event domain event
     */
    void dispatch(Event event);


    /**
     * dispatch command sync
     * @param command domain command
     */
    void dispatch(Command command);

    /**
     * dispatch event async
     * @param command domain command
     * @return CompletedFuture
     */
    CompletedFuture dispatchAsync(Command command);


    /**
     * dispatch event sync
     * @param command domain command
     * @param callback result callback
     */
    void dispatchAsync(Command command,DispatchCallback callback);


    /**
     * dispatch query sync
     * @param query domain query
     */
    void dispatch(Query query);

    /**
     * dispatch query async
     * @param query domain query
     * @return CompletedFuture
     */
    CompletedFuture dispatchAsync(Query query);


    /**
     * dispatch query sync
     * @param query domain query
     * @param callback result callback
     */
    void dispatchAsync(Query query,DispatchCallback callback);

}
