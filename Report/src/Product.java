public class Product {
    private String item;
    private boolean expense;
    private int quantity;
    private int sum;

    public String getItem() {
        return item;
    }

    public boolean isExpense() {
        return expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum() {
        return sum;
    }

    public Product(){

    }

    public Product(String item, boolean expense, int quantity, int sum) {
        this.item = item;
        this.expense = expense;
        this.quantity = quantity;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item='" + item + '\'' +
                ", expense=" + expense +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }
}
