package org.dimcloud.nvwa.core.registry;

import org.dimcloud.nvwa.core.base.Command;
import org.dimcloud.nvwa.core.base.Event;
import org.dimcloud.nvwa.core.base.Query;

/**
 * command,query,event registry
 *
 * @author hehe
 * @since 1.0.0
 */
public interface Registry {

    /**
     * event registry
     * @param event domain event
     */
    void regist(Event event);

    /**
     * cmd registry
     * @param command domain command
     */
    void regist(Command command);


    /**
     * event registry
     * @param query domain query
     */
    void regist(Query query);

}
