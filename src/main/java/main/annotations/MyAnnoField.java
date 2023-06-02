package main.annotations;
//https://habr.com/ru/articles/139736/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnoField {
    String name();
    String type() default "string";
}

@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
@interface MyAnnoMethods {
}

class SomeString{
    @MyAnnoField(name = "text")
    String text2;
}


/*
Аннотация @Retention позволяет указать жизненный цикл аннотации:
будет она присутствовать только в исходном коде, в
скомпилированном файле, или она будет также видна и
в процессе выполнения. Выбор нужного типа зависит от
того, как вы хотите использовать аннотацию, например,
генерировать что-то побочное из исходных кодов, или в
процессе выполнения стучаться к классу через reflection.

Аннотация @Target указывает, что именно мы можем пометить
этой аннотацией, это может быть поле, метод, тип и т.д.

Аннотация @Documentedуказывает, что помеченная таким образом
аннотация должна быть добавлена в javadoc поля/метода и т.д.
Например, класс, помеченный аннотацией без @Documented,
 будет выглядеть так:
* */