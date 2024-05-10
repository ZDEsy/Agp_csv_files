import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CarsList extends JFrame {
    private final List<Car> volvoList = new ArrayList<>();
    private final List<Car> bmwList = new ArrayList<>();
    private final List<Car> superbList = new ArrayList<>();

    /**
     * Method to fill each list for specific car based on model
     * @param path - path to selected file
     * @throws IOException - exception in case there is a problem with file
     */
    public void fillLists(Path path) throws IOException {
        for(String line : Files.readAllLines(path))
        {
            String[] oneLine = line.split(",");
            switch (oneLine[1])
            {
                case "Volvo":
                    volvoList.add(new Car(oneLine[0], oneLine[1], oneLine[2], oneLine[3], oneLine[4], Integer.parseInt(oneLine[5]), Double.parseDouble(oneLine[6]), Double.parseDouble(oneLine[7])));
                case "BMW":
                    bmwList.add(new Car(oneLine[0], oneLine[1], oneLine[2], oneLine[3], oneLine[4], Integer.parseInt(oneLine[5]), Double.parseDouble(oneLine[6]), Double.parseDouble(oneLine[7])));
                case "Superb":
                    superbList.add(new Car(oneLine[0], oneLine[1], oneLine[2], oneLine[3], oneLine[4], Integer.parseInt(oneLine[5]), Double.parseDouble(oneLine[6]), Double.parseDouble(oneLine[7])));
            }
        }
    }

    /**
     * Method used to calculate kilometers traveled
     *
     * @param list - list of Car objects
     * @return - kilometerSum integer
     */
    public int kilometerSum(List<Car> list)
    {
        int kilometerSum = 0;
        for(Car car : list)
        {
            kilometerSum += car.getRoute_km();
        }
        return kilometerSum;
    }

    /**
     * Method used to calculate average tanking price for a selected car
     * @param list - list of Car objects
     * @return - average tankPrice double
     */
    public double averageTankPrice(List<Car> list)
    {
        double tankPrice = 0;
        int division = 0;
        for(Car car : list)
        {
            tankPrice += car.getRefuel_price();
            division++;
        }
        return tankPrice/division;
    }

    //Getters

    public List<Car> getVolvoList() {
        return volvoList;
    }

    public List<Car> getBmwList() {
        return bmwList;
    }

    public List<Car> getSuperbList() {
        return superbList;
    }
}