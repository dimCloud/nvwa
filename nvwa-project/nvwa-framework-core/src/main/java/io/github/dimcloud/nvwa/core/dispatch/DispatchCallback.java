package io.github.dimcloud.nvwa.core.dispatch;

/**
 * description
 *
 * @author hehe
 * @since 1.0.1
 */
public interface DispatchCallback<T> {

    /**
     * dispatch async callback
     */
    void callback(T ret,Throwable throwable);

}
