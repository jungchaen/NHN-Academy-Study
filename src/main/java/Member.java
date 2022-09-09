public class Member {
    private String id;
    private String pw;
    private String userName;
    private String email;
    private String phoneNumber;

    public Member(String id, String pw, String userName, String email, String phoneNumber) {
        this.id = id;
        this.pw = pw;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public String getPw() {
        return pw;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
