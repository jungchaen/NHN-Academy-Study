import java.util.Collection;
import java.util.Map;

public class Login {
    boolean isFindPw;
    boolean isFindId;

    Map<String, Member> userMap;

    public Login(Map<String, Member> userMap) {
        this.userMap = userMap;
    }

    public void matchLoginIdPW(String id, String pw) throws NullPointerException {
        Collection<Member> members = userMap.values(); //저장된 value값들을 반환
        for (Member member : members) {
            if (member.getId().equals(id)) {
                isFindId = true;
                break;
            }
            if (member.getPw().equals(pw)) {
                isFindPw = true;
                break;
            }
        }

        if (isFindId && isFindPw) {
            System.out.println("로그인 되었습니다.");
            printUserData(userMap);
        } else {
            throw new NullPointerException();
        }

    }

    public void printUserData(Map<String, Member> userMap) {
        Collection<Member> members = userMap.values();
        for (Member member : members) {
            System.out.println(member.getUserName());
            System.out.println(member.getEmail());
            System.out.println(member.getPhoneNumber());
        }
    }
}
