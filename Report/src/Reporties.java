import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reporties {
    private List<Report>reportList=new ArrayList<>();
    private int year;

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public List<Report> getReportList() {
        return reportList;
    }
    public void addReport(String path,int year){
        this.year=year;
        File file=new File(path);
        try(Scanner reader=new Scanner(new FileReader(file))) {
            reader.nextLine();
            boolean b;
            while (reader.hasNext()){
                String[] str=reader.nextLine().split(",");

                if(str[2].equals("true"))b=true;
                else b=false;
                reportList.add(new Report(Integer.parseInt(str[0]),Integer.parseInt(str[1]),b));
            }
        }
        catch (Exception ex){

        }
    }

    @Override
    public String toString() {
        return "Reporties{" +
                "reportList=" + reportList +
                ", year=" + year +
                '}'+"\n\n";
    }
}
