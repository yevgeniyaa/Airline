package exception;

public class ZeroOrNegativeValueException extends Exception {
    private String nameOfPlane;

    public ZeroOrNegativeValueException(String nameOfPlane) {
        this.nameOfPlane = nameOfPlane;
    }

    public String getMessage() {
        return "[ZeroOrNegativeException]: Numerical characteristics can not be less than or equal to zero in " +
                nameOfPlane.toUpperCase() + ". Plane will not be added to the airline";
    }
}
