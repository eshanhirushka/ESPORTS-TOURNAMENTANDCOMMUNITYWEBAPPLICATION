package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {

    @Query(value = "SELECT * FROM Tournament u WHERE u.t_status = :t_status", nativeQuery = true)
    List<Tournament> findAllStatus(@Param("t_status") String t_status);

    @Modifying
    @Query(value = "update Tournament s SET s.t_status = :t_status where s.tid = :tid", nativeQuery = true)
    int updateStatusTID(@Param("t_status") String t_status, @Param("tid") int tid);

}
