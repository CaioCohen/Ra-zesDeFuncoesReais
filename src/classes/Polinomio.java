package classes;

public class Polinomio {
    public float dividir(int x){
        return x/2;
    }

    public Double reta(double x){
        return x + 5;
    }

    public Double terceiroGrau(double x){
        return Math.pow(x, 3) - (2* x) + 1;
    }

    public Double terceiroGrauDerivada(double x){
        return (3*Math.pow(x, 2)) - 2;
    }

    public double log(double x){
        return (x*Math.log10(x))-1;
    }

    public double logDerivada(double x){
        return (Math.log10(x))+(1/Math.log(x));
    }

    public double complexo(double x){
        return Math.sqrt(x);
    }

    public double complexoDerivada(double x){
        return 1/(2*(Math.sqrt(x)));
    }
}
