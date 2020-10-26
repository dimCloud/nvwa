package org.dimcloud.nvwa.ddd.domain;

/**
 * domain value object
 *
 * @author hehe
 * @since 1.0.0
 */
public interface ValueObject<T extends ValueObject> {

    Boolean sameAs(T other);

}
