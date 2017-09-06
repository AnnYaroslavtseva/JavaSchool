import java.util.Scanner;

public class Calc implements ICalc {
    @Override
    public double readAndCalc (){
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        String operator = scan.next();
        double b = scan.nextDouble();
        System.out.println(">> ");
        double result = 0;
        if(operator.equals("+")) {
             result = a+b;
                System.out.println(" = "+(a+b));
            }
        if(operator.equals("*")) {
             result = a*b;

            System.out.println(" = "+(a*b));
        }
        if(operator.equals("/")) {
             result = a/b;

            System.out.println(" = "+(a/b));
        }
        if(operator.equals("-")) {
             result = a-b;

            System.out.println(" = "+(a-b));
        }
        return result;

    }


    }





