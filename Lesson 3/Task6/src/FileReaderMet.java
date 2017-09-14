import java.io.*;
import java.util.ArrayList;

public class FileReaderMet {


    public static String read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        try {
            if (file.exists()) {
                //Объект для чтения файла в буфер
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //В цикле построчно считываем файл
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                    }
                } finally {

                    in.close();
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

}

