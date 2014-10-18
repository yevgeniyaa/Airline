package entity;

import exception.ZeroOrNegativeValueException;

public class PlaneFactory {

    public enum TypeOfPlane {CARGO, PASSENGER}
    public Plane createPlane(String name, String type, int range, float holdingCapacity, int additionalParam)
            throws ZeroOrNegativeValueException {

        if (range <= 0 || holdingCapacity <= 0 || additionalParam <= 0)
            throw new ZeroOrNegativeValueException(name);

        TypeOfPlane typeOfPlane = TypeOfPlane.valueOf(type.toUpperCase());
        Plane plane;

        switch (typeOfPlane) {
            case CARGO:
                plane = new CargoPlane(name, range, holdingCapacity, additionalParam);
                break;
            case PASSENGER:
                plane = new PassengerPlane(name, range, holdingCapacity, additionalParam);
                break;
            default:
                throw new EnumConstantNotPresentException(TypeOfPlane.class, typeOfPlane.name());
        }
        return plane;
    }
}
