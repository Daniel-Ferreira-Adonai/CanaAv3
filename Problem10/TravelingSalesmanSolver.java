package Problem10;

import java.util.ArrayList;
import java.util.Collections;

public class TravelingSalesmanSolver {

    public ArrayList<City> bestPathList = new ArrayList<>();

    public double bestDistance = Double.MAX_VALUE;

    public void permute(ArrayList<City> cityList, int index, City startingCity){
        if(index == cityList.size() - 1) {
            //declaração de variaveis uteis, distancai total, cidade anterior e o caminho que estamos seguindo nesse momento
            double totalDistance = 0;
            City previousCity = startingCity;
            ArrayList<City> currentPath = new ArrayList<>();

            for(City x : cityList) {
                // aq basicamente a gente ta percorrendo a lista e somando a distancia a distancia total e adicionando ao caminho total
                totalDistance += previousCity.euclidianaDistance(x);
                currentPath.add(x);
                previousCity = x;
            }
            // distancia do ultimo pro inicio
            totalDistance += previousCity.euclidianaDistance(startingCity);

                //escolhendo as melhores distancias e caminho
            if(totalDistance < bestDistance) {
                bestDistance = totalDistance;
                bestPathList = new ArrayList<>(currentPath);
            }

        }  else{
            //aq é onde tu faz a troca, aq um exemplo supondo index 0 e i = 1 [A,B,C]
            for(int i = index; i < cityList.size(); i++){
                Collections.swap(cityList,i , index); // [B,A,C]
                permute(cityList,index + 1, startingCity); //chamda recursiva
                Collections.swap(cityList,i,index); // [A,B,C]
                //dai a proxima iteração vai fazer a outra possibilidade e por ai vai
            }
        }
    }

    public void printBestPath(City start) {
        if (bestPathList.isEmpty()) {
            System.out.println("Nenhum caminho foi encontrado.");
            return;
        }

        System.out.println("Melhor caminho encontrado:");
        double total = 0;

        System.out.print(start.name);
        City previous = start;

        for (City current : bestPathList) {
            double dist = previous.euclidianaDistance(current);
            total += dist;
            System.out.printf(" -- %.2f --> %s", dist, current.name);
            previous = current;
        }

        // Volta ao início
        double backDist = previous.euclidianaDistance(start);
        total += backDist;
        System.out.printf(" -- %.2f --> %s", backDist, start.name);
        System.out.printf("\nDistância total: %.2f\n", total);
    }

}
