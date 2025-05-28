package Problem9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<BookPdf> books = new ArrayList<>();
        books.add(new BookPdf(100, 5.0, "Short Book"));    // 20 pages/MB
        books.add(new BookPdf(300, 3.0, "Efficient Book")); // 100 pages/MB
        books.add(new BookPdf(200, 4.0, "Average Book"));   // 50 pages/MB



        Tools.greedBeach(110,books);


    }
}
