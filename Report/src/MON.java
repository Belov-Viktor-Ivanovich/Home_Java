import java.util.Objects;

public class MON {
    private int year;
    private int month;
    private int plus;
    private int minus;



    public MON(int year, int month, int plus, int minus) {
        this.year = year;
        this.month = month;
        this.plus = plus;
        this.minus = minus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MON mon = (MON) o;
        return year == mon.year && month == mon.month && plus == mon.plus && minus == mon.minus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, plus, minus);
    }

    public int getMonth() {
        return month;
    }

    public int getPlus() {
        return plus;
    }

    public int getMinus() {
        return minus;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }

    public int getYear() {
        return year;
    }



    public void setYear(int year) {
        this.year = year;
    }


}
