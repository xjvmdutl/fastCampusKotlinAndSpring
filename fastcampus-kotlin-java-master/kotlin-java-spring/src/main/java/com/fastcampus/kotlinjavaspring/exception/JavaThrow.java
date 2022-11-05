package com.fastcampus.kotlinjavaspring.exception;

import exception.KotlinThrow;
import java.io.IOException;

public class JavaThrow {

  public void throwIOException() throws IOException {
    //호출 시, try-catch로 감싸거나 예외를 전파해야한다
    throw new IOException("체크드 익셉션인 IOException 발생");
  }

  public static void main(String[] args) {
    /*
      JavaThrow javaThrow = new JavaThrow();
      try {
        javaThrow.throwIOException(); //checked exception이 발생했기 때문에 전파하거나 try-catch로 잡아야한다
      } catch (IOException e) {
        e.printStackTrace();
      }
    */
    //코틀린의 예외코드 호출
    KotlinThrow kotlinThrow = new KotlinThrow();
    //kotlinThrow.throwIOException(); //코틀린의 예외 코드를 실행하여도 try-catch를 강제하지 않아도 된다.
    //만약 try-catch를 하게 된다면, 컴파일 오류가 발생한다.
    //@Throws 어노테이션이 있다면 오류가 발생하지 않는다
    try {
      kotlinThrow.throwIOException();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
