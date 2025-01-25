package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.domain.Document;
import com.thc.fallsprbasic.domain.Makefile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakefileRepository extends JpaRepository<Makefile, Long>{
}
