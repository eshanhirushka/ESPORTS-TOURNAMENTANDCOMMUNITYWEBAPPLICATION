package lk.kdu.detcwa.dto;

public class AdminDTO {

    private int aid;
    private String a_name;
    private String a_u_name;
    private String a_password;
    private String a_url;
    private String a_rank;
    private String a_role;

    public AdminDTO() {
    }

    public AdminDTO(int aid, String a_name, String a_u_name, String a_password, String a_url, String a_rank, String a_role) {
        this.aid = aid;
        this.a_name = a_name;
        this.a_u_name = a_u_name;
        this.a_password = a_password;
        this.a_url = a_url;
        this.a_rank = a_rank;
        this.a_role = a_role;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_u_name() {
        return a_u_name;
    }

    public void setA_u_name(String a_u_name) {
        this.a_u_name = a_u_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_url() {
        return a_url;
    }

    public void setA_url(String a_url) {
        this.a_url = a_url;
    }

    public String getA_rank() {
        return a_rank;
    }

    public void setA_rank(String a_rank) {
        this.a_rank = a_rank;
    }

    public String getA_role() {
        return a_role;
    }

    public void setA_role(String a_role) {
        this.a_role = a_role;
    }
}
