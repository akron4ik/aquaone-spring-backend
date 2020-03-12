package com.example.aquaone.repository.user;

import com.example.aquaone.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    int deleteUserById(int id);

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

    List<User> getUsersByAddress(String address);

    @EntityGraph(attributePaths = {"orders"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM User u WHERE u.id=?1")
    User getWithOrders(int id);


}
