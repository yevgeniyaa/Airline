package entity;

import exception.ZeroOrNegativeValueException;
import util.IPropertiesHolder;

import java.util.List;

public class AirlineFleetCreator implements IPropertiesHolder {

    AirlineFleet airlineFleet;

    public AirlineFleet createAirlineFleet(String name, List<List<String>> listOfPlanesFeatures) {
        airlineFleet = new AirlineFleet(name);
        if (listOfPlanesFeatures != null && listOfPlanesFeatures.size() > 0) {
            PlaneFactory planeFactory = new PlaneFactory();
            for (List<String> subList : listOfPlanesFeatures) {
                try {
                    addPlane(planeFactory.createPlane(subList.get(NAME_OF_PLANE_INDEX),
                            subList.get(TYPE_OF_PLANE_INDEX), Integer.parseInt(subList.get(RANGE_INDEX)),
                            Float.parseFloat(subList.get(HOLDING_CAPACITY_INDEX)),
                            Integer.parseInt(subList.get(ADDITIONAL_PARAM_INDEX))));
                } catch (NumberFormatException e) {
                    System.err.println("[NumberFormatException]: Incorrect format of argument value in " +
                            subList.get(NAME_OF_PLANE_INDEX).toUpperCase() +
                            ". Plane will not be added to the airline");
                } catch (ZeroOrNegativeValueException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return airlineFleet;
    }

    public AirlineFleet createAirlineFleet(String name) {
        return createAirlineFleet(name, null);
    }

    public void addPlane(Plane plane) {
        airlineFleet.getPlanesList().add(plane);
    }
}
