package Problem9;


import java.util.Comparator;

public class BookPdf implements Comparator<BookPdf> {

    public String name;
    public int pages;

    public double fileSize;


    public BookPdf(int pages, double fileSize, String name) {
        if(fileSize > 99) {
        throw new FileSizeException("file size must less or equal to 99MB");
        }
        this.name = name;
        this.pages = pages;
        this.fileSize = fileSize;
    }

    public BookPdf() {

    }


    @Override
    public int compare(BookPdf o1, BookPdf o2) {
        Double o1Ratio = o1.pages / o1.fileSize;
        Double o2Ratio = o2.pages / o2.fileSize;
        return o2Ratio.compareTo(o1Ratio);
    }
    @Override
    public String toString(){
    StringBuilder msg = new StringBuilder();
    msg.append("Book ").append(name).append(":\n");
    msg.append("Pages: ").append(pages).append(", Filesize: ")
            .append(fileSize).append(" ,Ratio: ").append(pages / fileSize).append("\n");
    return msg.toString();
    }
}
