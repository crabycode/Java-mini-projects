public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Rectangle rectangle1 = new Rectangle(2,3);
        System.out.println(circle1.perimeter());
        System.out.println(circle1.area());
        System.out.println(rectangle1.perimeter());
        System.out.println(rectangle1.area());
    }
}