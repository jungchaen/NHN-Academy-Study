import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    SignUp signUp;
    Login login;

    public void runMemberMenuChoice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int menuNumber;
        boolean checkChoiceNumber = true;

        while (checkChoiceNumber) {
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
                    } catch (NullPointerException e) {
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
}
