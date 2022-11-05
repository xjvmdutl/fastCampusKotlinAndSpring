package gettersetter;

public class JavaGetterSetterExample {

  public static void main(String[] args) {
    Student student = new Student();
    //setter
    //student.setName("스티브로저스");
    //student.setBirthDate(LocalDate.of(1918, 7, 4));

    //getter
    //System.out.println(student.getName());
    //System.out.println(student.getBirthDate());

    //student.setAge(10);//컴파일 오류 //val 키워드로 선언한 프로퍼티는 setter가 없다.
    System.out.println(student.getAge());


    //student.setGrade(""); //var 키워드지만 private로 선언했기 때문에 외부에서 호출 x
    student.changeGrade("A"); //setter가 아닌 볊도의 메서드를 만들어서 값을 변경하는 방식으로 사용해야한다
    System.out.println(student.getGrade());


    //JVM 필드 사용
    student.name = "스티브로저스";
    System.out.println(student.name);
    //JVMfield를 사용하면 getter, setter를 통해서 접근하는 것이 아닌 프로퍼티로 접근해야한다
  }

}
