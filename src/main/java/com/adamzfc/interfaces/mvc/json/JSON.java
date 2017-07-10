package com.adamzfc.interfaces.mvc.json;

import java.lang.annotation.*;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(JSONS.class)
public @interface JSON {
    Class<?> type();
    String include() default "";
    String filter() default "";
}
