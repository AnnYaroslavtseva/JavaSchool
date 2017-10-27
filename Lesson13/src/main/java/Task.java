import java.util.concurrent.Callable;

public class Task<T> {
    Callable<? extends T> callable;
    volatile MyExceptions myExceptions;//гарантия того, что все потоки увидят актуальное значение переменных
    volatile T result;

    public Task(Callable<? extends T> callable) {

           this.callable = callable;   //была создана задача, результатом выполнения которой будет String

         }

         public T get() throws MyExceptions {

             if (result != null) return result;


             synchronized (this){


            try {
                 result = callable.call();
            } catch (Exception e) {
                throw myExceptions = new MyExceptions("Error");
            }

            result = (T) "Method get is work";
            return result;}
      }
}