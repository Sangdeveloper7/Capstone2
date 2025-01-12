package com.thc.fallsprbasic.repository;


import com.thc.fallsprbasic.domain.Tbpapertype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbpapertypeRepository extends JpaRepository<Tbpapertype, Long>{
}
