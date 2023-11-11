public class ArrayInit implements Runnable {
    ArrayClass arrayClass;

    public ArrayInit(ArrayClass arrayClass) {
        this.arrayClass = arrayClass;
    }

    @Override
    public void run() {
        arrayClass.inArray();
    }
}
