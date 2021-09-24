public class SingleLinkedListMainMethod {

    public static void main(String[] args) {
        DS_SingleLinkedList<Integer> sll = new DS_SingleLinkedList<>();

//        sll.start(new DS_NodeForLinkedList<Integer>(13));
//        sll.plus(new DS_NodeForLinkedList<Integer>(14));
//
//        System.out.println("sll.head = " + sll.head);
//        System.out.println("sll.tail = " + sll.tail);

        sll.addNode(13);
        sll.addNode(14);
        sll.addNode(15);
        sll.addMiddleNode(16,2);
        System.out.println("sll = " + sll);

        sll.deleteMiddleNode(15);
        System.out.println("sll - del 15 = " + sll);
        sll.deleteMiddleNode(100);
        System.out.println("sll = " + sll);
    }
}
