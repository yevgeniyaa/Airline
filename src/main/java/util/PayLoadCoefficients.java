package util;

public enum PayLoadCoefficients {
    CARGO(0.49f),
    PASSENGER(0.12f),;

    private float coefficient;

    PayLoadCoefficients(float coefficient) {
        this.coefficient = coefficient;
    }

    public float getCoefficient() {
        return coefficient;
    }
}
