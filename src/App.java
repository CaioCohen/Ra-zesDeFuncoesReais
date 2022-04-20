import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos metodos = new Metodos();
        Polinomio polinomio = new Polinomio();
        System.out.println(metodos.bissecao((a)-> polinomio.terceiroGrau(a), -5.0, 5.0));
    }
}
