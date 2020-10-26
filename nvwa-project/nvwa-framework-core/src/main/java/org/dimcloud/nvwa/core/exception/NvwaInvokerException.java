package org.dimcloud.nvwa.core.exception;

/**
 * description
 *
 * @author feiyu
 * 2020/10/26 7:47 下午
 **/
public class NvwaInvokerException extends RuntimeException{

    public NvwaInvokerException(String msg){
        super(msg);
    }

    public NvwaInvokerException(String msg,Object... args){
        super(String.format(msg,args));
    }

    public NvwaInvokerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NvwaInvokerException(Throwable cause) {
        super(cause);
    }

    public NvwaInvokerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
