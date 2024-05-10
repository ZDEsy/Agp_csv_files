public class Car extends CarsList{
    private final int route_km;
    private final double refuel_price;

    /**
     * Car constructor including all attributes from all columns
     * @param id - identifier String of car, unique for every car
     * @param car - Car name String, includes Volvo, BMW or Superb
     * @param date - date of ride in String
     * @param route_from - starting city in String
     * @param route_to - ending city in String
     * @param route_km - kilometers traveled in integer
     * @param refuel_price - price of filling the tank in double, can be null
     * @param refuel_volume - volume of tanking in double, can be null
     */
    public Car(String id, String car, String date, String route_from, String route_to, int route_km, double refuel_price, double refuel_volume)
    {
        this.route_km = route_km;
        this.refuel_price = refuel_price;
    }

    //Getters
    public int getRoute_km() {
        return route_km;
    }

    public double getRefuel_price() {
        return refuel_price;
    }
}
