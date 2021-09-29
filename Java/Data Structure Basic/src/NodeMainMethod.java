// node끼리 연결해보기

public class NodeMainMethod {

    public static void main(String[] args) {

        // node 두 개를 연결하고 인스턴스간에 연결하기
        DS_NodeForLinkedList<Integer> node1 = new DS_NodeForLinkedList<Integer>(13);

        DS_NodeForLinkedList<Integer> node2 = new DS_NodeForLinkedList<Integer>(14);

        DS_NodeForLinkedList<Integer> head = node1;
        node1.next = node2;

        // DoubleLinkedList 이용하기
        DS_DoubleLinkedList<Integer> newDLL = new DS_DoubleLinkedList<Integer>();
        newDLL.addNode(3);
        newDLL.addNode(4);
        newDLL.addNode(5);
        newDLL.addNode(8);
//        newDLL.print();

        System.out.println(newDLL.searchFromHead(5));
        System.out.println(newDLL.searchFromTail(8));
        System.out.println(newDLL.searchFromTail(10));


        System.out.println("===========================");
        newDLL.insertToFront(3, 10);
        newDLL.insertToFront(8,1010);
        newDLL.printBack();
    }
}

