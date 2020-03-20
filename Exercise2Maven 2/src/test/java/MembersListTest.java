import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MembersListTest {

    @Test
    public void newMemberCanBeAdded(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        final int initialSize = memberList.getMembers().size();

        memberList.addMember(member);

        assertEquals(initialSize+1, memberList.getMembers().size());
    }

    @Test
    public void removeFirstMemberFromList(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        memberList.addMember(member);

        final int initialSize = memberList.getMembers().size();

        memberList.removeMember(0);

        assertEquals(initialSize-1, memberList.getMembers().size());
    }

    @Test
    public void removeSecondMemberFromList(){
        MembersList memberList = new MembersList();
        Member member = new Member();
        member.setName("Json Statham");
        member.setId("123");
        member.setAttended(false);
        memberList.addMember(member);

        Member secondMember = new Member();
        member.setName("JayZ");
        member.setId("1233");
        member.setAttended(false);
        memberList.addMember(secondMember);

        final int initialSize = memberList.getMembers().size();

        memberList.removeMember(1);

        assertEquals(initialSize-1, memberList.getMembers().size());

    }


}
