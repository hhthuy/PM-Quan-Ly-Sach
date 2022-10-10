package bookstore.Entity;

/**
 * 
 * @author Nhom5
 *
 */
public class TaiKhoan {

    final public static int SYSTEM = 1;
    final public static int BOOK = 2;
    final public static int BILL = 4;
    final public static int CUSTOMER = 8;
    final public static int STATS = 16;
    final public static int ACCOUNT = 32;
    private int accountId;
    private String username;
    private String password;
    private int permission;
    private String accountName;
    private byte gender;
    private String dateOfBirth;
    private String phone;
    private String address;
    private byte status;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public byte getGender() {
        return gender;
    }

    public String getStringGender() {
        String s;
        switch (this.gender) {
            case 0:
                s = "Nam";
                break;
            case 1:
                s = "Nữ";
                break;
            default:
                s = "???";
        }
        return s;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public boolean hasPermission(int permission) {
        return (this.permission & permission) != 0;
    }

    public void addPermission(int permission) {
        this.permission |= permission;
    }

    public void removePermission(int permission) {
        this.permission &= ~permission;
    }

//    public java.sql.Date getSqlDate() {
//        return new java.sql.Date(this.dateOfBirth.getTime());
//    }

    public String toString() {
        return this.accountName;
    }
}
