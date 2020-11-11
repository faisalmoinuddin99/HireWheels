package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;

public class AdminServiceImpl implements AdminService{


    @Autowired
    public VehicleDao vehicleDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle)throws VehicleNotFoundException {

        return vehicle;
    }

    @Override
    public boolean changeAvailability(int availabilityStaus) {
        if(availabilityStaus==1){
            return true;
        }else {
            return false;
        }

    }
}