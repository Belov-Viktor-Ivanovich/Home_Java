public class FactClass implements Runnable {
    PrimeClass primeClass;

    public FactClass(PrimeClass primeClass) {
        this.primeClass = primeClass;
    }

    @Override
    public void run() {
        primeClass.addFactorial();
    }
}
