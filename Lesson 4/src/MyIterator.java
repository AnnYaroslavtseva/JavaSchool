import javax.xml.soap.Node;
import java.util.Iterator;

public class MyIteratorv{

    public Iterator iterator() {
        return new Iterator<T>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }
}

        public class MyIterator  {
            private List list;
            private int index;

            public Iterator myIterator(E element) {
                index = element.size() - 1;
                return new Iterator() {

                    @Override
                    public boolean hasNext() {
                        return index >= 0;
                    }

                    @Override
                    public Object next() { return element.get(index++);
                    }
                };
            }
        }
