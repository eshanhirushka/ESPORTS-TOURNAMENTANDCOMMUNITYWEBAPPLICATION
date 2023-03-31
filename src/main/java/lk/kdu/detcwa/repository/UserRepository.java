package lk.kdu.detcwa.repository;

import lk.kdu.detcwa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM User u WHERE u.u_u_name = :username", nativeQuery = true)
    User findUName(@Param("username") String username);

}
