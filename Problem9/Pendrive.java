package Problem9;

import java.awt.print.Book;
import java.util.ArrayList;

public class Pendrive {

    public ArrayList<BookPdf> contentList = new ArrayList<BookPdf>();

    public double size;

    public double currentSize;

    public Pendrive(double size){
        this.size = size;
    }

    public void addBookPdf(int pages, double size, String name) {
        BookPdf book = new BookPdf(pages, size, name);

        if(book.fileSize + currentSize <= this.size){
            currentSize += book.fileSize;

            System.out.println("Book was added to the pendrive");
            System.out.print(book);
            System.out.println("Current pendrive size: " + currentSize);
            System.out.println("Space remaining on storage: " + (this.size - currentSize));
            System.out.println();
            contentList.add(book);
        }
        else{
            System.out.println("Could not add book: ");
            System.out.print(book);
            System.out.printf("bookFile size is: %.2f and is bigger them the remaining storage: %.2f\n",book.fileSize,(size - currentSize));
        }


    }
    public String toString(){
        StringBuilder msg = new StringBuilder();
        for (BookPdf b : contentList) {
            msg.append(b);
        }
        return msg.toString();
    }
}
