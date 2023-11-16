import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);
        Vertice v5 = new Vertice(5);

        g.adicionarVertice(v1);
        g.adicionarVertice(v2);
        g.adicionarVertice(v3);
        g.adicionarVertice(v4);
        g.adicionarVertice(v5);

        // Arestas com pesos diferentes
        g.adicionarAresta(2, v1, v2);
        g.adicionarAresta(1, v1, v3);
        g.adicionarAresta(3, v2, v4);
        g.adicionarAresta(4, v3, v5);

        // Arestas adicionais para Dijkstra
        g.adicionarAresta(1, v2, v3);
        g.adicionarAresta(5, v4, v5);

        // Imprimir o grafo
        g.imprimirGrafo();

        // Busca em Largura
        System.out.println("\nBusca em Largura:");
        ArrayList<Vertice> bfsResult = g.buscaEmLargura(v1);
        for (Vertice vertice : bfsResult) {
            System.out.print(vertice.info + " ");
        }
        System.out.println();

        // Busca em Profundidade
        System.out.println("\nBusca em Profundidade:");
        ArrayList<Vertice> dfsResult = g.buscaEmProfundidade(v1);
        for (Vertice vertice : dfsResult) {
            System.out.print(vertice.info + " ");
        }
        System.out.println();


    }
}



