import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos metodos = new Metodos();
        Polinomio polinomio = new Polinomio();
        System.out.println(metodos.bissecao((a)-> polinomio.terceiroGrau(a), -5.0, 5.0));
        System.out.println(metodos.falsaPosicao((a)-> polinomio.terceiroGrau(a), -5.0, 5.0));
        System.out.println(metodos.newtonRaphson((a)-> polinomio.terceiroGrau(a),(a)-> polinomio.terceiroGrauDerivada(a), 0, 2.0));
        System.out.println(metodos.secante((a)-> polinomio.terceiroGrau(a),0, 1));
    }
}
