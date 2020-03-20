import java.util.ArrayList;
import java.util.List;

public class MembersList {

    private List<Member> members = new ArrayList<Member>();

    public MembersList(){ }

    public String toString() {
        return "Employee {" + "\n" +
                "member=" + members + "}";
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

   public void addMember(Member member){
        members.add(member);
    }

    public void removeMember(int index){
        members.remove(index);
    }
}
