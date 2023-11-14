import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите адрес директории");
        String pathIn=scanner.next();
        System.out.println("Укажите адрес куда копировать директорию");
        String pathOut=scanner.next();
        pathIn = "C:\\Users\\Марина\\Desktop\\WinNTSetup";
        pathOut = "C:\\Users\\Марина\\Desktop\\CopyWinNTSetup";
        File file = new File(pathIn);
        File file2 = new File(pathOut);
        if(file2.exists())deleteDirectory(file2);
        Thread thread = new Thread(()->{

            System.out.println("Начало копирования");
            try {
                Files.walk(file.toPath())
                        .forEach(source -> {
                            try {
                                Files.copy(source, file2.toPath().resolve(file.toPath().relativize(source)));
                                System.out.println("копирование.....");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                System.out.println("копирование завершено");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }
    public static void deleteDirectory(File directory) {
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File file : contents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }
}