import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    SignUp signUp;
    Login login;

    public void runMemberMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int menuNumber;

        while (true) {
            System.out.println("\n<메인화면>");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.print("메뉴번호를 선택하세요: ");
            menuNumber = Integer.parseInt(br.readLine());

            switch (menuNumber) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    signUp = SignUp.createMember();
                    break;
                default:
                    System.out.println("메뉴를 잘못 선택하였습니다.");
                    break;
            }
        }
    }

    public void loginMenu() throws IOException {
        boolean checkChoiceLoginNumber = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (checkChoiceLoginNumber) {
            System.out.println("\n<로그인 메뉴>");
            System.out.println("1. 로그인하기");
            System.out.println("2. 메인화면으로 돌아가기");
            System.out.print("로그인 메뉴번호를 선택하세요: ");
            int loginMenuNumber = Integer.parseInt(br.readLine());

            switch (loginMenuNumber) {
                case 1:
                    try {
                        login = new Login(signUp.getUserMap());
                    } catch (NullPointerException e) {
                        System.out.println("※회원가입 먼저 진행해주세요!\n");
                        checkChoiceLoginNumber = false;
                        break;
                    }
                    System.out.print("ID: ");
                    String id = br.readLine();
                    System.out.print("PW: ");
                    String pw = br.readLine();
                    try {
                        login.matchLoginIdPW(id, pw);
                        if (login.getSuccessLogin()) {
                            try {
                                checkChoiceLoginNumber = afterLoginMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("로그인 실패하였습니다.");
                    }
                    break;
                case 2:
                    checkChoiceLoginNumber = false;
                    break;
                default:
                    break;
            }
        }
    }

    public boolean afterLoginMenu() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n1. 로그아웃");
        System.out.println("2. 회원탈퇴");
        System.out.print("번호를 선택하세요: ");
        int choiceAfterLogin = Integer.parseInt(br.readLine());
        if (choiceAfterLogin == 1) {
            login.logOut();
            return false;
        }
        if (choiceAfterLogin == 2) {  //회원 탈퇴
            System.out.print("회원탈퇴 하시겠습니까?(y 또는 n 입력): ");
            String withdrawal = br.readLine();
            if (withdrawal.equals("y")) {
                System.out.print("비밀번호를 입력하세요: ");
                String pw = br.readLine();
                if (login.withdrawalCheckPw(pw)) {
                    return false;
                } else {
                    throw new Exception();
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
