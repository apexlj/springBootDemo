package com.sq.platform.txj.modules.vehicleModule.controller;

import com.sq.platform.txj.common.model.ServiceResponse;
import com.sq.platform.txj.modules.vehicleModule.model.Vehicle;
import com.sq.platform.txj.modules.vehicleModule.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 14:20
 */
@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/allVehicles")
    public ModelAndView vehicles() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("response", ServiceResponse.ok(vehicleService.getAllVehicles()).build());
        modelAndView.setViewName("vehicle/vehicles");
        return modelAndView;
    }

    @RequestMapping("/addVehicle")
    public String addVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setTerminalId("23452342");
        vehicle.setOwner("apexlj");
        vehicle.setName(String.valueOf(System.currentTimeMillis()));
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicle/allVehicles";
    }


    @RequestMapping("/removeVehicle/{name}")
    public String removeVehicle(@PathVariable String name) {
        vehicleService.removeVehicle(name);
        return "redirect:/vehicle/allVehicles";
    }
}
