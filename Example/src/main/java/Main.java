public class Main {
    public static void main (String args[]){
        //Notebook note = new File();
        Notebook notebook = new CacheProxy();
        notebook.write("1", "2");
        notebook.write("2","2");
        System.out.println(" ");
        notebook.read("1");
        notebook.read("1");
        notebook.read("2");



    }
}
