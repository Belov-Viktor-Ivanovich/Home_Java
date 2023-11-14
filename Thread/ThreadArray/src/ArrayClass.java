import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class ArrayClass {
    private int[]ar=new int[100];
    int sum;
    int sr;
    boolean flag=true;

    public int getSum() {
        return sum;
    }

    public int getSr() {
        return sr;
    }

    public boolean isFlag() {
        return flag;
    }

    public int[] getAr() {
        return ar;
    }

    public static void clearScreen() {

            try {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            catch (Exception e){

            }


    }
    public synchronized int[] inArray(){
        String str = "Инициализация";
        for (int i = 0; i < 100; i++) {
            ar[i]=new Random().nextInt(100);
            try {
                clearScreen();
                System.out.println(str);
                Thread.sleep(40);
                str+=" . .";
                if(i%5==0)str="Инициализация";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        flag=false;
        return ar;
    }
    public synchronized int srArray() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();
        sr=Arrays.stream(ar).sum() / ar.length;
        return sr;
    }
    public synchronized int summaArray(){
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();
        sum=Arrays.stream(ar).sum();
        return sum;
    }



}
