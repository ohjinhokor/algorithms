class Appendix {
    final int n = 5;
    int index;
    int set_pointer;

    class NodeType{
        int parent;
        int depth;
    }

    NodeType[] universe = new NodeType[n + 1];

    public void makeSet(int i){
        universe[i].parent = i;
        universe[i].depth =0;
    }

    public int find(int i){
        int j;
        j=i;
        while(universe[j].parent!=j){
            j = universe[j].parent;
        }
        return j;
    }

    public void merge(int p, int q){
        if(universe[p].depth == universe[q].depth){
            universe[p].depth = universe[p].depth+1;
            universe[q].parent = p;
        }else if(universe[p].depth < universe[p].depth){
            universe[p].parent = q;
        }else{
            universe[q].parent = p;
        }
    }

    public boolean equal(int p, int q){
        if(p==q){
            return true;
        }else{
            return false;
        }
    }

    public void initial(int n){
        int i;
        for(i=1; i<=n; i++){
            makeSet(i);
        }
    }
}
