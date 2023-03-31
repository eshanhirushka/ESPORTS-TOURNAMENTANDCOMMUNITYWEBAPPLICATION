package lk.kdu.detcwa.dto;

public class AdminTouANDTouDTO {

    private int att_adid;
    private int att_ad_tid;
    private int att_ad_aid;
    private String att_ad_join_type;
    private int att_tid;
    private String att_t_name;
    private String att_t_type_schedule;
    private String att_t_reg_start;
    private String att_t_reg_end;
    private String att_t_start_date;
    private String att_t_end_date;
    private String att_t_type;
    private String att_t_sport;
    private String att_t_status;

    public AdminTouANDTouDTO() {
    }

    public AdminTouANDTouDTO(int att_adid, int att_ad_tid, int att_ad_aid, String att_ad_join_type, int att_tid, String att_t_name, String att_t_type_schedule, String att_t_reg_start, String att_t_reg_end, String att_t_start_date, String att_t_end_date, String att_t_type, String att_t_sport, String att_t_status) {
        this.att_adid = att_adid;
        this.att_ad_tid = att_ad_tid;
        this.att_ad_aid = att_ad_aid;
        this.att_ad_join_type = att_ad_join_type;
        this.att_tid = att_tid;
        this.att_t_name = att_t_name;
        this.att_t_type_schedule = att_t_type_schedule;
        this.att_t_reg_start = att_t_reg_start;
        this.att_t_reg_end = att_t_reg_end;
        this.att_t_start_date = att_t_start_date;
        this.att_t_end_date = att_t_end_date;
        this.att_t_type = att_t_type;
        this.att_t_sport = att_t_sport;
        this.att_t_status = att_t_status;
    }

    public int getAtt_adid() {
        return att_adid;
    }

    public void setAtt_adid(int att_adid) {
        this.att_adid = att_adid;
    }

    public int getAtt_ad_tid() {
        return att_ad_tid;
    }

    public void setAtt_ad_tid(int att_ad_tid) {
        this.att_ad_tid = att_ad_tid;
    }

    public int getAtt_ad_aid() {
        return att_ad_aid;
    }

    public void setAtt_ad_aid(int att_ad_aid) {
        this.att_ad_aid = att_ad_aid;
    }

    public String getAtt_ad_join_type() {
        return att_ad_join_type;
    }

    public void setAtt_ad_join_type(String att_ad_join_type) {
        this.att_ad_join_type = att_ad_join_type;
    }

    public int getAtt_tid() {
        return att_tid;
    }

    public void setAtt_tid(int att_tid) {
        this.att_tid = att_tid;
    }

    public String getAtt_t_name() {
        return att_t_name;
    }

    public void setAtt_t_name(String att_t_name) {
        this.att_t_name = att_t_name;
    }

    public String getAtt_t_type_schedule() {
        return att_t_type_schedule;
    }

    public void setAtt_t_type_schedule(String att_t_type_schedule) {
        this.att_t_type_schedule = att_t_type_schedule;
    }

    public String getAtt_t_reg_start() {
        return att_t_reg_start;
    }

    public void setAtt_t_reg_start(String att_t_reg_start) {
        this.att_t_reg_start = att_t_reg_start;
    }

    public String getAtt_t_reg_end() {
        return att_t_reg_end;
    }

    public void setAtt_t_reg_end(String att_t_reg_end) {
        this.att_t_reg_end = att_t_reg_end;
    }

    public String getAtt_t_start_date() {
        return att_t_start_date;
    }

    public void setAtt_t_start_date(String att_t_start_date) {
        this.att_t_start_date = att_t_start_date;
    }

    public String getAtt_t_end_date() {
        return att_t_end_date;
    }

    public void setAtt_t_end_date(String att_t_end_date) {
        this.att_t_end_date = att_t_end_date;
    }

    public String getAtt_t_type() {
        return att_t_type;
    }

    public void setAtt_t_type(String att_t_type) {
        this.att_t_type = att_t_type;
    }

    public String getAtt_t_sport() {
        return att_t_sport;
    }

    public void setAtt_t_sport(String att_t_sport) {
        this.att_t_sport = att_t_sport;
    }

    public String getAtt_t_status() {
        return att_t_status;
    }

    public void setAtt_t_status(String att_t_status) {
        this.att_t_status = att_t_status;
    }
}
