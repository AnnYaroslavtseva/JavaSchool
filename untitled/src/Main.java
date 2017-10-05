
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
        calculator.readAndCalc(a,b,operator);




    }
    }

       /* InvocationHandler handler = new MyProxy(new Integer(5));
        Class[] classes = {Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null,classes, handler ); //create new instance
        proxy.getClass();
        ((Comparable)proxy).compareTo(8); //Прокси наследует все методы класса обджект, но мы можем привести его к
                                          //интерфейсу Comparable, чтобы вызвать методы этого интерфейса, напимер compareTo
    }

    static class MyProxy implements InvocationHandler{
        Object target;
        public MyProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return method.invoke(target, args);
        }
    }
} */


