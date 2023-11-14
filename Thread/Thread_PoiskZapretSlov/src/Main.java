import java.io.File;
import java.util.Scanner;



//https://commons.apache.org/proper/commons-lang/download_lang.cgi Скачать библиотеку  для удаления слова из строки
public class Main {
    public static void main(String[] args) {
        File file2 = new File("C:\\Users\\Марина\\Documents\\JAVA\\HOME\\Thread_PoiskZapretSlov\\Slova.txt");
        Scanner scanner = new Scanner(System.in);
        String path=scanner.next();
        //Путь для теста
        //path="C:\\Users\\Марина\\Documents\\JAVA\\HOME\\Thread_PoiskZapretSlov\\src\\Новая папка";
        File file = new File(path);
        WorkingFile workingFile = new WorkingFile(file,file2);

        new Thread(()-> workingFile.poiskSlov()).start();
        new Thread(()-> workingFile.substringSlova()).start();




    }
}