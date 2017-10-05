import java.util.Scanner;

public class Calculator implements ICalc {


    @Override
    public double readAndCalc(double a, double b, String operator) {

        double result = 0;
        if (operator.equals("+")) {
            result = a + b;
            System.out.println(" = " + (a + b));
        }
        if (operator.equals("*")) {
            result = a * b;

            System.out.println(" = " + (a * b));
        }
        if (operator.equals("/")) {
            result = a / b;

            System.out.println(" = " + (a / b));
        }
        if (operator.equals("-")) {
            result = a - b;

            System.out.println(" = " + (a - b));
        }
        return result;

    }


}












