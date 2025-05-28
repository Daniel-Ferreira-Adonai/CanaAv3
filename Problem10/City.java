package Problem10;

public class City {
    public String name;

    public double x;

    public double y;

    // a cidade possui 2 pontos, x e y, tipo um plano cartesiano
    public City(String name, double x, double y){
        this.name  = name;
        this.x = x;
        this.y = y;
    }

    //formula da distancia em um reta
    public double euclidianaDistance(City city2) {
        return Math.sqrt(Math.pow(this.x - city2.x, 2) + Math.pow(this.y - city2.y, 2));
    };


    @Override
    public String toString() {
        return name + "(" + x + "," + y + ")";
    }
}
