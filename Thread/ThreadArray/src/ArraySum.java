public class ArraySum implements Runnable{
    ArrayClass arrayClass;

    public ArraySum(ArrayClass arrayClass) {
        this.arrayClass = arrayClass;
    }

    @Override
    public void run() {
       arrayClass.summaArray();
    }

}
