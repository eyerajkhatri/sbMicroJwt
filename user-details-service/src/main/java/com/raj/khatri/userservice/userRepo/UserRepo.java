package com.raj.khatri.userservice.userRepo;


import com.raj.khatri.userservice.currentUserDTO.CurrentUserDTO;
import com.raj.khatri.userservice.queryConstants.QueryConstants;
import com.raj.khatri.userservice.userDTO.UserWrapper;
import com.raj.khatri.userservice.userLoginDTO.UserLoginDTO;
import com.raj.khatri.userservice.userEntity.User;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    @Query(QueryConstants.verifyUserCredentials)
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    UserLoginDTO verifyUserCredentials(String userName);

    @Query(QueryConstants.checkUserExists)
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    CurrentUserDTO checkUserExists(String userName, String email);

    @Query(QueryConstants.findUserByUserName)
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    UserWrapper findUserByUserName(String username);

}
