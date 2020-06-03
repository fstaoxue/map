package com.taoge.business.main.dao;

import com.taoge.business.main.entity.BisUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BisUserRepository extends JpaRepository<BisUser,Integer> {

    Page<BisUser> findByUserAccount(String account, Pageable pageable);
}
