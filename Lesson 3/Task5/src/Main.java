import java.util.ArrayList;
import java.util.Iterator;

public class Main {
        public static void main(String args[]) {
            ArrayList<String> states = new ArrayList<String>();
            states.add("Германия");
            states.add("Франция");
            states.add("Италия");
            states.add("Испания");
            MyIterator it = new MyIterator();

            Iterator<String> myIt = it.myIterator(states);

            while (myIt.hasNext()){
            System.out.println(myIt.next());
            }
        }
    }

