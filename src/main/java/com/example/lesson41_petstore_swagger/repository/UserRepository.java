package com.example.lesson41_petstore_swagger.repository;

import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    //Кастомные запрросы на JPQL
//    @Query(value = "from User")
//    List<User> myFindAll(); //JPQL - язык запроса JPA
//
//    @Query(value = "from User where username:= username")//именованный параметр
//    List<User> myFindByUsername(String username);
//    //List<User> myFindByUsername(@Param("username") String name);//если разные имена
//
//    //Нативные запросы
//    @Query(value = "SELECT * FROM User WHERE id = ?1", nativeQuery = true)
//    Optional<User> findByIdNativeQuery(long id);
}
