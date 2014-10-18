package util;

public interface IPropertiesHolder {
    String AIRLINE_NAME = "AirPanama";

    //files
    String FILE_NAME_INPUT = "\\files\\Planes";
    String FILE_NAME_OUTPUT = "\\files\\PlanesOutput";

    //for search
    int MIN_RANGE_BORDER = 2500;
    int MAX_RANGE_BORDER = 10000;

    //file structure
    int NAME_OF_PLANE_INDEX = 0;
    int TYPE_OF_PLANE_INDEX = 1;
    int RANGE_INDEX = 2;
    int HOLDING_CAPACITY_INDEX = 3;
    int ADDITIONAL_PARAM_INDEX = 4;
}
