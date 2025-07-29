import java.util.Scanner;

public class Students {
    Scanner sc = new Scanner(System.in);
    student theStudents[] = new student[50];
    public static int cnt = 0;
    //method to add
    public void addStudent(student s){
        for (int i = 0; i < cnt; i++) {
            if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){
                System.out.println("Student of registration Number is "+s.regNum+" Already exists");
                return;
            }
        }
        if(cnt<=50){
            theStudents[cnt] = s;
            cnt++;
        }
    }
    //display all students
    public void showAllStudents(){
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < cnt; i++) {
            System.out.println(theStudents[i].studentName+"\t\t"+theStudents[i].regNum);
        }
    }
    //to check student
    public int isStudent(){
        System.out.println("Enter reg Number: ");
        String regNum = sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if(theStudents[i].regNum.equalsIgnoreCase(regNum))return i;
        }
        System.out.println("Student is not registered.");
        System.out.println("get registered first ");
        return -1;
    }
    //remove the book
    public void checkOutBook(books book){
        int studentIdx = this.isStudent();
        if(studentIdx!=-1){
            System.out.println("Checking out");
            book.showAllBooks();
            book b = book.checkOutBook();
            System.out.println("checking out");
            if(b!=null){
                if(theStudents[studentIdx].booksCount<=3){
                    System.out.println("adding bbok");
                    theStudents[studentIdx].borrowedBooks[theStudents[studentIdx].booksCount] = b;
                    theStudents[studentIdx].booksCount++;
                    return;
                }
                else{
                    System.out.println("Student cannot borrow more than 3 books ");
                    return;
                }
            }
            System.out.println("Book is Not available");
        }
    }
    //To add the book
    public void checkInBook(books book){
        int studentIdx = this.isStudent();
        if(studentIdx!=-1){
            System.out.println("S.No\\t\\t\\tBook Name\\t\\t\\tAuthor Name");
            student s = theStudents[studentIdx];

            for (int i=0;i<s.booksCount;i++){
                System.out.println(s.borrowedBooks[i].sNo+"\t\t\t"+s.borrowedBooks[i].bookName+"\t\t\t"+s.borrowedBooks[i].authorName);
            }
            System.out.println("Enter the serial Number of Book to be checked in");
            int sNo = sc.nextInt();
            for (int i = 0; i < s.booksCount; i++) {
                if(sNo==s.borrowedBooks[i].sNo){
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }
            System.out.println("Book of serial no "+sNo+ " not found.");
        }
    }
}