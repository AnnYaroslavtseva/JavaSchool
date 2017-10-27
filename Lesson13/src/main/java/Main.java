import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static String result;
    public static void main(String[] args)  {
     // String  result = "Method get is work";


        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> resultList = new ArrayList<>();

         Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                // возвращает имя потока, который выполняет callable таск
                return Thread.currentThread().getName();
            }
         };
        //Future<String> future = executor.submit(callable);
        for (int i = 0; i < 4 ; i++) {

           /* Task<String> task = new Task<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    // возвращает имя потока, который выполняет callable таск
                    return Thread.currentThread().getName();
                }
            });*/
            Task<String> task = new Task<>(callable);
            result = task.get();
            Future<String> future = executor.submit(callable);
           // Future<String> future = executor.submit((Callable<String>) task);
            resultList.add(future);
        }
        for(Future<String> fut : resultList){
        try {
            // печатаем в консоль возвращенное значение Future
            // будет задержка в 1 секунду, потому что Future.get()
            // ждет пока таск закончит выполнение
            System.out.println(new Date()+ "::" + fut.get()+"  "+ result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

        executor.shutdown();
}

         }









/*
public class CallableExample
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}
Output:

        Result for number - 4 -> 24
        Result for number - 6 -> 720
        Future result is -  - 720; And Task done is true
        Future result is -  - 24; And Task done is true
        Result for number - 2 -> 2
        Result for number - 6 -> 720
        Future result is -  - 720; And Task done is true
        Future result is -  - 2; And Task done is true
*/
