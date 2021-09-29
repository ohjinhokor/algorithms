public class DS_DoubleLinkedList<T> {

    public DS_NodeForDoubleLinkedList<T> head = null;
    public DS_NodeForDoubleLinkedList<T> tail = null;

    public void addNode(T data) {
        if (head == null) {
            DS_NodeForDoubleLinkedList<T> newNode = new DS_NodeForDoubleLinkedList<>(data);
            head = newNode;
            tail = newNode;

//            System.out.println(head.data);
//            System.out.println(tail.data);
        } else {
//            DS_NodeForDoubleLinkedList<T> node = this.head;
//            while(node.next != null){
//                node = node.next;
//            }
//            node.next = new DS_NodeForDoubleLinkedList<>(data);
//            node.next.prev = node;

            tail.next = new DS_NodeForDoubleLinkedList<>(data);
            tail.next.prev = tail;
            tail = tail.next;

//            System.out.println(this.head.data);
//            System.out.println(tail.data);
        }
    }

    public void print() {
        DS_NodeForDoubleLinkedList<T> node = this.head;
        while(node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    public void printBack() {
        DS_NodeForDoubleLinkedList<T> node = this.tail;
        while(node != null){
            System.out.println(node.data + " ");
            node = node.prev;
        }
    }


    public T searchFromHead(T isdata) {
        if (head == null) {
            return null;
        }
        DS_NodeForDoubleLinkedList<T> node = this.head;
        while (node != null) {
            if(node.data == isdata){
                return node.data;
            }
            else{
                node = node.next;
            }
        }
        return null;
    }

    public T searchFromTail(T isdata){
        if(this.head == null){
            return null;
        }
        else{
            DS_NodeForDoubleLinkedList<T> node = this.tail;
            while(node != null){
                if(node.data == isdata){
                    return isdata;
                }
                else{
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData){
        if(head == null){
            return false;
        }
        DS_NodeForDoubleLinkedList<T> node = this.head;
        while(node.data != existedData){
            if(node.next == null){
                return false;
            }
            node = node.next;
        }
        DS_NodeForDoubleLinkedList<T> newNode = new DS_NodeForDoubleLinkedList<>(addData);
        newNode.next = node.next;
        newNode.prev = node;
        if(node.next != null){
            node.next.prev = newNode;
        }
        if(node.next == null){
            tail = newNode;
        }
        node.next = newNode;
        return true;
    }
}
