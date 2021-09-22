import java.util.ArrayList;

public class ArrayList_Stack<T> {

    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T item){
        stack.add(item);
    }

    public T pop(){
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (T t : stack) {
            sb.append(t + " ");
        }
        return sb.toString();
    }
}
