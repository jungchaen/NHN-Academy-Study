import java.util.Collection;
import java.util.Map;

public class Login {
    boolean isFindMember;

    Map<String, Member> userMap;

    public Login(Map<String, Member> userMap) {
        this.userMap = userMap;
    }

    public void matchLoginIdPW(String id, String pw) throws NullPointerException {
        Collection<Member> members = userMap.values(); //저장된 value값들을 반환
        for (Member member : members) {
            if (member.getId().equals(id) && member.getPw().equals(pw)) {
                isFindMember = true;
                break;
            }
        }

        if (isFindMember) {
            System.out.println("로그인 되었습니다.");
            printUserData(userMap);
        } else {
            throw new NullPointerException();
        }

    }

    public void printUserData(Map<String, Member> userMap) {
        Collection<Member> members = userMap.values();
        for (Member member : members) {
            System.out.println("이름: " + member.getUserName());
            System.out.println("email: " + member.getEmail());
            System.out.println("핸드폰 번호: " + member.getPhoneNumber());
        }
    }
}
