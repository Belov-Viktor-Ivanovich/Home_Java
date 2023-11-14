public class CompletionClass implements Runnable {
    PrimeClass primeClass;

    public CompletionClass(PrimeClass primeClass) {
        this.primeClass = primeClass;
    }

    @Override
    public void run() {
        primeClass.completionFile();
    }
}
