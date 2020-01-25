package app.mtab.repositiories;

import app.mtab.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    User findById(Long id);

    Optional<User> findByName(String name);
}
