package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByName(String name);

    @Modifying
    @Query(value = "update user_data u set name=COALESCE(CAST(:name AS TEXT),u.name), " +
            "last_name=COALESCE(CAST(:lastName AS TEXT),u.last_name), mobile=COALESCE(CAST(:mobile AS TEXT),u.mobile) " +
            "where id=:id",
           nativeQuery = true)
    void updateUser(@Param("id") String id, @Param("name") String name,
                    @Param("lastName") String lastName, @Param("mobile") String mobile);
}
