import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    public static void main(String[] args) {
        ArrayList<Edge> E = new ArrayList<>();
        E.add(new Edge(1,2,2));
        E.add(new Edge(1,3,2));
        E.add(new Edge(1,4,3));
        E.add(new Edge(1,4,3));
        E.add(new Edge(2,5,5));
        E.add(new Edge(2,3,1));
        E.add(new Edge(3,4,4));
        E.add(new Edge(3,5,2));
        E.add(new Edge(4,5,3));

        ArrayList<Edge> F = new ArrayList<>();

        kruskalAlgorithm(5,E,F);

        for (Edge edge : F) {
            System.out.println("V"+edge.vertex1+" - "+"V"+edge.vertex2);
        }
    }
    public static void kruskalAlgorithm(int n,ArrayList<Edge> E, ArrayList<Edge> F){

        int i,j;
        int p,q;
        Edge e;

        Collections.sort(E);
        Appendix.initial(n);
        
        while(F.size()<n-1){
            e = E.remove(0);
            i = e.vertex1;
            j = e.vertex2;
            p = Appendix.find(i);
            q = Appendix.find(j);
            if(!Appendix.equal(p,q)){
                Appendix.merge(p,q);
                F.add(e);
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex1;
    int vertex2;
    int length;

    public Edge (int vertex1, int vertex2, int length) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.length = length;
    }

    @Override
    public int compareTo(Edge o) {
        return this.length - o.length;
    }
}