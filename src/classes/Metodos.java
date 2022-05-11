package classes;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Metodos {
    private double E = 0.0000001;
    private double lambda = 0.001;
    
    public double bissecao(Function<Double,Double> funcao, double a, double b){
        boolean signalA = funcao.apply(a) > 0;
        boolean singnalB = funcao.apply(b) > 0;
        double novoIntervalo = (a+b)/2;
        boolean signalNI = funcao.apply(novoIntervalo) > 0;
        if(signalNI ^ signalA){
            b = novoIntervalo;
        }
        else{
            a = novoIntervalo;
        }
        if(!(signalA ^ singnalB)){
            System.out.println("não há raiz única no intervalo dadao");
            return 0;
        }
        System.out.println("valor de csi: " + novoIntervalo + " f(csi): " + funcao.apply(novoIntervalo));
        if(Math.abs(funcao.apply(novoIntervalo)) < E){
            return novoIntervalo;
        }
        return bissecao(funcao, a, b);
    }

    public double falsaPosicao(Function<Double,Double> funcao, double a, double b){
        boolean signalA = funcao.apply(a) > 0;
        boolean singnalB = funcao.apply(b) > 0;
        double novoIntervalo = a - funcao.apply(a);
        boolean signalNI = funcao.apply(novoIntervalo) > 0;
        if(signalNI ^ signalA){
            b = novoIntervalo;
        }
        else{
            a = novoIntervalo;
        }
        if(!(signalA ^ singnalB)){
            System.out.println("não há raiz única no intervalo dado");
            return 0;
        }
        System.out.println("valor de csi: " + novoIntervalo + " f(csi): " + funcao.apply(novoIntervalo));
        if(Math.abs(funcao.apply(novoIntervalo)) < E){
            return novoIntervalo;
        }
        return bissecao(funcao, a, b);
    }

    public double newtonRaphson(Function<Double,Double> f,Function<Double,Double> flinha, int k, double x0){
        double xk = x0;
        //System.out.println("valor de csi: " + xk + " f(csi): " + f.apply(xk));
        try{
            xk = xk - (f.apply(xk) / flinha.apply(xk));
        }catch(Exception ex){
            System.out.println("a derivada da raiz é 0, então o método não funciona");
        }
        k += 1;
        if((Math.abs(f.apply(xk)) < E) || k >= 100){
            System.out.println("iteracoes: " + k);
            return xk;
        }
        return newtonRaphson(f, flinha, k, xk);
    }

    public double newtonRaphsonAlternativo(Function<Double,Double> f,Function<Double,Double> flinha, int k,double xn, double x0){
        double xk = xn;
        System.out.println("valor de csi: " + xk + " f(csi): " + f.apply(xk));
        try{
            xk = xk - (f.apply(xk) / flinha.apply(x0));
        }catch(Exception ex){
            System.out.println("a derivada da raiz é 0, então o método não funciona");
        }
        //System.out.println("valor de csi: " + xk + " f(csi): " + f.apply(xk));
        k += 1;
        if((Math.abs(f.apply(xk)) < E) || k >= 100){
            System.out.println("iteracoes: " + k);
            return xk;
        }
        return newtonRaphsonAlternativo(f, flinha, k, xk, x0);
    }

        public double newtonRaphsonModificado(Function<Double,Double> f,Function<Double,Double> flinha, int k,double xn, double xm){
        double xk = xn;
        double xk1;
        if(Math.abs(flinha.apply(xk)) < this.lambda){
            xk1 = xm;
        }else{
            xk1 = xn;
        }
        try{
            xk = xk - (f.apply(xk) / flinha.apply(xk1));
        }catch(Exception ex){
            System.out.println("a derivada da raiz é 0, então o método não funciona");
        }
        //System.out.println("valor de csi: " + xk + " f(csi): " + f.apply(xk));
        k += 1;
        if((Math.abs(f.apply(xk)) < E) || k >= 100){
            System.out.println("iteracoes: " + k);
            return xk;
        }
        return newtonRaphsonAlternativo(f, flinha, k, xk, xk1);
    }

    public double secante(Function<Double,Double> f, double x0, double x1){
        double xk = x1;
        try{
            xk = xk - (f.apply(xk) / ((f.apply(xk)-f.apply(x0))/(xk-x0)));
        }catch(Exception ex){
            System.out.println("x0 e x1 nao atendem às codicoes");
            return 0;
        }
        System.out.println("valor de csi: " + xk + " f(csi): " + f.apply(xk));
        if((Math.abs(f.apply(xk)) < E) || Math.abs(xk - x1) < E){
            return xk;
        }
        return secante(f, x1, xk);
    }

    public double metodoEuler(BiFunction<Double,Double, Double> f, double h, double y0, double x0, double x){
        y0 = y0 + (h*f.apply(x, y0));
        if(Math.abs(x - x0) < 0.001){
            return y0;
        }
        x0 += h;
        return metodoEuler(f, h, y0, x0, x);
    }

    public double metodoEulerMelhorado(BiFunction<Double,Double, Double> f, double h, double y0, double x0, double x){
        double yt;
        yt = y0 + (h*(f.apply(x0, y0)));
        y0 = y0 + (h/2)*(f.apply(x0, y0) + f.apply(x0 + h, yt));
        if(Math.abs(x - x0) < 0.001){
            return y0;
        }
        x0 += h;
        return metodoEulerMelhorado(f, h, y0, x0, x);
    }
    //metodos
}