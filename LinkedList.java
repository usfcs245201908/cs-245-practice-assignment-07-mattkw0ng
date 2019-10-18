public class LinkedList<T> implements List<T>{
    Node head;
    int size = 0;

    class Node {
        T data;
        Node next;

        Node(T item){
            data = item;
        }

        void setNext(Node next) {
            this.next = next;
        }

        T getData(){
            return data;
        }
    }


    public void add(T item){
        if(head == null){
            head = new Node(item);
            size++;
        }else{
            Node previous = head;
            while(previous.next != null){
                previous = previous.next; //finds the last node of the list
            }
            Node current = new Node(item);
            previous.setNext(current);
            size++;
        }
    }

    public void add(int pos, T item){
        /*
        if(pos>size||pos<0){
            throw new Exception();
        }
        */
        if(pos == 0){
            Node current = new Node(item);
            current.setNext(head);
            head = current;
            ++size;
        }else{
            Node current = new Node(item);
            Node prev = head;
            for(int i = 0; i<pos-1; i++){
                prev = prev.next; //finds the item just before index pos
            }
            Node temp = prev.next;
            prev.setNext(current);
            current.setNext(temp);

            ++size;
        }
    }

    public T remove(int pos){
        /*
        if(pos>size-1||pos<0){
            throw new Exception();
        }

         */
        if(pos==0){
            Node temp = head;
            head = head.next;
            --size;
            return temp.getData();
        }else{
            Node current = head;
            for(int i = 0 ; i < pos -1; i++){
                current = current.next;     //finds the node before index pos
            }
            T deleted = current.next.getData(); //stores the data from the correct node
            for(int i = pos ; i < size ; i++){
                Node temp = current.next;   //temp is the next node after current
                current.setNext(temp.next);  //
                current = current.next;
            }
            size--;
            return deleted;
        }
    }




    public T get(int pos){
        /*
        if(pos>size-1||pos<0){
            throw new Exception();
        }

         */
        Node current = head;
        for(int i = 0 ; i < pos ; i++){
            current = current.next;
        }
        return current.getData();
    }

    public int size(){
        return size;
    }

}


