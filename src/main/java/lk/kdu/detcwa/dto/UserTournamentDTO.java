package lk.kdu.detcwa.dto;

public class UserTournamentDTO {

    private int utid;
    private int ut_uid;
    private int ut_tid;
    private String ut_join_type;
    private String ut_team;
    private String ut_role;
    private String ut_rank;
    private String ut_u_name;
    private String ut_u_role;
    private String ut_u_rank;

    public UserTournamentDTO() {
    }

    public UserTournamentDTO(int utid, int ut_uid, int ut_tid, String ut_join_type, String ut_team, String ut_role, String ut_rank) {
        this.utid = utid;
        this.ut_uid = ut_uid;
        this.ut_tid = ut_tid;
        this.ut_join_type = ut_join_type;
        this.ut_team = ut_team;
        this.ut_role = ut_role;
        this.ut_rank = ut_rank;
    }

    public UserTournamentDTO(int utid, int ut_uid, int ut_tid, String ut_join_type, String ut_team, String ut_role, String ut_rank, String ut_u_name, String ut_u_role, String ut_u_rank) {
        this.utid = utid;
        this.ut_uid = ut_uid;
        this.ut_tid = ut_tid;
        this.ut_join_type = ut_join_type;
        this.ut_team = ut_team;
        this.ut_role = ut_role;
        this.ut_rank = ut_rank;
        this.ut_u_name = ut_u_name;
        this.ut_u_role = ut_u_role;
        this.ut_u_rank = ut_u_rank;
    }

    public String getUt_u_name() {
        return ut_u_name;
    }

    public void setUt_u_name(String ut_u_name) {
        this.ut_u_name = ut_u_name;
    }

    public String getUt_u_role() {
        return ut_u_role;
    }

    public void setUt_u_role(String ut_u_role) {
        this.ut_u_role = ut_u_role;
    }

    public String getUt_u_rank() {
        return ut_u_rank;
    }

    public void setUt_u_rank(String ut_u_rank) {
        this.ut_u_rank = ut_u_rank;
    }

    public int getUtid() {
        return utid;
    }

    public void setUtid(int utid) {
        this.utid = utid;
    }

    public int getUt_uid() {
        return ut_uid;
    }

    public void setUt_uid(int ut_uid) {
        this.ut_uid = ut_uid;
    }

    public int getUt_tid() {
        return ut_tid;
    }

    public void setUt_tid(int ut_tid) {
        this.ut_tid = ut_tid;
    }

    public String getUt_join_type() {
        return ut_join_type;
    }

    public void setUt_join_type(String ut_join_type) {
        this.ut_join_type = ut_join_type;
    }

    public String getUt_team() {
        return ut_team;
    }

    public void setUt_team(String ut_team) {
        this.ut_team = ut_team;
    }

    public String getUt_role() {
        return ut_role;
    }

    public void setUt_role(String ut_role) {
        this.ut_role = ut_role;
    }

    public String getUt_rank() {
        return ut_rank;
    }

    public void setUt_rank(String ut_rank) {
        this.ut_rank = ut_rank;
    }
}
