import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Grafo {
    ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    ArrayList<Vertice> marcados = new ArrayList<>();
    void dijkstra(Vertice origem) {
        ArrayList<Vertice> lst = new ArrayList<>(vertices);

        for (Vertice v : lst) {
            v.info = (int) Double.POSITIVE_INFINITY;
        }

        origem.info = 0;

        while (!lst.isEmpty()) {
            Vertice u = extrairMenorInfo(lst);
            lst.remove(u);

            for (Vertice w : u.adjacentes) {
                if (lst.contains(w)) {
                    double distancia = u.info + pesoAresta(u, w);
                    if (distancia < w.info) {
                        w.info = (int) distancia;
                    }
                }
            }
        }
    }

    double pesoAresta(Vertice v1, Vertice v2) {
        for (Aresta aresta : arestas) {
            if ((aresta.vertice1 == v1 && aresta.vertice2 == v2) ||
                    (aresta.vertice1 == v2 && aresta.vertice2 == v1)) {
                return aresta.peso;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    private Vertice extrairMenorInfo(ArrayList<Vertice> lst) {
        Vertice menor = lst.get(0);
        for (Vertice v : lst) {
            if (v.info < menor.info) {
                menor = v;
            }
        }
        return menor;
    }

    ArrayList<Vertice> buscaEmLargura(Vertice origem) {
        marcados.clear(); //ArrayList<Vertice> marcados = new ArrayList<>();
        Queue<Vertice> fila = new LinkedList<>();

        marcados.add(origem);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice v = fila.poll();

            for (Vertice w : v.adjacentes) {
                if (!marcados.contains(w)) {
                    marcados.add(w);
                    fila.add(w);
                }
            }
        }

        return marcados;
    }

    ArrayList<Vertice> buscaEmProfundidade(Vertice origem) {
        ArrayList<Vertice> marcados = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();

        marcados.add(origem);
        pilha.push(origem);

        while (!pilha.isEmpty()) {
            Vertice v = pilha.peek();
            Vertice w = getProximoAdjacenteNaoMarcado(v, marcados);

            if (w != null) {
                marcados.add(w);
                pilha.push(w);
            } else {
                pilha.pop();
            }
        }

        return marcados;
    }

    private Vertice getProximoAdjacenteNaoMarcado(Vertice v, ArrayList<Vertice> marcados) {
        for (Vertice adjacente : v.adjacentes) {
            if (!marcados.contains(adjacente)) {
                return adjacente;
            }
        }
        return null;
    }

    boolean verticeMarcado(Vertice v) {
        return marcados.contains(v);
    }

    void adicionarVertice(Vertice vertice){
        vertices.add(vertice);
    }

    void adicionarAresta(double peso, Vertice v1, Vertice v2) {
        Aresta novaAresta = new Aresta(peso, v1, v2);
        v1.adjacentes.add(v2);
        v2.adjacentes.add(v1);
        arestas.add(novaAresta);
    }


    void imprimirGrafo() {
        for (Vertice vertice : vertices) {
            System.out.print("Vértice " + vertice.info + ": ");

            for (Vertice adjacente : vertice.adjacentes) {
                Aresta aresta = obterAresta(vertice, adjacente);
                System.out.print("(" + adjacente.info + ", Peso: " + aresta.peso + ") ");
            }

            System.out.println();
        }
    }

    private Aresta obterAresta(Vertice v1, Vertice v2) {
        for (Aresta aresta : arestas) {
            if ((aresta.vertice1 == v1 && aresta.vertice2 == v2) ||
                    (aresta.vertice1 == v2 && aresta.vertice2 == v1)) {
                return aresta;
            }
        }
        return null;
    }
}