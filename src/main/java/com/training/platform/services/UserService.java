package com.training.platform.services;
import com.training.platform.entities.User;
import org.springframework.data.domain.Page;
import java.util.*;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    Page<User> findAllByLimit(Integer start, Integer limit, String field);
    List<User> findByCityAndActiveAndAge(String city, Integer active,Integer age);
    List<User> findByAgeIn(List<Integer> ages);
    List<User> findAllByQuery();
    List<User> findAllByParamsQuery(Integer active, String city);
    List<User> findAllByJpqlQuery();
    List<User> findAllByJpqlParamsQuery(Integer active, String city);

    //updateHomeByAge
    List<User> updateHomeByAge(List<Integer> ages);

    //findIdByJpqlParamsQuery
    List<User> findIdByJpqlParamsQuery(Integer ids);

    //findNameInUser
    List<User> findNameInUser(String names);


}

