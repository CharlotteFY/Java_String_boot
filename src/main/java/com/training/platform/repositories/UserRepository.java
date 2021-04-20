package com.training.platform.repositories;

import com.training.platform.entities.User;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import javax.persistence.PreUpdate;
import java.util.*;

public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age);
    public List<User> findByAgeIn(List<Integer> ages);

    @Query(value = "SELECT * FROM users u WHERE u.active = 1 and u.city = 'Bangkok' ",
            nativeQuery = true)
    public List<User> findAllByQuery();

    @Query(value = "SELECT * FROM users u WHERE u.active = ?1 and u.city = ?2 ",
            nativeQuery = true)
    public List<User> findAllByParamsQuery(Integer active,  String city);

    @Query("SELECT u FROM User u WHERE u.active = 1 and u.city = 'Bangkok' ")
    public List<User> findAllByJpqlQuery();

    @Query("SELECT u FROM User u WHERE u.active = ?1 and u.city = ?2 ")
    public List<User> findAllByJpqlParamsQuery(Integer active, String city);

    //updateHomeByAge
    @Query("update User set city = Homeless where age in ?1")
    public List<User> updateHomeByAge(List<Integer> ages);

    //find id
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    public List<User> findIdByJpqlParamsQuery(Integer ids);

    //find name
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    public List<User> findNameInUser(String name);



}
