public class DoublyLinkedListWithDummy<E> extends DoublyLinkedList<E> {
    // construtor that create an empty list of 2 dummy nodes
    public DoublyLinkedListWithDummy(){
        head = new DoublyLinkedNode<E>(null);
        tail = new DoublyLinkedNode<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        count = 0;
    }

    // function size() get size of the list i.e value of count
    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    // function clear() clear the list overwriting??
    public void clear(){
        head.setNext(tail);
        tail.setPrevious(head);
        count = 0;
    }

    // get first value of the list
    public E getFirst(){
        if (isEmpty()) return null;
        return head.next().value();
    }

    // get last value of the list
    public E getLast(){
        if (isEmpty()) return null;
        return tail.previous().value();
    }

    private DoublyLinkedNode<E> getNode(int index){
        DoublyLinkedNode<E> node;
        if (index < count/2){
            node = head.next();
            for (int i = 0; i < index; i++)
                node = node.next();
        } else {
            node = tail;
            for (int i = count; i > index; i--)
                node = node.previous();
        }
        return node;
    }

    // get value at index ???
    public E get(int index){
        if (index < 0 || index >= count) return null;
        return getNode(index).value();
    }

    // set value at index ??
    public E set(int index, E value){
        if (index < 0 || index >= count) return null;
        DoublyLinkedNode<E> node = getNode(index);
        E result = node.value();
        node.setValue(value);
        return result;
    }

    private void insertAfter(DoublyLinkedNode<E> previous, E value){
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(value, previous.next(), previous);
        newNode.next().setPrevious(newNode);
        previous.setNext(newNode);
        count++;
    }

    public void addFirst(E value){
        insertAfter(head, value);
    }

    public void add(int index, E value){
        if (index < 0 || index > count){
            // print error message
            System.out.println("Index out of range");
        }
        insertAfter(getNode(index-1), value);
    }


    public void addLast(E value){
        insertAfter(tail.previous(), value);
    }

    public java.lang.String toString(){
        StringBuffer b = new StringBuffer();
        DoublyLinkedNode<E> node = head.next();
        while (node != tail){
            b.append(node.value());
            node = node.next();
            if (node != tail)
                b.append(", ");
        }
        return "[" + b.toString() + "]";
    }

    public java.lang.String toStringReverse(){
        // create an empty string
        String s = "";
        // create a node and assign it to tail
        DoublyLinkedNode<E> node = tail;
        // loop through the list
        while (node.previous() != head){
            // append the value of the node to the string
            s += node.previous().value();
            // move to the previous node
            node = node.previous();
            // if the node is not the head, append a comma to the string
            if (node != head)
                s += ", ";
        }
        return "[" + s + "]";
    }

    private E delete(DoublyLinkedNode<E> node){
        node.previous().setNext(node.next());
        node.next().setPrevious(node.previous());
        count--;
        return node.value();
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        return delete(head.next());
    }

    public E remove(int index){
        if (index < 0 || index >= count) return null;
        return delete(getNode(index));
    }

    public E removeLast(){
        if (isEmpty()) return null;
        return delete(tail.previous());
    }

    // why do we need 2 remove methods??
    public E remove(){
        return removeFirst();
    }

    public int lastIndexOf(E value){
        DoublyLinkedNode<E> node = tail;
        for (int i = count-1; i >= 0; i--){
            node = node.previous();
            if (value.equals(node.value()))
                return i;
        }
        return -1;
    }
    public int indexOf(E value){
        DoublyLinkedNode<E> node = head;
        for (int i = 0; i < count; i++){
            node = node.next();
            if (value.equals(node.value()))
                return i;
        }
        return -1;
    }

    public boolean contains(E value){
        return indexOf(value) != -1;
    }
}