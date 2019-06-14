package com.morgana.mq.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@Documented  
public @interface TransMessage {
	String exchange() default "";
	String bindingKey() default "";
	String bizName() default "";
	String dbCoordinator() default "";
}  
