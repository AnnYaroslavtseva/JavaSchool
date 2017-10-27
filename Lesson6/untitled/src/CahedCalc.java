import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.ClassLoader.getSystemClassLoader;

public class CahedCalc implements InvocationHandler {
    Object target;
    private Object ob;

    public CahedCalc(Object target) {
        this.target = target;
    }

    private static void writeFile(Object[] mArgs, Double res) throws IOException {
        StringBuilder args = new StringBuilder();
        String result = String.valueOf((Double) res);

        for (int i = 0; i < mArgs.length; i++) {  //преобразуем массив аргументов в одну строку
            args.append(mArgs[i] + " ");
        }

        File file = new File("cache.txt");
        PrintStream fr = null;
        try {

            fr = new PrintStream(new FileOutputStream(file, true));
            fr.println(args);
            fr.println(result);

        } catch (IOException e) {
        } finally {
            fr.close();
        }
    }


    public static class CreateCalc {
        public static String argumentsAndOperator;
        public static String result = null;


    }


    private static List<CreateCalc> readFile() throws IOException {
        File file = new File("cache.txt");
        List<CreateCalc> mass = new ArrayList<CreateCalc>();

        try {
            Scanner scanner = new Scanner(file);
            CreateCalc newCalc = new CreateCalc();
            while (scanner.hasNextLine()) {
                newCalc.argumentsAndOperator = scanner.nextLine();
                newCalc.result = scanner.nextLine();
                mass.add(newCalc);
            }
        } catch (IOException e) {
        return null;
    }
        return mass;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StringBuilder argsS = new StringBuilder();
        Object res = null;
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(target, args); //здесь, если метод не аннотирован, то он просто выполняется
        } else {
            //Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < args.length; i++) {    //преобразуем массив аргументов в одну строку
                argsS.append(args[i] + " ");
            }
                String input = argsS.toString();
                List<CreateCalc> mass = readFile();//читаем из файла аргументы
                if (!(mass == null)) {
                    for (int i = 0; i < mass.size(); i++) {
                        if (((mass.get(i)).argumentsAndOperator).equals(input)) {
                            System.out.println(CreateCalc.result + " from cache");
                            res = new Double(Double.parseDouble(CreateCalc.result));
                            break;
                        } else {
                            res = method.invoke(target, args);
                            writeFile(args, (Double) res);
                            break;
                        }
                    }
                } else {
                        res = method.invoke(target, args);
                        writeFile(args, (Double) res);


                    }
                }






        return res;

    }
}


