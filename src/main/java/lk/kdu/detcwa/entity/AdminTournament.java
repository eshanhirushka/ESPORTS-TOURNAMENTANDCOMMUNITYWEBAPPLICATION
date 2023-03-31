package lk.kdu.detcwa.entity;

import javax.persistence.*;

@Entity
public class AdminTournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adid;
    @ManyToOne
    @JoinColumn(name="tid", nullable=true)
    private Tournament ad_tid;
    @ManyToOne
    @JoinColumn(name="aid", nullable=true)
    private Admin ad_aid;
    private String ad_join_type;

    public AdminTournament() {
    }

    public AdminTournament(Tournament ad_tid, Admin ad_aid, String ad_join_type) {
        this.ad_tid = ad_tid;
        this.ad_aid = ad_aid;
        this.ad_join_type = ad_join_type;
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public Tournament getAd_tid() {
        return ad_tid;
    }

    public void setAd_tid(Tournament ad_tid) {
        this.ad_tid = ad_tid;
    }

    public Admin getAd_aid() {
        return ad_aid;
    }

    public void setAd_aid(Admin ad_aid) {
        this.ad_aid = ad_aid;
    }

    public String getAd_join_type() {
        return ad_join_type;
    }

    public void setAd_join_type(String ad_join_type) {
        this.ad_join_type = ad_join_type;
    }
}
