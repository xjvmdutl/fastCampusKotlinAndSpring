package com.fastcampus.kotlinjavaspring.gettersetter;

import java.util.UUID;

public class Person {

  private String name;
  private int age;
  private String address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String myAddress() { //getter가 아닌 myAddress일 경우
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUUID(){
    return UUID.randomUUID().toString();
  }
}
