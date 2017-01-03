package hbi.core.task.util;

import org.apache.ibatis.type.JdbcType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenhe on 2016/12/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MappedJdbcTypes {
    public JdbcType[] value();
    boolean includeNullJdbcType() default false;
}
