import java.util.ArrayList;
import java.util.Arrays;

public class GreenTheorem {

    private final double[][] tab;

    public GreenTheorem(double[][] tab) {
        this.tab=tab;
    }

    public double getArea(){
        return this.calculateArea(this.tab);
    }

    private double calculateArea(double[][] tab){
        double result=0;
        for (int i=0;i<tab.length;i++) {

            double x1=tab[i][0];
            double y1=tab[i][1];
            double x2=tab[(i+1)%tab.length][0];
            double y2=tab[(i+1)%tab.length][1];

            if(x1==x2) {
                result +=x1*(y2-y1);
                continue;
            }
            result +=(y2-y1)/(x2-x1)*0.5*(x2*x2-x1*x1);

        }
        return Math.abs(result);
    }



    public boolean checkIfPointIsInArea(double[] point){

        if(point.length!=2) {
            System.out.println("This is now valid point!"); //TODO I'll error this later
            return false;
        }

        double area=this.getArea();
        double area1 =this.calculateArea(this.makeSubArray(this.tab,0,tab.length/2+1,point));
        double area2 =this.calculateArea(this.makeSubArray(this.tab,tab.length/2, tab.length+1,point));

        return Math.abs(area-area1-area2)<Math.pow(0.1,this.tab.length);
    }

    private double[][] makeSubArray(double[][] tab, int start , int end,double[] point){
        double[][] result = new double[end-start+1][2];
        for (int i=start;i<end;i++){
            result[i-start]=tab[i%tab.length];
        }
        result[end-start]=point;
        return result;
    }

}
