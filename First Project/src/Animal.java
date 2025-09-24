public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void speak()
    {
        System.out.println("Hello! My name is "+this.name+" and I am "+this.age+" years old.");
    }
}


