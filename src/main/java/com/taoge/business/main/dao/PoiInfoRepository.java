package com.taoge.business.main.dao;

import com.taoge.business.main.entity.PoiInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiInfoRepository extends JpaRepository<PoiInfo,String> {

}
