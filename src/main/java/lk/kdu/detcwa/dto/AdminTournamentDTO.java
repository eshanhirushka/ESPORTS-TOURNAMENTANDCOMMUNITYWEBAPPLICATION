package lk.kdu.detcwa.dto;

public class AdminTournamentDTO {

    private int adid;
    private int ad_tid;
    private int ad_aid;
    private String ad_join_type;

    public AdminTournamentDTO() {
    }

    public AdminTournamentDTO(int adid, int ad_tid, int ad_aid, String ad_join_type) {
        this.adid = adid;
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

    public int getAd_tid() {
        return ad_tid;
    }

    public void setAd_tid(int ad_tid) {
        this.ad_tid = ad_tid;
    }

    public int getAd_aid() {
        return ad_aid;
    }

    public void setAd_aid(int ad_aid) {
        this.ad_aid = ad_aid;
    }

    public String getAd_join_type() {
        return ad_join_type;
    }

    public void setAd_join_type(String ad_join_type) {
        this.ad_join_type = ad_join_type;
    }
}
