package extensions;

public class ExtensionExample {

  public static void main(String[] args) {
    /*
     "ABCD".first();
     "ABCD".addFirst('Z'); //컴파일 오류 발생
     */
    char first = MyExtensionsKt.first("ABCD");
    System.out.println(first);

    String addFirst = MyExtensionsKt.addFirst("ABCD", 'Z');
    System.out.println(addFirst);
  }
}
