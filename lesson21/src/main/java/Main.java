
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ICalc calculator = (ICalc) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{ICalc.class},new CahedCalc(new Calculator()));
        System.out.println("You can begin your calc ");
        Scanner scan = new Scanner(System.in);
        Double a = scan.nextDouble();
        Double b = scan.nextDouble();
        System.out.println(">> ");
        String operator = scan.next();
        calculator.readAndCalc(a,operator,b);




    }
    }


