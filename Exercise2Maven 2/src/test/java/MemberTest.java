import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    public void IDcanBeChanged(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        memberList.addMember(member);

        member.setId("324");
        final String newID = "324";

       assertEquals(newID, memberList.getMembers().get(0).getId());
    }

    @Test
    public void NamecanBeChanged(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        memberList.addMember(member);

        member.setName("Jackson");
        final String newName = "Jackson";

        assertEquals(newName, memberList.getMembers().get(0).getName());
    }

    @Test
    public void AttendanceCanBeChanged(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        memberList.addMember(member);

        member.setAttended(true);
        final boolean newAttendance = true;

        assertEquals(newAttendance, memberList.getMembers().get(0).isAttended());
    }
}
