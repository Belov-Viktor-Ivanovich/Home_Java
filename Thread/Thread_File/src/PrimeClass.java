import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class PrimeClass {
    private File file;
    List<Integer>prostNum=new ArrayList<>();
    List<Integer>factNumber= new ArrayList<>();
    private boolean flag=true;

    public PrimeClass(File file) {
        this.file = file;
    }

    List<Integer>list=new ArrayList<>();
    public synchronized void completionFile()  {

        try(BufferedWriter bf=new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 100; i++) {
                bf.append(new Random().nextInt(10)+";");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        flag=false;

    }
    public boolean prosNum(int a){

        if (a < 2)
            return false;
        double s = sqrt(a);
        for (int i = 2; i <= s; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
    public int factorial(int x){
        int result=1;
        for (int i = 1; i <= x; i++)
        {
            result *= i;
        }
        return  result;
    }
    public synchronized void addProstNumber() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String str = "";
            while (br.ready()) {
                str += br.readLine();
            }
            String[] str2 = str.split(";");
            File f = new File("./prostNum.txt");
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

                for (int i = 0; i < str2.length; i++) {
                    if (prosNum(Integer.parseInt(str2[i]))) {
                        bw.append(str2[i]+";");
                    }

                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notify();
    }

    public synchronized void addFactorial() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String str = "";
            while (br.ready()) {
                str += br.readLine();
            }
            String[] str2 = str.split(";");
            File f = new File("./factorialNum.txt");
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

                for (int i = 0; i < str2.length; i++) {
                        bw.append(String.valueOf(factorial(Integer.parseInt(str2[i])))+";");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notify();
    }
}
