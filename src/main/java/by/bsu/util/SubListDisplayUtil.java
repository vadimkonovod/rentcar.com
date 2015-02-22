package by.bsu.util;


import java.util.ArrayList;
import java.util.List;

public class SubListDisplayUtil {
    private static SubListDisplayUtil ourInstance = new SubListDisplayUtil();

    public static int CARS_PER_PAGE = 10;

    public static SubListDisplayUtil getInstance() {
        return ourInstance;
    }

    private SubListDisplayUtil() {
    }

    public List extractCarsFromCollection(int pageNumber, List list) {
        int startIndex = (pageNumber - 1) * CARS_PER_PAGE;
        if (pageNumber * CARS_PER_PAGE < list.size()) {
            return new ArrayList<>(list.subList(startIndex, startIndex + 10));
        } else {
            return new ArrayList<>(list.subList(startIndex, list.size()));
        }
    }
}
