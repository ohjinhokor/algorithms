// node끼리 연결해보기

public class NodeMainMethod {

    public static void main(String[] args) {

        // node 두 개를 연결하고 인스턴스간에 연결하기


        DS_NodeForLinkedList<Integer> node1 = new DS_NodeForLinkedList<Integer>(13);

        DS_NodeForLinkedList<Integer> node2 = new DS_NodeForLinkedList<Integer>(14);

        DS_NodeForLinkedList<Integer> head = node1;
        node1.next = node2;


    }
}

