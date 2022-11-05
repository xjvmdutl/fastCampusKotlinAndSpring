package com.fastcampus.kotlinjavaspring.jvmstatic;

import jvmstatic.JvmFieldClass;
import jvmstatic.JvmFieldObject;

public class JvmFieldExample {

    public static void main(String[] args) {
        //int id = JvmFieldClass.Companion.getId();
        //String name = JvmFieldObject.INSTANCE.getName(); //중간에 Companion, INSTANCE 를통해 접근해야한다.

        int code = JvmFieldClass.CODE; //상수는 바로 접근 가능
        String familyName = JvmFieldObject.FAMILY_NAME;

        int id = JvmFieldClass.id; //@JvmField 애노테이션이 있으면 직접 접근이 가능하다
        String name = JvmFieldObject.name;
    }
}
