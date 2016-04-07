package com.sq.platform.txj.modules.vehicleModule.service;

import com.sq.platform.txj.modules.vehicleModule.dao.VehicleDao;
import com.sq.platform.txj.modules.vehicleModule.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 14:17
 */
@Component
@CacheConfig
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    // 全部车辆的数据放在缓存：allVehicles
    @Cacheable(cacheNames = "allVehicles", key = "#root.methodName")
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.selectAllVehicles();
    }

    // 增加车辆数据时，把新增的数据加入缓存vehicle，同时清空全部车辆数据所在的缓存allVehicles
    @Caching(put = {@CachePut(cacheNames = "vehicle", key = "#vehicle.name")},
            evict = {@CacheEvict(cacheNames = "allVehicles", allEntries = true)})
    public void addVehicle(Vehicle vehicle) {
        vehicleDao.addVehicle(vehicle);
    }

    // 删除单辆车数据时要删除vehicle对应数据并清空全部车辆数据所在的缓存allVehicles
    @Caching(evict = {@CacheEvict(cacheNames = "vehicle", key = "#name"),
    @CacheEvict(cacheNames = "allVehicles", allEntries = true)})
    public void removeVehicle(String name) {
        vehicleDao.removeVehicle(name);
    }
}
