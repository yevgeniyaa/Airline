package entity;

import util.PayLoadCoefficients;

public class PassengerPlane extends Plane {

    private int numberOfSeats;

    protected PassengerPlane(String name, int range, float holdingCapacity, int numberOfSeats) {
        super(name, range, holdingCapacity);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public float getPayLoad() {
        payLoad = numberOfSeats * PayLoadCoefficients.PASSENGER.getCoefficient();
        return payLoad;
    }

    @Override
    public String toString() {
        return "Passenger plane \"" + name.toUpperCase() + "\":" + "\n\tRange of flight: " + range + " km\n" +
                "\tHolding capacity: " + holdingCapacity + " tons\n" +
                "\tPayload: " + payLoad + " tons\n" +
                "\tNumber of seats: " + numberOfSeats;
    }
}
