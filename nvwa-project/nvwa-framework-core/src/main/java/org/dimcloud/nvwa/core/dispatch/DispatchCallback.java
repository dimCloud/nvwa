package org.dimcloud.nvwa.core.dispatch;

/**
 * description
 *
 * @author hehe
 * @since 1.0.0
 */
public interface DispatchCallback<T> {

    /**
     * dispatch async callback
     */
    void callback(T ret,Throwable throwable);

}
