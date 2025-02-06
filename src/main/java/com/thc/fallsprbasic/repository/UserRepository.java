package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.Enum.RoleType;
import com.thc.fallsprbasic.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findAllByRole(RoleType role);

    /*
       // 로그인 기능 모두 구현하고 쓸것!! 나중에 확인합시다!!
       // 최초 조회 시 조인이 같이 하기위해 쓰는 어노테이션
       // 꼭 조인할때만 쓸것!
     */
    @EntityGraph(attributePaths = {"userRoleType.roleType"})
    Optional<User> findEntityGraphRoleTypeById(Long id);
}
