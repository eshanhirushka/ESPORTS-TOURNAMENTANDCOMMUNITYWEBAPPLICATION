package lk.kdu.detcwa.entity;

import javax.persistence.*;

@Entity
public class UserTournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int utid;
    @ManyToOne
    @JoinColumn(name="uid", nullable=true)
    private User ut_uid;
    @ManyToOne
    @JoinColumn(name="tid", nullable=true)
    private Tournament ut_tid;
    private String ut_join_type;
    private String ut_team;
    private String ut_role;
    private String ut_rank;

    public UserTournament() {
    }

    public UserTournament(User ut_uid, Tournament ut_tid, String ut_join_type, String ut_team, String ut_role, String ut_rank) {
        this.ut_uid = ut_uid;
        this.ut_tid = ut_tid;
        this.ut_join_type = ut_join_type;
        this.ut_team = ut_team;
        this.ut_role = ut_role;
        this.ut_rank = ut_rank;
    }

    public int getUtid() {
        return utid;
    }

    public void setUtid(int utid) {
        this.utid = utid;
    }

    public User getUt_uid() {
        return ut_uid;
    }

    public void setUt_uid(User ut_uid) {
        this.ut_uid = ut_uid;
    }

    public Tournament getUt_tid() {
        return ut_tid;
    }

    public void setUt_tid(Tournament ut_tid) {
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
