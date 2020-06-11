package Annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/*
* 对于类来说，子类要继承父类的注解需要该注解被 @Inherited 标识。
对于成员属性和方法来说，非重写的都会保持和父类一样的注解，而被实现的抽象方法，被重写的方法都不会有父类的注解
*/
@Inherited
@Documented
public @interface ParamDefaultValue {
    String value();
}
