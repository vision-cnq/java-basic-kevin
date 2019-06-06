package com.kevin.genericity;

/**
 * @author caonanqing
 * @version 1.0
 * @description     实现泛型接口的泛型类，未传入泛型实参时
 *
 *    未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 *          即：class ImplGenericityInter<T> implements GenericityInter<T>{
 *          如果不声明泛型，如：class ImplGenericityInter implements GenericityInter<T>，编译器会报错："Unknown class"
 * @createDate 2019/6/6
 */
public class ImplGenericityInter1<T> implements  GenericityInter<T> {

    @Override
    public T next() {
        return null;
    }
}
