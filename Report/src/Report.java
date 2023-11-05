public class Report {
    private int month;
    private int count;
    private boolean expense;
    public void setMonth(int month) {
        this.month = month;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public int getMonth() {
        return month;
    }


    public int getCount() {
        return count;
    }

    public boolean isExpense() {
        return expense;
    }



    public Report(int month, int count, boolean expense) {
        this.month = month;
        this.count = count;
        this.expense = expense;

    }

    @Override
    public String toString() {
        return "Report{" +
                "month=" + month +
                ", count=" + count +
                ", expense=" + expense +
                '}';
    }
}
