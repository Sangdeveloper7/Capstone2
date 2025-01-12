package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.domain.Post;
import com.thc.fallsprbasic.domain.Tbpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbpaperRepository extends JpaRepository<Tbpaper, Long>{
}
