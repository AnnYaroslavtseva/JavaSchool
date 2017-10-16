import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class CacheProxy implements InvocationHandler {
    Object target;

    public CacheProxy(Object target) {
        this.target = target;
    }

    private String setToFile(Method method){
            String filename;
            String prefix;
            Cache annotation = method.getAnnotation(Cache.class);
            if (annotation.fileNamePrefix(). equals("")) {
                prefix = method.getName();
            } else {
                prefix = annotation.fileNamePrefix();
            }









    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // StringBuilder argsS = new StringBuilder();

            if (method.isAnnotationPresent(Cache.class)) {
                Cache an = method.getAnnotation(Cache.class);
                String prefix = "";
                if (an.fileNamePrefix().equals(""))
                    prefix = method.getName();
                else
                    prefix = an.fileNamePrefix();

            String arg1 =(String) args[0];
            Integer arg2 =(Integer) args[1];
            System.out.println("Do you want to ignore the second parameter? \n Enter 1 if yes \n Enter 2 if no");
            Scanner scan = new Scanner(System.in);
            Integer answer = scan.nextInt();
            if (answer == 1){ //игнорировать 2 параметр
                if (arg2 ==


            }


        }


            return null;
        }
    }

