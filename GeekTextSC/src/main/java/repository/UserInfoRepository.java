package repository;

import model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersInfoRepository extends JpaRepository<User, Integer>
{
    List<Users> findByuserName(String userName);
}
