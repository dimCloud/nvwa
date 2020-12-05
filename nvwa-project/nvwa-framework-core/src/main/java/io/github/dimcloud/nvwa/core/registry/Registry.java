package io.github.dimcloud.nvwa.core.registry;

import io.github.dimcloud.nvwa.core.base.Command;
import io.github.dimcloud.nvwa.core.base.Event;
import io.github.dimcloud.nvwa.core.base.Query;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * command,query,event registry
 *
 * @author hehe
 * @since 1.0.1
 */
public interface Registry {

    /**
     * query command event regist
     * @param listener
     */
    void regist(Object listener);


    /**
     * unRegist listener
     * @param listener
     */
    void unRegist(Object listener);

    /**
     * event registry
     * @param event domain event
     */
    CopyOnWriteArraySet<Invoker> getInvokers(Event event);

    /**
     * event registry
     * @param command
     */
    Invoker getInvoker(Command command);


    /**
     * event registry
     * @param query
     */
    Invoker getInvoker(Query query);

}
