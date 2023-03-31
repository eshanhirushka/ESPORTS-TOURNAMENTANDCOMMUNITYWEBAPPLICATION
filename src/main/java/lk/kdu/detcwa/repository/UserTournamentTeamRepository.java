package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.UserTournament;
import lk.kdu.detcwa.entity.UserTournamentTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTournamentTeamRepository extends JpaRepository<UserTournamentTeam,Integer> {

    @Query(value = "select * from user_tournament_team where utt_ut_tid = :tid group by utt_ut_team", nativeQuery = true)
    List<UserTournamentTeam> getCountAndTeam(@Param("tid") int tid);

    @Query(value = "SELECT * FROM user_tournament_team u WHERE u.utt_utid = :utt_utid and u.utt_ut_uid = :utt_ut_uid and u.utt_ut_tid = :utt_ut_tid and u.utt_ut_team = :utt_ut_team", nativeQuery = true)
    UserTournamentTeam findRegData(@Param("utt_utid") int utt_utid,
                               @Param("utt_ut_uid") int utt_ut_uid,
                               @Param("utt_ut_tid") int utt_ut_tid,
                               @Param("utt_ut_team") String utt_ut_team);

    @Query(value = "SELECT * FROM user_tournament_team u WHERE u.utt_ut_tid = :tid and u.utt_ut_team = :team", nativeQuery = true)
    List<UserTournamentTeam> findTeamNameANDTeamID(@Param("tid") int tid,@Param("team") String team);

}
