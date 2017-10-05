import java.util.HashMap;

public class File implements Notebook {
    private HashMap<String,String> strore = new HashMap<String, String>();
/*
*  просто вносит задержку в операции над файлом
*
* */
  private void sleep(){
      try{
          Thread.sleep(1000);
      } catch (InterruptedException e){ e.printStackTrace();}
  }
    @Override
    public String read(String key) {
        sleep();
        String value = strore.get(key);
        System.out.println("Read from file:" + key + " - "+ value);

        return value;
    }
    @Override
    public String write(String key, String value) {
      sleep();
      System.out.println("Write to file:" + key + " - " + value);
        return strore.put(key, value);
    }
}
