/**
* Invoicer
*/
import java.util.*;


class Book {
    // private by default
    String name;
    double price;
    
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // getters/setters understood
}

class InvoiceService {
    
    int invoiceId;
    
    public InvoiceService() {
        invoiceId = 0;
    }
    
    public double calculateTotal(Book book) {
        return book.price;
    }
    
    public void printInvoice() {
        System.out.println("Here's the invoice: ");
    }
    
    public void saveToDatabase() {
        System.out.println("Invoice saved to database");
    }

    public void prepareInvoice(Book book) {
        int invoiceId = this.getInvoiceId();
        System.out.println("book is invoiced with inv number: " + invoiceId);
    }
    
    private int getInvoiceId() {
        this.invoiceId++;
        return this.invoiceId;
    }
}

public class Invoicer {
    public static void main(String[] args) {
        Book book = new Book("GOT", 200);
        Book book2 = new Book("LOTR", 300);
        List<Book> books = List.of(book, book2);
        
        InvoiceService invoiceService = new InvoiceService();
        
        for (var bookVar : books) {
            invoiceService.prepareInvoice(bookVar);
        }
    }
}