package com.taoge.business.main.service;

import com.taoge.business.main.entity.PoiInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoiInfoService {

    Page<PoiInfo> queryPoiInfo( Pageable pageable);

}
