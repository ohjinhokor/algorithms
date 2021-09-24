public class DS_SingleLinkedList<T> {

    public DS_NodeForLinkedList<T> head = null;
//    public DS_NodeForLinkedList<T> tail = null;
//
//    public void start(DS_NodeForLinkedList newOne) {
//        head = newOne;
//        tail = newOne;
//    }
//
//    public void plus(DS_NodeForLinkedList newOne) {
//        tail = newOne;
//    }

    public void addNode(T data){
        if (head == null){
            head = new DS_NodeForLinkedList<T>(data);
        } else{
            DS_NodeForLinkedList<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new DS_NodeForLinkedList<T>(data);
        }
    }

    public void addMiddleNode(T data, Integer order){
        DS_NodeForLinkedList<T> node = this.head;
        for(int i =0; i<order-2; i++){
            node = node.next;
        }
        DS_NodeForLinkedList<T> newNode = new DS_NodeForLinkedList<>(data);
        newNode.next = node.next;
        node.next = newNode;

    }

    public DS_NodeForLinkedList<T> findNode(T findValue){
        if(head == null){
            return null;
        }
        DS_NodeForLinkedList<T> node = head;
        while(node.data != findValue){
            if(node.next!=null){
                node = node.next;
            }
            else if(node.next == null){
                return null;
            }
        }
        return null;
    }

    public void deleteMiddleNode(T data){
        DS_NodeForLinkedList<T> node = head;
        //DS_NodeForLinkedList<T> targetNode = findNode(target);
        if(node.data == data){
            this.head = node.next;
            //return;
        }
        System.out.println(node.next.data);
        while(node.next != null) {
            if(node.next.data != data) {
                node = node.next;
            } else{
                node.next = node.next.next;
            }
        }
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();

        DS_NodeForLinkedList<T> node = this.head;
        while(true){
            sb.append(node.data.toString() + " ");
            node = node.next;
            if(node == null){
                break;
            }
        }
        return sb.toString();
    }
}
