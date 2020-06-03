package com.taoge.business.main.service.impl;

import com.taoge.business.main.dao.BisUserRepository;
import com.taoge.business.main.entity.BisUser;
import com.taoge.business.main.service.BisUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BisUserServiceImpl implements BisUserService{

    @Autowired
    private BisUserRepository repository;

    @Override
    public Page<BisUser> listAllBisUsers(String search,Pageable pageable) {
        Page<BisUser> page=null;
        if(StringUtils.isNotEmpty(search)){
            page= repository.findByUserAccount(search,pageable);
        }else{
            page=repository.findAll(pageable);
        }
        return page;
    }
}
