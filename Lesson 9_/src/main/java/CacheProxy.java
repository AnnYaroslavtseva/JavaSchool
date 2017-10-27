import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import static java.lang.ClassLoader.getSystemClassLoader;


public class CacheProxy implements InvocationHandler, Serializable {
    private Object target;
    private static HashMap<String, Double> cacheData;

    public CacheProxy(Object target) {
        this.target = target;
    }


    private static void writeFile(String prefix, Object[] mArgs, Double res) throws IOException {
        StringBuilder args = new StringBuilder();


        for (int i = 0; i < mArgs.length; i++) {  //преобразуем массив аргументов в одну строку
            args.append(mArgs[i] + " ");
        }

        if (prefix == null) prefix = mArgs[0].toString();
        String argsMethod = args.toString();
        cacheData.put(argsMethod, res);

        try {
            File file = new File(prefix);
            FileOutputStream fos = new FileOutputStream(prefix);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cacheData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Serialization error");
        }

    }


    private static HashMap<String, Double> readFile(String prefix) throws IOException {
        File file = new File(prefix);
        try {
            FileInputStream fis = new FileInputStream(prefix);
            ObjectInputStream oin = new ObjectInputStream(fis);
            cacheData = (HashMap<String, Double>) oin.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return cacheData;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnot = method.getAnnotation(Cache.class);
        Double result = 0.0;
        String prefix = cacheAnnot.fileNamePrefix();
        if (prefix == null) prefix = method.getName();
        File file = new File(prefix);
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(target, args);
        } else {
            if (!(cacheAnnot.identityBy()[1] == null)) {
                cacheData = readFile(prefix);

            }
            if (cacheData == null) {
                result = (Double) method.invoke(target, args);
                writeFile(prefix, args, result);
            }

        }


        return result;
    }


   /* public static <T> T cache(Object target) { //Созд клсл
        return (T) Proxy.newProxyInstance(getSystemClassLoader(),
                target.getClass().getInterfaces(),
                new CacheProxy(target)
                        );

    }*/



    public <T> T cache(final Class<T> cl) {
        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[]{cl}, new CacheProxy(target));
    }





}










