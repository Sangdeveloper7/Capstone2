package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.domain.Dkeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DkeywordRepository extends JpaRepository<Dkeyword, Long>{
}
