public class Satellite extends SpaceObject{
    public Satellite(String name, int coordinateX, int coordinateY, int coordinateZ, double mass)
    {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
    }

    public void displayInfo()
    {
        System.out.println(getName());
        System.out.println(getCoordinateX());
        System.out.println(getCoordinateY());
        System.out.println(getCoordinateZ());
        System.out.println(getMass());
    }

}
