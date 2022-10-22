import java.util.Optional;

public class Java_NullSafety {

  public static String getNullStr() {
    return null;
  }

  public static int getLengthIfNotNull(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    return str.length();
  }

  public static void main(String[] args) {
    String nullableStr = getNullStr();
    // Optional 사용
    nullableStr = Optional.ofNullable(nullableStr)
        .orElse("null 인 경우 반환");
    int nullableStrLength = nullableStr.length();
    // Optional을 주석처리하고 null 참조를 사용하더라도 컴파일 오류가 발생하지 않음
    System.out.println(nullableStrLength);
    //메서드 내부에서 null을 검사하는 방법도 있다
    int length = getLengthIfNotNull(null);
    System.out.println(length);
  }
}