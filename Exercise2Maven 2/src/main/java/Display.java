import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Display {

    private Scanner reader;
    private Attendance attendance;

    public Display(){
        this.reader = new Scanner(System.in);
        this.attendance = new Attendance();
    }

    public void start() throws IOException {
        welcomeScreen();
        options();
    }

    public void printOptions(){
        System.out.println("--------------------------------");
        System.out.println("Press (1) to go through list of employees and mark their attendance");
        System.out.println("Press (2) to print last loaded attendance sheet");
        System.out.println("Press (3) to add a new member to the list");
        System.out.println("Press (4) to remove member from the list");
        System.out.println("Press (5) to quit and save");
    }

    public void welcomeScreen(){
        System.out.println("Welcome to attendance app");
        System.out.println("Lets take some attendance, shall we?");
        printOptions();

    }

    public void options() throws IOException {
        while(true){

            String response = reader.nextLine();

            if (response.equals("1")){
                attendance.goThroughListAndSetAttendance();
                attendance.saveUpdatedAttendanceSheet();
                attendance.printUpdatedAttendanceSheet();
                printOptions();
            }
            else if (response.equals("2")){
                attendance.printUpdatedAttendanceSheet();
                printOptions();
            }
            else if (response.equals("3")){
                attendance.addMember();
                printOptions();

            }
            else if (response.equals("4")){
                attendance.removeMember();
                printOptions();
            }
            else if (response.equals("5")){
                System.out.println("Thank you for using Attendance app");
                break;
            }
            else {
                System.out.println("You have not chosen any of below");
                printOptions();
            }

        }
    }

}
