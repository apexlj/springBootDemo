package com.sq.platform.txj.modules.vehicleModule.dao;

import com.sq.platform.txj.modules.vehicleModule.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 14:17
 */
@Repository
public class VehicleDao {
    private Vector<Vehicle> data;

    public VehicleDao() {
        Vector<Vehicle> vehicles = new Vector<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setName("vehicle1");
        vehicle.setOwner("apexlj");
        vehicle.setTerminalId("1234567");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setName("vehicle2");
        vehicle1.setOwner("hong");
        vehicle1.setTerminalId("1234567889");

        vehicles.add(vehicle);
        vehicles.add(vehicle1);

        data = vehicles;
    }

    public List<Vehicle> selectAllVehicles() {
        System.out.println("从数据库取出车辆数据");
        return data;
    }

    public void removeVehicle(String name) {
        Iterator<Vehicle> iterator = data.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name))
                iterator.remove();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        data.add(vehicle);
    }
}
