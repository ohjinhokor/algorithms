class Appendix {
    final static int n = 5;
    static NodeType[] universe = new NodeType[n + 1];

    static class NodeType{
        int parent;
        int depth;
    }

    private static void makeSet(int i){
        for(int j=0; j<=n; j++){
            universe[j] = new NodeType();
            universe[j].parent = j;
            universe[j].depth = 0;
        }
    }

    public static int find(int i){
        int j;
        j=i;
        while(universe[j].parent!=j){
            j = universe[j].parent;
        }
        return j;
    }

    public static void merge(int p, int q){
        if(universe[p].depth == universe[q].depth){
            universe[p].depth = universe[p].depth+1;
            universe[q].parent = p;
        }else if(universe[p].depth < universe[p].depth){
            universe[p].parent = q;
        }else{
            universe[q].parent = p;
        }
    }

    public static boolean equal(int p, int q){
        if(p==q){
            return true;
        }else{
            return false;
        }
    }

    public static void initial(int n){
        int i;
        for(i=1; i<=n; i++){
            makeSet(i);
        }
    }
}
