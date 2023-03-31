package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.AdminTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminTournamentRepository extends JpaRepository<AdminTournament,Integer> {

    @Query(value = "SELECT * FROM Tournament u left join admin_tournament a on u.tid = a.tid WHERE u.t_status = :t_status", nativeQuery = true)
    List<AdminTournament> findAllJoinAT(@Param("t_status") String t_status);

    @Query(value = "SELECT * FROM admin_tournament u WHERE u.aid = :aid", nativeQuery = true)
    List<AdminTournament> findAllAT(@Param("aid") int aid);

    @Query(value = "SELECT count(*) FROM admin_tournament u WHERE u.aid = :aid and u.tid = :tid", nativeQuery = true)
    int findUserJoinTournament(@Param("tid") int tid,@Param("aid") int aid);

}
