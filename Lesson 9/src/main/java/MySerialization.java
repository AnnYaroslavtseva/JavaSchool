import java.io.*;

public class MySerialization implements Serializable {

        public static void serialaze() throws IOException {
            // File file = new File("temp.out");
            try{
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ServiceImpl ts = new ServiceImpl();
            oos.writeObject(ts);
            oos.close();
            }catch (IOException e){
                System.out.println("Serialization error");
            }

        }


        public static void deserialaze() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            ServiceImpl ts = null;
            ts = (ServiceImpl) oin.readObject();
            oin.close();
            //
            // 0.System.out.println(ts);

        }


    }



