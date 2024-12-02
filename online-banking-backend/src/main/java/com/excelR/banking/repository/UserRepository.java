//
//package com.excelR.banking.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.excelR.banking.model.User;
//
//import jakarta.transaction.Transactional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//	Optional<User> getByEmail(String email);
//	Optional<User> getById(long customerId);
//
//	@Modifying
//    @Transactional
//    @Query("UPDATE User u SET u.age = :age, u.email = :email, u.phoneNumber = :phoneNumber, u.address = :address WHERE u.id = :customerId")
//    int updateUserDetails(@Param("age") int age,
//                          @Param("email") String email,
//                          @Param("phoneNumber") long phoneNumber,
//                          @Param("address") String address,
//                          @Param("customerId") Long customerId);
//
//}

package com.excelR.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.excelR.banking.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByEmail(String email);
    Optional<User> getById(long customerId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.age = :age, u.email = :email, u.phoneNumber = :phoneNumber, u.address = :address WHERE u.id = :customerId")
    int updateUserDetails(@Param("age") int age,
                          @Param("email") String email,
                          @Param("phoneNumber") long phoneNumber,
                          @Param("address") String address,
                          @Param("customerId") Long customerId);

}