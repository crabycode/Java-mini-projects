import java.util.List;

abstract class OrbitalSpaceObject extends SpaceObject {
    List<SpaceObject> orbiters;
    public OrbitalSpaceObject(String name, int coordinateX, int coordinateY, int coordinateZ, double mass, List<SpaceObject> orbiters)
    {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        this.orbiters = orbiters;
    }

    abstract void addOrbiters(SpaceObject orbiter);
    public List<SpaceObject> getOrbiters()
    {
        return orbiters;
    }
}
