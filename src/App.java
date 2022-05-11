import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos metodos = new Metodos();
        Polinomio polinomio = new Polinomio();
        // System.out.println("metodo da bissecao:");
        // System.out.println(metodos.bissecao((a)-> polinomio.log(a), 2, 3));
        // System.out.println("metodo da falsa posicao:");
        // System.out.println(metodos.falsaPosicao((a)-> polinomio.log(a), 2, 3));
        // System.out.println("metodo de Newton Raphson:");
        // System.out.println(metodos.newtonRaphson((a)-> polinomio.terceiroGrau(a),(a)-> polinomio.terceiroGrauDerivada(a), 0,2));
        // System.out.println("metodo de Newton Raphson alternativo:");
        // System.out.println(metodos.newtonRaphsonAlternativo((a)-> polinomio.complexo(a),(a)-> polinomio.complexoDerivada(a), 0,2,2));
        // System.out.println("metodo de Newton Raphson modificado:");
        // System.out.println(metodos.newtonRaphsonModificado((a)-> polinomio.complexo(a),(a)-> polinomio.complexoDerivada(a), 0,2,2));
        // System.out.println("metodo da secante:");
        // System.out.println(metodos.secante((a)-> polinomio.log(a),2,3));
        System.out.println(metodos.metodoEuler((a, b) -> polinomio.funcaoEuler(a, b), 0.05, 2, 1, 1.2));
        System.out.println(metodos.metodoEulerMelhorado((a, b) -> polinomio.funcaoEuler(a, b), 0.05, 2, 1, 1.2));
    }
}
