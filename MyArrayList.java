import java.util.Iterator;

/**
 * Represent a MyArrayList which implements the ArrayListInterface
 * @author xwu319
 * @version 1.0
 * @param <E> the type of the data of the array list
 */
public class MyArrayList<E> implements ArrayListInterface<E> {
    private E[] elements;
    private int numElements;

    /**
     * Returns the number of elements contained in the array list
     * @return int the number of elements in the array list
     */
    public int getNumElements() {
        return numElements;
    }

    /**
     * Construct a MyArrayList and set the instance fields
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        numElements = 0;
    }

    /**
     * Returns the element at the passed in index of the array list
     * Does not remove the element from the array list
     * @throws IndexOutOfBoundsException if index is less
     * than zero or greater than or equaled to the number of
     * elements in the array list
     * @param index the index of the element in the array list
     * @return the element at the given index in the array list
     */
    public E get(int index) {
        return elements[index];
    }

    /**
     * Adds the element to the last position in the array list
     * Throws an IllegalArgumentException if element is null
     * @param e the element to be added to the array list
     */
    @SuppressWarnings("unchecked")
    public void add(E e) {
        if (numElements < INITIAL_CAPACITY) {
            elements[numElements] = e;
        } else {
            E[] substitute = elements.clone();
            elements = (E[]) new Object[numElements + 1];
            for (int i = 0; i < substitute.length; i++) {
                elements[i] = substitute[i];
            }
            elements[numElements] = e;
        }
        numElements++;
    }

    /**
     * Removes the element at the passed in index from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IndexOutOfBoundsException if index is less than
     * zero or greater than or equaled to the number of elements
     * in the array list
     * @param index the index of the element to be removed
     * @return the element that was removed
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        numElements--;
        E reelement = get(index);
        elements[index] = null;
        E[] substitute = elements.clone();
        elements = (E[]) new Object[numElements];
        int i = 0;
        for (E e : substitute) {
            if (e != null) {
                elements[i] = e;
                i++;
            }
        }
        return reelement;
    }

    /**
     * Removes all instance of the passed in element from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IllegalArgumentException if element is null
     * @param e the element to be removed
     * @return E the element removed
     */
    public E removeAll(E e) {
        boolean contains = false;
        int[] indexArr = new int[numElements];
        int n = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                contains = true;
                indexArr[n] = i;
                n++;
            }
        }
        if (contains) {
            for (int k = 0; k < n; k++) {
                remove(indexArr[k]);
            }
        } else {
            return null;
        }
        throw new  IllegalArgumentException();
    }

    /**
     * Removes all elements from array list and sets array list
     * back to original capacity
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        numElements = 0;
    }

    /**
     * Returns the number of elements contained in the array list
     * @return int the number of elements in the array list
     */
    public int size() {
        return numElements;
    }

    /**
     * Returns false if the array list contains one or more elements
     * and returns true if the array list contains no elements
     * @return boolean whether the array list contains any elements
     */
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (E e : elements) {
            if (e != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    /**
     * Represent a MyArrayListIterator which implements the Iterator
     * @author xwu319
     * @version 1.0
     */
    private class MyArrayListIterator implements Iterator<E> {
        private int cursor;

        /**
         * check if the array list has a next item
         * @return boolean whether the array list has a next item
         */
        public boolean hasNext() {
            return (cursor < numElements);
        }

        /**
         * get the next item in the array list
         * @return E the next item in the array list
         */
        public E next() {

            return elements[cursor++];
        }
    }

    /**
     * the iterator method that returns an iterator
     * @return Iterator of the class
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

}
