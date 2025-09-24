public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", 19);
        Student student1 = new Student("Petar", 17, 5);
        person.introduce();
        person.printDetails();
        student1.introduce();
        student1.printDetails();
    }
}