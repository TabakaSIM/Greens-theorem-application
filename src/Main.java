import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] tab =
                {{6, 6}
                ,{-6, 6}
                ,{-6, -6}
                ,{6,-6}};

        double[] point1 = {0,0};
        double[] point2 = {100,200};

        GreenTheorem green = new GreenTheorem(tab);

        System.out.println("Area of figure: " + green.getArea());
        System.out.println("Is point1 in area: " + green.checkIfPointIsInArea(point1));
        System.out.println("Is point2 in area: " + green.checkIfPointIsInArea(point2));
    }
}