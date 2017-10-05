import java.util.LinkedList;

public class MyThreadPool {

    private  WorkerThread threads[];
    private LinkedList<Runnable> taskQueue;


    public MyThreadPool(int threadNumber ){
        taskQueue = new LinkedList<Runnable>();
        threads = new WorkerThread[threadNumber];

        for (int i = 0; i < threads.length ; i++) {
            threads = new WorkerThread[i];
            threads[i].start();

        }

    }

    public void enqueue(Runnable runnable) {
        synchronized (taskQueue){
            taskQueue.addLast(runnable);
            taskQueue.notify();
        }
    }

    public class WorkerThread extends Thread {
        @Override
        public void run() {
            Runnable runnable;
            while (true){
                synchronized (taskQueue){
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        //игнорируем
                    }
                    runnable = (Runnable) taskQueue.removeFirst();

                  }
                  try{
                    runnable.run();
                  } catch (Exception e){
                    //игнорируем
                  }
                }
            }

        }
    }
}
