import java.util.Collection;
import java.util.Map;

public class Login {
    boolean isFindMember;

    boolean successLogin;
    Map<String, Member> userMap;

    public Login(Map<String, Member> userMap) {
        this.userMap = userMap;
    }

    public boolean getSuccessLogin() {
        return successLogin;
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
            successLogin = true;
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

    public void logOut() {
        System.out.println("로그아웃 되었습니다.");
    }

    public boolean withdrawalCheckPw(String pw) {
        Collection<Member> members = userMap.values();
        for (Member member : members) {
            if (member.getPw().equals(pw)) {
                userMap.values().remove(member);
                System.out.println("회원탈퇴 되었습니다.");
                return true;
            }
        }
        return false;
    }

    public Map<String, Member> getUserMap() {
        return this.userMap;
    }
}
