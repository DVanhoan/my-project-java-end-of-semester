package Model;

public class NguoiDung {
    public String userName;
    public String password;
    public String role;

    public NguoiDung(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
