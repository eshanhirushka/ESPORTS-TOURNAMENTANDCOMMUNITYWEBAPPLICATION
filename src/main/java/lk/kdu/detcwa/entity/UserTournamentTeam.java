package lk.kdu.detcwa.entity;

import javax.persistence.*;

@Entity
public class UserTournamentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uttid;
    @ManyToOne
    @JoinColumn(name="utt_utid", nullable=true)
    private UserTournament utt_utid;
    @ManyToOne
    @JoinColumn(name="utt_ut_uid", nullable=true)
    private User utt_ut_uid;
    @ManyToOne
    @JoinColumn(name="utt_ut_tid", nullable=true)
    private Tournament utt_ut_tid;
    private String utt_ut_join_type;
    private String utt_ut_team;
    private String utt_ut_role;
    private String utt_ut_rank;
    private String utt_ut_u_name;
    private String utt_ut_u_role;
    private String utt_ut_u_rank;

    public UserTournamentTeam() {
    }

    public UserTournamentTeam(UserTournament utt_utid, User utt_ut_uid, Tournament utt_ut_tid, String utt_ut_join_type, String utt_ut_team, String utt_ut_role, String utt_ut_rank, String utt_ut_u_name, String utt_ut_u_role, String utt_ut_u_rank) {
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

    public UserTournament getUtt_utid() {
        return utt_utid;
    }

    public void setUtt_utid(UserTournament utt_utid) {
        this.utt_utid = utt_utid;
    }

    public User getUtt_ut_uid() {
        return utt_ut_uid;
    }

    public void setUtt_ut_uid(User utt_ut_uid) {
        this.utt_ut_uid = utt_ut_uid;
    }

    public Tournament getUtt_ut_tid() {
        return utt_ut_tid;
    }

    public void setUtt_ut_tid(Tournament utt_ut_tid) {
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
