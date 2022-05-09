import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos metodos = new Metodos();
        Polinomio polinomio = new Polinomio();
        // System.out.println("metodo da bissecao:");
        // System.out.println(metodos.bissecao((a)-> polinomio.log(a), 2, 3));
        // System.out.println("metodo da falsa posicao:");
        // System.out.println(metodos.falsaPosicao((a)-> polinomio.log(a), 2, 3));
        System.out.println("metodo de Newton Raphson:");
        System.out.println(metodos.newtonRaphson((a)-> polinomio.log(a),(a)-> polinomio.logDerivada(a), 0,2));
        System.out.println("metodo de Newton Raphson alternativo:");
        System.out.println(metodos.newtonRaphsonAlternativo((a)-> polinomio.log(a),(a)-> polinomio.logDerivada(a), 0,2,2));
        System.out.println("metodo de Newton Raphson modificado:");
        System.out.println(metodos.newtonRaphsonModificado((a)-> polinomio.log(a),(a)-> polinomio.logDerivada(a), 0,2,2));
        // System.out.println("metodo da secante:");
        // System.out.println(metodos.secante((a)-> polinomio.log(a),2,3));
    }
}
