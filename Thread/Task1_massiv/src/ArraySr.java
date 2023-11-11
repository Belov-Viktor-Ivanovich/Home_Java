public class ArraySr implements Runnable {
    ArrayClass arrayClass;

    public ArraySr(ArrayClass arrayClass) {
        this.arrayClass = arrayClass;
    }

    @Override
    public void run() {
        arrayClass.srArray();
    }
}
