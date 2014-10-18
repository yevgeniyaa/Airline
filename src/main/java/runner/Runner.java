package runner;

import entity.AirlineFleet;
import entity.AirlineFleetCreator;
import util.AirlineFleetLogic;
import util.IPropertiesHolder;
import util.PropertiesReader;
import util.TextFileWriter;

public class Runner {
    public static void main(String[] args) {
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.loadProperty();
        TextFileWriter.writeToFile("Properties have been loaded.", true);

        AirlineFleet airlineFleet = new AirlineFleetCreator().createAirlineFleet(IPropertiesHolder.AIRLINE_NAME,
                propertiesReader.getProperties());
        TextFileWriter.writeToFile("\nAirline has been created and filled.");

        AirlineFleetLogic.sortPlanesByPayLoad(airlineFleet);
        TextFileWriter.writeToFile("\n\nPlanes have been sorted by payload:\n" + AirlineFleetLogic
                .getTotalInformation(airlineFleet));
        AirlineFleetLogic.sortPlanesByRange(airlineFleet);
        TextFileWriter.writeToFile("\n\nPlanes have been sorted by range:\n" + AirlineFleetLogic
                .getTotalInformation(airlineFleet));

        TextFileWriter.writeToFile("\n\nFind planes with range of flight within " + IPropertiesHolder.MIN_RANGE_BORDER +
                " and " + IPropertiesHolder.MAX_RANGE_BORDER + " km.");
        AirlineFleet airlineFleetSearchResult = AirlineFleetLogic.searchPlanesByRangeOfFlight(airlineFleet,
                IPropertiesHolder.MIN_RANGE_BORDER, IPropertiesHolder.MAX_RANGE_BORDER);
        TextFileWriter.writeToFile("Search has completed.\n" + AirlineFleetLogic
                .getTotalInformation(airlineFleetSearchResult));
    }
}
