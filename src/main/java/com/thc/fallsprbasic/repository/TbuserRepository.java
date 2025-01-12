package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.domain.Tbuser;
import com.thc.fallsprbasic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbuserRepository extends JpaRepository<Tbuser, Long>{
    Tbuser findByUsername(String username);
    Tbuser findByUsernameAndPassword(String username, String password);
}
