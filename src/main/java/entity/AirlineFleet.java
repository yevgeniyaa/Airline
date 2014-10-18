package entity;

import java.util.ArrayList;
import java.util.List;

public class AirlineFleet {

    private String name;
    private List<Plane> planesList = new ArrayList<Plane>();

    public AirlineFleet(String name) {
        this.name = name;
    }

    public List<Plane> getPlanesList() {
        return planesList;
    }

    public String getName() {
        return this.name;
    }
}
