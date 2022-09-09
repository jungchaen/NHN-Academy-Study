import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class SignUp {
    Map<String, Member> userMap;

    public SignUp(String id, String pw, String userName, String email, String phoneNumber) {
        String uuid = UUID.randomUUID().toString();
        userMap = new HashMap<>();
        userMap.put(uuid, new Member(id, pw, userName, email, phoneNumber)); //key-uuid, value-member 객체
    }

    public static SignUp createMember() {
        System.out.println("\n<회원가입>");
        Scanner scanner = new Scanner(System.in);
        /* ID 체크 */
        System.out.print("ID(영문 소문자, 숫자만 허용 / 5자리 이상 20자 이하): ");
        String id = scanner.nextLine();

        while (!isID(id) || id.length() < 5 || id.length() > 20) {
            System.out.println("잘못된 ID입니다. 다시 입력해주세요.");
            System.out.print("ID(영문 소문자, 숫자만 허용 / 5자리 이상 20자 이하): ");
            id = scanner.nextLine();
        }

        /* PW 체크 */
        System.out.print("PW(영문 대소문자, 숫자, 특수문자를 무조건 포함 / 8자 이상 20자 이하): ");
        String pw = scanner.nextLine();

        while (!isPW(pw) || pw.length() < 8 || pw.length() > 20) {
            System.out.println("잘못된 PW입니다. 다시 입력해주세요.");
            System.out.print("PW(영문 대소문자, 숫자, 특수문자를 무조건 포함 / 8자 이상 20자 이하): ");
            pw = scanner.nextLine();
        }

        /* 이름 */
        System.out.print("성명: ");
        String name = scanner.nextLine();

        /* 이메일 체크 */
        System.out.print("email(중복 이메일 허용불가): ");
        String email = scanner.nextLine();

        while (!isEmail(email)) {
            System.out.println("잘못된 이메일입니다. 다시 입력해주세요.");
            System.out.print("email(중복 이메일 허용불가): ");
            email = scanner.nextLine();
        }

        /* 핸드폰 번호 체크 */
        System.out.print("핸드폰 번호(010-xxxx-xxxx / 010xxxxxxxx): ");
        String phoneNumber = scanner.nextLine();

        while (!isPhoneNumber(phoneNumber)) {
            System.out.println("잘못된 핸드폰 번호입니다. 다시 입력해주세요.");
            System.out.print("핸드폰 번호(010-xxxx-xxxx / 010xxxxxxxx): ");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("회원가입이 완료되었습니다.");
        return new SignUp(id, pw, name, email, phoneNumber);
    }

    public static boolean isID(String id) {
        return Pattern.matches("^[0-9a-z]*$", id); //숫자, 소문자와 매치
    }

    public static boolean isPW(String pw) {  //
        return Pattern.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[0-9a-zA-Z!@#$%^&*]*$", pw); //대소문자, 숫자, 특수문자 무조건 포함
    }

    public static boolean isEmail(String email) {
        return Pattern.matches("^[0-9a-zA-Z._-]+@[0-9a-zA-Z]+(\\.[a-zA-Z]+)$", email);
    }

    public static boolean isPhoneNumber(String phoneNumber) {
        return Pattern.matches("^010[-]*\\d{4}[-]*\\d{4}$", phoneNumber);
    }

    public Map<String, Member> getUserMap() {
        return this.userMap;
    }
}
