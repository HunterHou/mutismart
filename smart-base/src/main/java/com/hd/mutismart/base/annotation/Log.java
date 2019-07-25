package com.hd.mutismart.base.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Log {

    String value() default "";

    String desc() default "";

    boolean ignore() default false;

}
