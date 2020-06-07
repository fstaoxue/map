package com.taoge.business.main.service.impl;

import com.taoge.business.main.dao.PoiInfoRepository;
import com.taoge.business.main.entity.PoiInfo;
import com.taoge.business.main.service.PoiInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PoiInfoServiceImpl implements PoiInfoService {

    @Autowired
    private PoiInfoRepository repository;

    @Override
    public Page<PoiInfo> queryPoiInfo(Pageable pageable) {
        Page<PoiInfo> page=null;
        page= repository.findAll(pageable);
        return page;
    }
}
