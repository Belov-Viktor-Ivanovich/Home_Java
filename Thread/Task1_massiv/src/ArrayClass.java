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

    public synchronized int[] inArray(){
        for (int i = 0; i < 100; i++) {
            ar[i]=new Random().nextInt(100);
            try {
                Thread.sleep(50);
                System.out.println("инициализация");
            } catch (InterruptedException e) {
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
