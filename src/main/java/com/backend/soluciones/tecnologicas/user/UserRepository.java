package com.backend.soluciones.tecnologicas.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
//    Optional<User> findByUsernameAndPasswordAndEnterprise(String username, String password, String enterprise);
    @Query(value = "SELECT * FROM users u WHERE u.enterprise = :enterprise AND u.username = :username", nativeQuery = true)
    List<Object[]> doLogin(@Param("enterprise") String enterprise,@Param("username")String username);
}
