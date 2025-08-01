import java.util.Scanner;

class library{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("********************Welcome to the Infinity Library!********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("**********************************************************************");
        //creating objects for book class
        books ob  =new books();
        //creating objects for students class
        Students obStudent = new Students();

        int choice;
        int searchChoice;
        do{
            ob.dispMenu();
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;
                case 2:
                    ob.upgradeBookQty();
                    break;
                case 3:
                    System.out.println(
                            " press 1 to Search with Book Serial No.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = sc.nextInt();

                    switch (searchChoice){
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;
            case 4:
                ob.showAllBooks();
                break;


            case 5:
                student s = new student();
                obStudent.addStudent(s);
                break;

            case 6:
                obStudent.showAllStudents();
                break;

            case 7:
                obStudent.checkOutBook(ob);
                break;

            case 8:
                obStudent.checkInBook(ob);
                break;
                default:
                    System.out.println("Enter the number between 0 to 8: ");
            }
        }while (choice!=0);
    }
}