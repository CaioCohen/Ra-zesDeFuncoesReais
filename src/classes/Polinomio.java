package classes;

public class Polinomio {
    public float dividir(int x){
        return x/2;
    }

    public Double reta(double x){
        return x + 5;
    }

    public Double terceiroGrau(double x){
        return Math.pow(x, 3) + Math.pow(x, 2) - 30;
    }

    public Double terceiroGrauDerivada(double x){
        return (3*Math.pow(x, 2)) + (2*x);
    }
}
