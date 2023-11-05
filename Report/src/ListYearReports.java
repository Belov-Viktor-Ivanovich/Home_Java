import java.util.ArrayList;
import java.util.List;

public class ListYearReports {


    private List<Reporties>yearReportList=new ArrayList<>();

    public List<Reporties> getYearReportList() {
        return yearReportList;
    }

    public void addYearReport(Reporties reporties){
        yearReportList.add(reporties);
    }

    @Override
    public String toString() {
        return "ListYearReports{" +
                "yearReportList=" + yearReportList +
                '}';
    }
}
