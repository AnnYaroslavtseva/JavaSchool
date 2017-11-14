public class Calculator implements ICalc {


    @Override
    public double readAndCalc(Double a, String operator,Double b) {

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












