package classes;

import java.util.function.Function;

public class Metodos {
    private double E = 0.00001;
    
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
        }
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
        }
        if(Math.abs(funcao.apply(novoIntervalo)) < E){
            return novoIntervalo;
        }

        return bissecao(funcao, a, b);
    }

    public double newtonRaphson(Function<Double,Double> f,Function<Double,Double> flinha, int k, double x0){
        double xk = x0;
        try{
            xk = xk - (f.apply(xk) / flinha.apply(xk));
        }catch(Exception ex){
            System.out.println("a derivada da raiz é 0, então o método não funciona");
        }

        if((Math.abs(f.apply(xk)) < E) || k >= 100){
            return xk;
        }

        return newtonRaphson(f, flinha, k, xk);
    }

    public double secante(Function<Double,Double> f, double x0, double x1){
        double xk = x1;
        try{
            xk = xk - (f.apply(xk) / ((f.apply(xk)-f.apply(x0))/(xk-x0)));
        }catch(Exception ex){
            System.out.println("x0 e x1 nao atendem às codicoes");
        }

        if((Math.abs(f.apply(xk)) < E) || Math.abs(xk - x1) < E){
            return xk;
        }

        return secante(f, x1, xk);
    }
}