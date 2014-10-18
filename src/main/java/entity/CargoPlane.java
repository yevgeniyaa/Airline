package entity;

import util.PayLoadCoefficients;

public class CargoPlane extends Plane {

    private int spaceForCargo;

    protected CargoPlane(String name, int range, float holdingCapacity, int spaceForCargo) {
        super(name, range, holdingCapacity);
        this.spaceForCargo = spaceForCargo;
    }

    @Override
    public float getPayLoad() {
        payLoad = spaceForCargo * PayLoadCoefficients.CARGO.getCoefficient();
        return payLoad;
    }

    @Override
    public String toString() {
        return "Cargo plane \"" + name.toUpperCase() + "\":" + "\n\tRange of flight: " + range + " km\n" +
                "\tHolding capacity: " + holdingCapacity + " tons\n" +
                "\tPayload: " + payLoad + " tons\n" +
                "\tSpace for cargo: " + spaceForCargo + " m3";
    }
}
