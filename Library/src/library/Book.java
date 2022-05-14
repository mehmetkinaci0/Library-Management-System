package library;
public class Book {
    
    private int isbn;
    private String name;
    private String writer;
    private int page;
    private String publisher;
    private int publisherYear;
    private String issued;

    public Book(int isbn, String name, String writer, int page, String publisher, int publisherYear, String issued) {
        this.isbn = isbn;
        this.name = name;
        this.writer = writer;
        this.page = page;
        this.publisher = publisher;
        this.publisherYear = publisherYear;
        this.issued = issued;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }
    
    
}
