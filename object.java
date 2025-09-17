class Student {
    String name;
    int age;

    public  void  printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    Student( ){
        System.out.println("Constructor Called");

    }
}
class Object{
    public static void main(String arg[]){
        Student s1 = new Student();
        s1.name = "Rohit";
        s1.age = 22;

        s1.printInfo();
    }
}