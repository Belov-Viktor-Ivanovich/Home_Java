import java.util.ArrayList;
import java.util.List;

public class YearReport {
    private List<Monthly>listMonth=new ArrayList<>();

    public List<Monthly> getListMonth() {
        return listMonth;
    }

    public void addMonth(Monthly monthly){
        listMonth.add(monthly);
    }

    @Override
    public String toString() {
        return "YearReport{" +
                "listMonth=" + listMonth +
                '}';
    }
    /*public int trueSum(){
        return listMonth.stream().filter(e->e.)
    }*/
}
