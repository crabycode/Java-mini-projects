import java.util.List;

public class Star extends OrbitalSpaceObject{
    public  Star(String name, int coordinateX, int coordinateY, int coordinateZ, double mass, List<SpaceObject> orbiters){
        super(name, coordinateX, coordinateY, coordinateZ, mass, orbiters);
    }
    @Override
    public void displayInfo()
    {
        System.out.println(getName());
        System.out.println(getCoordinateX());
        System.out.println(getCoordinateY());
        System.out.println(getCoordinateZ());
        System.out.println(getMass());
        for(SpaceObject o : orbiters){
            o.displayInfo();
        }
    }
    @Override
    public void addOrbiters(SpaceObject orbiter){
        orbiters.add(orbiter);
    }

}
