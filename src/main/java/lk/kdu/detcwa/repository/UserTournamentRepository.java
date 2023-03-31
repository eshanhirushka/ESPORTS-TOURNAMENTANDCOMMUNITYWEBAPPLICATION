package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.UserTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTournamentRepository extends JpaRepository<UserTournament,Integer> {

    @Query(value = "SELECT * FROM user_tournament u WHERE u.uid = :uid", nativeQuery = true)
    List<UserTournament> findAllUT(@Param("uid") int uid);

    @Query(value = "SELECT count(*) FROM user_tournament u WHERE u.uid = :uid and u.tid = :tid", nativeQuery = true)
    int findUserJoinTournament(@Param("tid") int tid,@Param("uid") int uid);


    @Query(value = "SELECT * FROM user_tournament u WHERE u.tid = :tid", nativeQuery = true)
    List<UserTournament> findTouramentID(@Param("tid") int tid);

}
