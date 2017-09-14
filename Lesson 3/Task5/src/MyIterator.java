import java.util.Iterator;
import java.util.List;

public class MyIterator  {
    private List list;
    private int index;

    public Iterator myIterator(List list) {
        index = list.size() - 1;
        return new Iterator() {

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Object next() {
                return list.get(index--);
            }
        };
    }
}



       /* @Override
        public void remove() {
            list.remove(index); */



