package com.fastcampus.kotlinjavaspring.lombok;

import java.util.Objects;
import lombok.ToString;

//@EqualsAndHashCode
@ToString
public class Hero {
  /*
  @Getter
  @Setter
   */
  private String name;

  /*
  @Getter
  @Setter
   */
  private int age;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hero hero = (Hero) o;
    return age == hero.age && Objects.equals(name, hero.name) && Objects.equals(
        address, hero.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, address);
  }

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

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public static void main(String[] args) {
    /*
    Hero hero = new Hero();
    hero.setName("아이언맨");
    hero.setAge(53);
    hero.setAddress("스타크타워");
     */
  }
}
