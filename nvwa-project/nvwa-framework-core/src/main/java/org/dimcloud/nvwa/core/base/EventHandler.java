package org.dimcloud.nvwa.core.base;

import java.lang.annotation.*;

/**
 * handle domain event
 *
 * @author hehe
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    String desc() default "";
}
