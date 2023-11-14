import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class WorkingFile {
    File file;
    File fileZapret;
    String[] slova;
    File fileOut = new File("./out.txt");
    boolean isThread=true;


    public WorkingFile(File file, File fileZapret) {
        this.file = file;
        this.fileZapret = fileZapret;
        changeArray();
    }


    public void changeArray(){
        try(Scanner scanner = new Scanner(fileZapret)){
            while (scanner.hasNext()){
                slova = scanner.next().split(";");
            }
        }
        catch (Exception ex){

        }
    }

    public synchronized void poiskSlov()  {
        String pathIn = "C:\\Users\\Марина\\Documents\\JAVA\\HOME\\Thread_PoiskZapretSlov\\Новая папка";
        File file = new File(pathIn);

        try {
            fileOut.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            var list = Files.walk(file.toPath()).toList();
            for (int i = 0; i < list.size(); i++) {
                if(!list.get(i).toString().contains(".txt"))continue;
                try (BufferedReader br = new BufferedReader(new FileReader(list.get(i).toString()))) {
                    boolean flag = true;
                    String str = "";
                    String strBufer = "";
                    while (br.ready()) {
                        str = br.readLine();
                        strBufer += str+"\n";
                        if (flag) {
                            for (int j = 0; j < slova.length; j++) {
                                if (str.contains(slova[j])) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (!flag) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))){
                            strBufer=strBufer.substring(0,strBufer.length()-1);
                            bw.append(strBufer);
                        }catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    strBufer = "";
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            isThread = false;
            notify();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized void substringSlova(){
        while (isThread){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileOut))){
            String str="";
            while (br.ready()){
                str+=br.readLine()+"\n";
            }
            String newStr="";
            for (int i = 0; i < slova.length; i++) {
                str=StringUtils.remove(str,slova[i]);

            }
            str=str.substring(0,str.length()-1);
            File fileSub=new File("./subFile");
            fileSub.createNewFile();
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileSub))) {
                bw.append(str);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
