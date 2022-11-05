package com.fastcampus.kotlinjavaspring.exception;

import java.io.InputStream;

public class JavaKeyword {

  private InputStream in; //해당 프로퍼티는 코틀린의 키워드라 문제가 있다.
  private Boolean is;

  public InputStream getIn() {
    return in;
  }

  public void setIn(InputStream in) {
    this.in = in;
  }

  public Boolean getIs() {
    return is;
  }

  public void setIs(Boolean is) {
    this.is = is;
  }
}

enum CountryCodeJava {
  kr, jp, us;//, do;//do라는 도미니카 공화국을 추가하기 어렵다
}