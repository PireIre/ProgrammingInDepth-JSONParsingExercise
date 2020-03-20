import java.io.IOException;
import java.util.Scanner;

public class Attendance {

    private JSONFileHandler fileHandler;
    private MembersList membersList;
    private Scanner reader;

    public Attendance() {
        this.fileHandler = new JSONFileHandler();
        this.membersList = new MembersList();
        this.reader = new Scanner(System.in);
    }

    public void goThroughListAndSetAttendance() throws IOException {
        membersList = fileHandler.ReadMembersList();

        System.out.println("Type (1) if member is present");
        System.out.println("Type (2) if members is missing");
        System.out.println("------------------------------");

        for (int i = 0; i < membersList.getMembers().size(); i++) {
            System.out.println(membersList.getMembers().get(i));
            String response = reader.nextLine();

            if (response.equals("1")) {
                membersList.getMembers().get(i).setAttended(true);
            } else if (response.equals("2")) {
                membersList.getMembers().get(i).setAttended(false);
            } else {
                System.out.println("You have not set the right option");
                System.out.println("By default, member: " + membersList.getMembers().get(i).getName() + " is set to NOT PRESENT");
                System.out.println("To update this, you will need to start application from top");
                System.out.println("----------------------------------------------------------");
            }

        }
    }

    public void printUpdatedAttendanceSheet() throws IOException {
        membersList = fileHandler.ReadMembersList();
        int counter = 0;

        System.out.println("Updated attendance sheet:");
        System.out.println("-------------------------");
        for (int i = 0; i < membersList.getMembers().size(); i++) {
            counter++;
            System.out.print(counter + " ");
            System.out.println(membersList.getMembers().get(i));
        }
    }

    public void saveUpdatedAttendanceSheet() throws IOException {
        fileHandler.writeUpdatedMembersList(membersList);
    }

    public void addMember() throws IOException {
        membersList = fileHandler.ReadMembersList();
        System.out.println("Add new Member \n");
        System.out.println("Name of Member:");

        Member member = new Member();
        member.setName(reader.nextLine());
        System.out.println("Member's ID number:");

            for (int i = 0; i<membersList.getMembers().size(); i++){
                String createID = reader.nextLine();

                if (!membersList.getMembers().get(i).getId().equals(createID)){
                    member.setId(createID);
                    break;
                }
                else{
                    System.out.println("ID already in use, please select different ID");
                }
            }
        member.setAttended(false);

        membersList.addMember(member);
        System.out.println("New member was added");
        fileHandler.writeUpdatedMembersList(membersList);

    }

    public void removeMember() throws IOException {
        membersList = fileHandler.ReadMembersList();
        System.out.println("Which member below would you like to remove? \n");
        printUpdatedAttendanceSheet();
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter the number in front of the member you want to remove");

        while (true) {
            try {
                int removeMemberByIndex = Integer.parseInt(reader.nextLine());
                membersList.removeMember(removeMemberByIndex - 1);
                break;
            } catch (Exception e) {
                System.out.println("Index selected is not in reach. Select number in front of task again:");
            }
        }
        System.out.println("Member is removed");
        fileHandler.writeUpdatedMembersList(membersList);
    }
}
