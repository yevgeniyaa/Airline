package util;

import entity.AirlineFleet;
import entity.AirlineFleetCreator;
import entity.Plane;

import java.util.Collections;
import java.util.Comparator;

public class AirlineFleetLogic {

    /**
     * AirlineFleetSorter: sort list of planes by range of flight in ascending order
     *
     * @param airlineFleet airline fleet to sort
     */
    public static void sortPlanesByRange(AirlineFleet airlineFleet) {
        Collections.sort(airlineFleet.getPlanesList(), orderPlanesByRange);
    }

    private static Comparator<Plane> orderPlanesByRange = new Comparator<Plane>() {
        public int compare(Plane firstPlane, Plane secondPlane) {
            if (secondPlane.getRange() < firstPlane.getRange()) return 1;
            if (secondPlane.getRange() == firstPlane.getRange()) return 0;
            else return -1;
        }
    };

    /**
     * AirlineFleetSorter: sort list of planes by their payload in ascending order
     *
     * @param airlineFleet airline fleet to sort
     */
    public static void sortPlanesByPayLoad(AirlineFleet airlineFleet) {
        Collections.sort(airlineFleet.getPlanesList(), orderPlanesByPayLoad);
    }

    private static Comparator<Plane> orderPlanesByPayLoad = new Comparator<Plane>() {
        public int compare(Plane firstPlane, Plane secondPlane) {
            if (secondPlane.getPayLoad() < firstPlane.getPayLoad()) return 1;
            if (secondPlane.getPayLoad() == firstPlane.getPayLoad()) return 0;
            else return -1;
        }
    };

    /**
     * AirlineFleetSearcher: search planes in the airline within specified values of flight ranges
     *
     * @param airlineFleet airline fleet to search into
     * @param firstBorder  value of the first border of flight range
     * @param secondBorder value of the second border of flight range
     * @return result of search of AirlineFleet type
     */
    public static AirlineFleet searchPlanesByRangeOfFlight(AirlineFleet airlineFleet, int firstBorder, int secondBorder) {
        if (secondBorder < firstBorder) {
            int temp = secondBorder;
            secondBorder = firstBorder;
            firstBorder = temp;
        }

        AirlineFleetCreator airlineFleetCreator = new AirlineFleetCreator();
        AirlineFleet resultAirlineFleet = airlineFleetCreator.createAirlineFleet("Search results [" + firstBorder + "; "
                + secondBorder + "]");

        for (Plane plane : airlineFleet.getPlanesList()) {
            if (plane.getRange() >= firstBorder && plane.getRange() <= secondBorder) {
                airlineFleetCreator.addPlane(plane);
            }
        }

        return resultAirlineFleet;
    }

    public static String getTotalInformation(AirlineFleet airlineFleet) {
        int planesAmount = 0;
        int totalHoldingCapacity = 0;
        int totalPayLoad = 0;

        String airFleetInfo = "---->> " + airlineFleet.getName() + " <<----\n";
        if (airlineFleet.getPlanesList().size() > 0) {
            for (Plane plane : airlineFleet.getPlanesList()) {
                airFleetInfo += plane.toString() + "\n";

                planesAmount++;
                totalHoldingCapacity += plane.getHoldingCapacity();
                totalPayLoad += plane.getPayLoad();
            }
            airFleetInfo += "\n===========================\nTotal amount of planes is: " + planesAmount +
                    "\nTotal holding capacity is: " + totalHoldingCapacity + " tons\n" +
                    "Total payload is: " + totalPayLoad + " tons";
        } else
            airFleetInfo += "There are no planes.\n";

        return airFleetInfo;
    }
}
