import java.util.Scanner;


public class book {
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner sc = new Scanner(System.in);
    public book(){
        System.out.print("Enter Serial no. of Book: ");
        this.sNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the Book Name: ");
        this.bookName = sc.nextLine();

        System.out.print("Enter the author Name: ");
        this.authorName = sc.nextLine();

        System.out.print("Enter the Quantity of books: ");
        this.bookQty = sc.nextInt();
        bookQtyCopy = this.bookQty;
    }
}