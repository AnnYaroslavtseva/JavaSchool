import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IndexOutOfBoundsException {
        {
            String fileName = "C:\\Users\\Кирилл\\JavaSchool\\Lesson 3\\Task6\\Task6.txt";

            FileReaderMet rd = new FileReaderMet();

            String[] stringMass = rd.read(fileName).split(" ");
            ArrayList<String> str = new ArrayList<String>();
            for (int i = stringMass.length - 1; i > 0; i--) {
                str.add(stringMass[i]);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВедите нмер строки:");
            try {
                while (scanner.hasNextInt()) {
                    int i = scanner.nextInt();
                    System.out.println(stringMass[i]);
                }

            } catch (java.lang.IndexOutOfBoundsException e) {
                System.out.println("Нет строки c таким номером: " + e);


            }

        }
    }
}




