package com.fastcampus.kotlinjavaspring.jvmstatic;

import jvmstatic.HelloClass;
import jvmstatic.HiObject;

public class JvmStaticExample {

    public static void main(String[] args) {
        //String hello = HelloClass.Companion.hello();
        //String hi = HiObject.INSTANCE.hi();//객체를 생성하는 INSTANCE를 사용해서 생성후 사용해야한다,
        //@JvmStatic을 사용하게 되면, 자바에서 static 메서드를 호출하듯이 호출할 수 있다
        HelloClass.hello();
        HiObject.hi();
    }
}
