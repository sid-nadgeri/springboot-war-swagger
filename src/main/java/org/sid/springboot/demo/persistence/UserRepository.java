package org.sid.springboot.demo.persistence;


import org.sid.springboot.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(@PathVariable String username);

}
