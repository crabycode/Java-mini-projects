public class Student extends Person implements Printable {
    private int grade;
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    @Override
    public void printDetails() {
        System.out.println("name: " +getName() + "\nage: "+ getAge() + "grade: "+ grade);
    }
    public void introduce(){
        System.out.println("My name is "+ getName() + " and I am " + getAge() +" years old." +
                "I have a grade of " + grade);
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
