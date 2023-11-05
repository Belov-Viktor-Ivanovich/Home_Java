import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        File resoursesFiles = new File("./resources");
        YearReport yearReport = new YearReport();
        ListYearReports listYearReports = new ListYearReports();
        if (resoursesFiles.exists()) {
            File[] files = resoursesFiles.listFiles();
            for (int i = 0; i < files.length; i++) {
                int length = files[i].getName().length();
                if (files[i].getName().startsWith("m")) {
                    Monthly monthly = new Monthly();
                    monthly.setnMonth(Integer.parseInt(files[i].getName().substring(length - 6, length - 4)));
                    monthly.setYear(Integer.parseInt(files[i].getName().substring(length - 10, length - 6)));
                    monthly.addProduct(files[i].getAbsolutePath());
                    yearReport.addMonth(monthly);
                } else if (files[i].getName().startsWith("y")) {
                    Reporties reporties = new Reporties();
                    reporties.addReport(files[i].getAbsolutePath(), Integer.parseInt(files[i].getName().substring(length - 8, length - 4)));
                    listYearReports.addYearReport(reporties);
                }
            }
        }
        List<MON> mons = new ArrayList<>();
        int lenght = yearReport.getListMonth().size();
        for (int i = 0; i < lenght; i++) {
            int[] mas = new int[4];
            mas[0] = yearReport.getListMonth().get(i).getYear();
            mas[1] = yearReport.getListMonth().get(i).getnMonth();

            for (int j = 0; j < yearReport.getListMonth().get(i).getProducts().size(); j++) {
                if (yearReport.getListMonth().get(i).getProducts().get(j).isExpense()) {
                    mas[2] += yearReport.getListMonth().get(i).getProducts().get(j).getQuantity() * yearReport.getListMonth().get(i).getProducts().get(j).getSum();
                } else
                    mas[3] += yearReport.getListMonth().get(i).getProducts().get(j).getQuantity() * yearReport.getListMonth().get(i).getProducts().get(j).getSum();
            }
            mons.add(new MON(mas[0], mas[1], mas[3], mas[2]));

        }
        List<MON> year = new ArrayList<>();
        Map<Integer, Integer> mapPlus = new HashMap<>();
        Map<Integer, Integer> mapMinus = new HashMap<>();
        lenght = listYearReports.getYearReportList().size();
        for (int i = 0; i < lenght; i++) {
            int[] mas = new int[2];
            mas[0] = listYearReports.getYearReportList().get(i).getYear();

            for (int j = 0; j < listYearReports.getYearReportList().get(i).getReportList().size(); j++) {
                if (listYearReports.getYearReportList().get(i).getReportList().get(j).isExpense())
                    mapMinus.put(listYearReports.getYearReportList().get(i).getReportList().get(j).getMonth(), listYearReports.getYearReportList().get(i).getReportList().get(j).getCount());
                else
                    mapPlus.put(listYearReports.getYearReportList().get(i).getReportList().get(j).getMonth(), listYearReports.getYearReportList().get(i).getReportList().get(j).getCount());

            }

            int key;
            int value;
            for (var el : mapPlus.entrySet()
            ) {
                key = el.getKey();
                value = el.getValue();
                year.add(new MON(mas[0],key,value,mapMinus.get(key)));

            }


        }
        System.out.println(mons.equals(year)?"Соответствует":"Не соответствует");
    }

}