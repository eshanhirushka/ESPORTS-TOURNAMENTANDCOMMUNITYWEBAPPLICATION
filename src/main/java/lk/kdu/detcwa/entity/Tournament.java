package lk.kdu.detcwa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String t_name;
    private String t_type_schedule;
    private String t_reg_start;
    private String t_reg_end;
    private String t_start_date;
    private String t_end_date;
    private String t_type;
    private String t_sport;
    private String t_status;

    public Tournament() {
    }

    public Tournament(String t_name, String t_type_schedule, String t_reg_start, String t_reg_end, String t_start_date, String t_end_date, String t_type, String t_sport, String t_status) {
        this.t_name = t_name;
        this.t_type_schedule = t_type_schedule;
        this.t_reg_start = t_reg_start;
        this.t_reg_end = t_reg_end;
        this.t_start_date = t_start_date;
        this.t_end_date = t_end_date;
        this.t_type = t_type;
        this.t_sport = t_sport;
        this.t_status = t_status;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_type_schedule() {
        return t_type_schedule;
    }

    public void setT_type_schedule(String t_type_schedule) {
        this.t_type_schedule = t_type_schedule;
    }

    public String getT_reg_start() {
        return t_reg_start;
    }

    public void setT_reg_start(String t_reg_start) {
        this.t_reg_start = t_reg_start;
    }

    public String getT_reg_end() {
        return t_reg_end;
    }

    public void setT_reg_end(String t_reg_end) {
        this.t_reg_end = t_reg_end;
    }

    public String getT_start_date() {
        return t_start_date;
    }

    public void setT_start_date(String t_start_date) {
        this.t_start_date = t_start_date;
    }

    public String getT_end_date() {
        return t_end_date;
    }

    public void setT_end_date(String t_end_date) {
        this.t_end_date = t_end_date;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getT_sport() {
        return t_sport;
    }

    public void setT_sport(String t_sport) {
        this.t_sport = t_sport;
    }

    public String getT_status() {
        return t_status;
    }

    public void setT_status(String t_status) {
        this.t_status = t_status;
    }
}
