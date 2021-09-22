import java.util.Stack;

public class DS_Stack {

    public static void main(String[] args){

        Stack<Integer> stack_int = new Stack<>();
        stack_int.push(1);
        stack_int.push(2);
        stack_int.push(3);

        System.out.println("==시작");
        System.out.println(stack_int.pop());

        System.out.println("스택 구현해보기");
        ArrayList_Stack<Integer> stack = new ArrayList_Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
