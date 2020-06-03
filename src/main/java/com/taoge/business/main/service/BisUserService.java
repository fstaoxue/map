package com.taoge.business.main.service;

import com.taoge.business.main.entity.BisUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BisUserService {

    Page<BisUser> listAllBisUsers(String search, Pageable pageable);

}
