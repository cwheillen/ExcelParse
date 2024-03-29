package com.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel注解，用以生成Excel表格文件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Excel {

    /**
     * 列名
     */
    String name() default "";

    /**
     * 宽度
     */
    int width() default 20;

    /**
     * 列名顺序,不指定按照默认顺序排序
     */
    public String column() default "";

    /**
     * 解析时忽略该字段
     */
    boolean skip() default false;

    /**
     * 日期格式化
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 顺序
     * @return
     */
    int num() default 0;

    /**
     * 字符串类型的数据是否需要正则验证
     */
    boolean validate() default false;

    /**
     * 浮点数的精度
     */
    int precision() default -1;

    /**
     * 四舍五入
     */
    boolean round() default false;
}
