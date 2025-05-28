package Problem9;

import java.util.List;

public class Tools {

    public static void greedBeach(double pendriveSize, List<BookPdf> bookPdfsList){
        bookPdfsList.sort(new BookPdf());
        Pendrive pendrive = new Pendrive(pendriveSize);
        for(BookPdf bookPdf: bookPdfsList){
            pendrive.addBookPdf(bookPdf.pages, bookPdf.fileSize, bookPdf.name);
        }
        System.out.printf("at the end %d books were added, the current size is: %.2f and the remaining is : %.2f, here is the list:\n\n",pendrive.contentList.size(),pendrive.currentSize,(pendrive.size - pendrive.currentSize));
        System.out.print(pendrive);
    }
}
