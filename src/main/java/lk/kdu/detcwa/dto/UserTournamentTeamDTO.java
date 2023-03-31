package lk.kdu.detcwa.dto;

public class UserTournamentTeamDTO {

    private int uttid;
    private int utt_utid;
    private int utt_ut_uid;
    private int utt_ut_tid;
    private String utt_ut_join_type;
    private String utt_ut_team;
    private String utt_ut_role;
    private String utt_ut_rank;
    private String utt_ut_u_name;
    private String utt_ut_u_role;
    private String utt_ut_u_rank;

    public UserTournamentTeamDTO() {
    }

    public UserTournamentTeamDTO(int uttid, int utt_utid, int utt_ut_uid, int utt_ut_tid, String utt_ut_join_type, String utt_ut_team, String utt_ut_role, String utt_ut_rank, String utt_ut_u_name, String utt_ut_u_role, String utt_ut_u_rank) {
        this.uttid = uttid;
        this.utt_utid = utt_utid;
        this.utt_ut_uid = utt_ut_uid;
        this.utt_ut_tid = utt_ut_tid;
        this.utt_ut_join_type = utt_ut_join_type;
        this.utt_ut_team = utt_ut_team;
        this.utt_ut_role = utt_ut_role;
        this.utt_ut_rank = utt_ut_rank;
        this.utt_ut_u_name = utt_ut_u_name;
        this.utt_ut_u_role = utt_ut_u_role;
        this.utt_ut_u_rank = utt_ut_u_rank;
    }

    public int getUttid() {
        return uttid;
    }

    public void setUttid(int uttid) {
        this.uttid = uttid;
    }

    public int getUtt_utid() {
        return utt_utid;
    }

    public void setUtt_utid(int utt_utid) {
        this.utt_utid = utt_utid;
    }

    public int getUtt_ut_uid() {
        return utt_ut_uid;
    }

    public void setUtt_ut_uid(int utt_ut_uid) {
        this.utt_ut_uid = utt_ut_uid;
    }

    public int getUtt_ut_tid() {
        return utt_ut_tid;
    }

    public void setUtt_ut_tid(int utt_ut_tid) {
        this.utt_ut_tid = utt_ut_tid;
    }

    public String getUtt_ut_join_type() {
        return utt_ut_join_type;
    }

    public void setUtt_ut_join_type(String utt_ut_join_type) {
        this.utt_ut_join_type = utt_ut_join_type;
    }

    public String getUtt_ut_team() {
        return utt_ut_team;
    }

    public void setUtt_ut_team(String utt_ut_team) {
        this.utt_ut_team = utt_ut_team;
    }

    public String getUtt_ut_role() {
        return utt_ut_role;
    }

    public void setUtt_ut_role(String utt_ut_role) {
        this.utt_ut_role = utt_ut_role;
    }

    public String getUtt_ut_rank() {
        return utt_ut_rank;
    }

    public void setUtt_ut_rank(String utt_ut_rank) {
        this.utt_ut_rank = utt_ut_rank;
    }

    public String getUtt_ut_u_name() {
        return utt_ut_u_name;
    }

    public void setUtt_ut_u_name(String utt_ut_u_name) {
        this.utt_ut_u_name = utt_ut_u_name;
    }

    public String getUtt_ut_u_role() {
        return utt_ut_u_role;
    }

    public void setUtt_ut_u_role(String utt_ut_u_role) {
        this.utt_ut_u_role = utt_ut_u_role;
    }

    public String getUtt_ut_u_rank() {
        return utt_ut_u_rank;
    }

    public void setUtt_ut_u_rank(String utt_ut_u_rank) {
        this.utt_ut_u_rank = utt_ut_u_rank;
    }
}
