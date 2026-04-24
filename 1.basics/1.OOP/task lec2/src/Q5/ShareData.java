package Q5;

public class ShareData extends BaseEntity {
    protected String phone;

    public ShareData(int id, String name, String phone) {
        super(id, name);
        setPhone(phone);
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() >= 10) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must be at least 10 digits");
        }
    }

    public void printShareData() {
        printBase();
        System.out.println("Phone: " + phone);
    }
}