public class ProstClass implements Runnable {
    PrimeClass primeClass;

    public ProstClass(PrimeClass primeClass) {
        this.primeClass = primeClass;
    }

    @Override
    public void run() {
        primeClass.addProstNumber();
    }
}
