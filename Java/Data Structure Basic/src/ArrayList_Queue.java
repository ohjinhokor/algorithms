import java.util.ArrayList;

public class ArrayList_Queue<T> {
    private ArrayList<T> arrayList = new ArrayList<T>();

    public void enqueue(T item){
        arrayList.add(item);
    }

    public T dequeue(){
        if(arrayList.isEmpty()){
            return null;
        }
        return arrayList.remove(0);
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (T t : arrayList){
            s.append(t.toString() + " ");
        }
        return s.toString();
    }
}
