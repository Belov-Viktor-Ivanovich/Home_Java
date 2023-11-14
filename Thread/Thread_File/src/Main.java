
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Для себя
        /*System.out.println(System.getProperty("user.dir"));
        File f=new File("./ppp.txt");
        try {
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        /*Scanner scanner= new Scanner(System.in);
        String path= scanner.nextLine();*/
        String path=System.getProperty("user.dir");
        System.out.println(path);
        File file = new File(path+"//test.txt");
        PrimeClass primeClass=new PrimeClass(file);
        Thread thread1=new Thread(new CompletionClass(primeClass));
        Thread thread2=new Thread(new ProstClass(primeClass));
        Thread thread3=new Thread(new FactClass(primeClass));
        thread1.start();
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();




    }
}
