import java.util.ArrayList;

public class Vertice {
    int info;
    ArrayList<Vertice> adjacentes = new ArrayList<Vertice>();

    Vertice(){}

    Vertice(int i) {
        info = i;
    }
}