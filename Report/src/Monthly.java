import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monthly {
    private int nMonth;
    private int year;
    private List<Product>products=new ArrayList<>();


    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setnMonth(int nMonth) {
        this.nMonth = nMonth;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getnMonth() {
        return nMonth;
    }

    public List<Product> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "Monthly{" +
                "nMonth=" + nMonth +
                ", year=" + year +
                ", products=" + products +
                '}'+"\n";
    }

    public void addProduct(String path){
        File file=new File(path);
        try(Scanner reader=new Scanner(new FileReader(file))) {
            reader.nextLine();
            boolean b;
            while (reader.hasNext()){
                String[] str=reader.nextLine().split(",");

                if(str[1].equals("TRUE"))b=true;
                else b=false;
                products.add(new Product(str[0],b,Integer.parseInt(str[2]),Integer.parseInt(str[3])));
            }
        }
        catch (Exception ex){

        }
    }
}
