

import java.io.*;
import java.util.ArrayList;

import static java.nio.file.Files.exists;

public class Main {
    public static void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверем существует фаил или нет
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter для записи в фаил
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String text = "ааа ббб ввв ааа ббб ггг ддд еее";
    private static String fileName = "C:\\Users\\Кирилл\\JavaSchool\\Lesson 3\\Task4\\Task4.txt";

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



    public static void main(String[] args) throws FileNotFoundException {

        //Запись в файл
        write(fileName, text);
        String[] stringMass = read(fileName).split(" ");
        ArrayList<String> str = new ArrayList<String>();
        for (int i = stringMass.length-1 ; i > 0; i--) {
            str.add(stringMass[i]);
            }
            System.out.print(str);
        }




    }




