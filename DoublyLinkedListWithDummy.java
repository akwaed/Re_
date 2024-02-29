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


}