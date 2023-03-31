package lk.kdu.detcwa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String u_name;
    private String u_u_name;
    private String u_password;
    private String u_url;
    private String u_rank;
    private String u_role;

    public User() {
    }

    public User(String u_name, String u_u_name, String u_password, String u_url, String u_rank, String u_role) {
        this.u_name = u_name;
        this.u_u_name = u_u_name;
        this.u_password = u_password;
        this.u_url = u_url;
        this.u_rank = u_rank;
        this.u_role = u_role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_u_name() {
        return u_u_name;
    }

    public void setU_u_name(String u_u_name) {
        this.u_u_name = u_u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_url() {
        return u_url;
    }

    public void setU_url(String u_url) {
        this.u_url = u_url;
    }

    public String getU_rank() {
        return u_rank;
    }

    public void setU_rank(String u_rank) {
        this.u_rank = u_rank;
    }

    public String getU_role() {
        return u_role;
    }

    public void setU_role(String u_role) {
        this.u_role = u_role;
    }
}
