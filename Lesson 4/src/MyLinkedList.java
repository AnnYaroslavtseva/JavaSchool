import java.util.Iterator;

public class MyLinkedList {


    public class ListContainer<E> implements Linked<E> {
        private Node<E> firstNode;
        private Node<E> lastNode;
        private int size = 0; // сетчик количества элементов в списке

        public ListContainer() {
            lastNode = new Node<E>(null, firstNode, null);
            firstNode = new Node<E>(null, null, lastNode);
        }

        /*null <-prevElement[firstNode(e = null)] nexstElement -> <-prevElement[lastNode(e = null)] nexstElement -> null
        При вставке в конец берем последний узел (он пуст), заполняем его контентом и создаем заново
        пустой последний узел, котрый указывает на предыдущий последний (уже заполненый) узел */


        @Override
        public void addLast(E e) {
            Node<E> prev = lastNode;
            prev.setCurrentElement(e);
            lastNode = new Node<E>(null, prev, null);
            prev.setNextElement(lastNode);
            size++;
        }

        @Override
        public void addFirst(E e) {
            Node<E> next = firstNode;
            next.setCurrentElement(e);
            firstNode = new Node<E>(null, null, next);
            next.setPrevElement(firstNode);
            size++;

        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public E getElementByIndex(int counter) {
            Node<E> target = firstNode.getNextElement();
            for (int i = 0; i < counter; i++) {
                target = getNextElement(target);
            }
            return null;
        }

        /*рекурсивно с помощью этого метода в цикле,
        кот предстален выше, переходим по эементам столько раз
         сколько нужно, чтобы дойти до нужного элемента */
        public Node<E> getNextElement(Node<E> current) {
            return current.getNextElement();
        }


        private class Node<E> {
            E currentElement;
            Node<E> nextElement;
            Node<E> prevElement;

            Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
                this.currentElement = currentElement;
                this.nextElement = nextElement;
                this.prevElement = prevElement;
            }

            public E getCurrentElement() {
                return currentElement;
            }

            public void setCurrentElement(E currentElement) {
                this.currentElement = currentElement;
            }

            public Node<E> getNextElement() {
                return nextElement;
            }

            public void setNextElement(Node<E> nextElement) {
                this.nextElement = nextElement;
            }

            public Node<E> getPrevElement() {
                return prevElement;
            }

            public void setPrevElement(Node<E> prevElement) {
                this.prevElement = prevElement;
            }
            //Итого, мы имеем некую связную структуру между первой и последней нодой

        }

        public class MyIterator {
            private int index;

            public Iterator<E> myIterator(ListContainer element) {
                index = 0;
                return new Iterator() {

                    @Override
                    public boolean hasNext() {
                        return index >= 0;
                    }

                    @Override
                    public Object next() {
                        return element.getElementByIndex(index++);
                    }

                };

            }

        }
    }
}




