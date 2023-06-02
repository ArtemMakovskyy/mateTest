package main.annotations;

import java.lang.annotation.Inherited;

@Inherited
@interface PublicAnnotate { }

@interface PrivateAnnotate { }

@PublicAnnotate
@PrivateAnnotate
class ParentClass { }

class ChildClass extends ParentClass {
    /**Класс ChildClass унаследует от родительского класса только аннотацию PublicAnnotate.**/
}