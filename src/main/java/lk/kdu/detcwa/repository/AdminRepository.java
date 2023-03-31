package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    @Query(value = "SELECT * FROM Admin u WHERE u.a_u_name = :username", nativeQuery = true)
    Admin findUName(@Param("username") String username);


}
