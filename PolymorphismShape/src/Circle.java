public class Circle extends Shape{
    int r;
    public Circle(int r) {
        this.r = r;
    }
    @Override
    public int perimeter(){
        return 2*r*r;
    }
    public double area(){
        return 3.14*r*r;
    }
}
