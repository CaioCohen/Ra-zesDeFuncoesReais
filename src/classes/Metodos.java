package classes;

import java.util.function.Function;

public class Metodos {
    
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
        if(Math.abs(funcao.apply(novoIntervalo)) < 0.0001){
            return novoIntervalo;
        }

        return bissecao(funcao, a, b);
    }
}