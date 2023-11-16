public class Aresta {
    double peso;
    Vertice vertice1;
    Vertice vertice2;

    Aresta() {
    }

    Aresta(double p, Vertice v1, Vertice v2) {
        peso = p;
        vertice1 = v1;
        vertice2 = v2;
    }
}