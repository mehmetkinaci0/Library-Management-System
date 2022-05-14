package library;
public class IssuedBook {
    
    private int isbn;
    private int id;
    private String issueDate;
    private String dueDate;

    public IssuedBook(int isbn, int id, String issueDate, String dueDate) {
        this.isbn = isbn;
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    
}
