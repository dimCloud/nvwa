package org.dimcloud.nvwa.core.registry;

import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dimcloud.nvwa.core.exception.NvwaInvokerException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * method invoker
 *
 * @author feiyu
 * 2020/10/26 7:40 下午
 **/
public class Invoker {

    @Getter
    private Object listener;

    @Getter
    private Method method;


    public Invoker(@NonNull Object listener, @NonNull Method method){
        this.listener = listener;
        this.method = method;
        this.method.setAccessible(true);
    }

    public Object invoke(@NonNull Object parameter){
        try {
            return this.method.invoke(listener,parameter);
        } catch (IllegalAccessException e) {
            throw new NvwaInvokerException(e);
        } catch (InvocationTargetException e) {
            throw new NvwaInvokerException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Invoker invoker = (Invoker) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(listener, invoker.listener)
                .append(method, invoker.method)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(listener)
                .append(method)
                .toHashCode();
    }
}
