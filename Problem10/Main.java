package Problem10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de cidades a serem permutadas (exceto a inicial)
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("B", 4, 4));
        cities.add(new City("C", 6, 1));
        cities.add(new City("D", 7, 6));
        cities.add(new City("E", 3, 8));
        cities.add(new City("F", 8, 2));
        cities.add(new City("G", 5, 5));
        cities.add(new City("H", 9, 9));
        cities.add(new City("I", 2, 7));
        cities.add(new City("J", 0, 0));

        City startingCity = new City("A", 1, 3);


        TravelingSalesmanSolver salesmanSolver = new TravelingSalesmanSolver();
        salesmanSolver.permute(cities, 0, startingCity);
        salesmanSolver.printBestPath(startingCity);
    }
}
