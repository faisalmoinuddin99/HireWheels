package com.upgrad.hirewheels;
import com.upgrad.hirewheels.dao.RoleDao;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Booking;

import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.*;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import java.util.List;
import static jdk.nashorn.internal.objects.NativeArray.forEach;
import static jdk.nashorn.internal.objects.NativeArray.push;


@SpringBootApplication
public class HireWheelsApplication {

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(HireWheelsApplication.class, args);
        UsersDao usersDao = context.getBean(UsersDao.class);
        RoleDao roleDao = context.getBean(RoleDao.class);
        UserService userService = context.getBean(UserService.class);
        BookingService bookingService =context.getBean(BookingService.class);
        VehicleService vehicleService =context.getBean(VehicleService.class);

        InitService initService = context.getBean(InitService.class);
        initService.start();

        AdminService adminService = context.getBean(AdminService.class);
        Vehicle vehicle = new Vehicle();
        adminService.registerVehicle(vehicle);
        adminService.changeAvailability(1);

        Users users = new Users();
        Booking booking = new Booking();
        if(users.getWalletMoney()>booking.getAmount()){
            booking.setBookingId(10);
            booking = bookingService.addBooking(booking);
        }else{
            try {
                throw new Exception("Insufficient Balance. Please Check With Admin. ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Users users1 = new Users();
        Vehicle vehicle1 = new Vehicle();
        //	vehicle1.setVehicleId(users1.getUserId());
        users1.setUserId(10);
        vehicle1.setVehicleId(users1.getUserId());
        vehicle1 = (Vehicle) vehicleService.getVehicleByUserID();

//        Role admin =new Role();
//        admin.setRoleName("ADMIN");
//
//        Role user = new Role();
//        user.setRoleName("USER");
//
//        Users users1 = new Users();
//        users1.setFirstName("Faisal");
//        users1.setLastName("Suleman");
//        users1.setPassword("12345");
//        users1.setEmail("faisal25march99@gmail.com");
//        users1.setMobileNo("8790792928");
//        users1.setWalletMoney(500);
//        users1.setRole("ADMIN");
//        users1 = usersDao.save(users1);
//
//        Users users2 = new Users();
//        users2.setFirstName("Deepika");
//        users2.setLastName("kumari");
//        users2.setPassword("10245");
//        users2.setEmail("exampple@gmail.com");
//        users2.setMobileNo("123456116");
//        users2.setWalletMoney(400);
//        users2.setRole("USER");
//        users2 = usersDao.save(users2);
//
//
//        Users users3 = new Users();
//        users3.setFirstName("Alex");
//        users3.setLastName("Smith");
//        users3.setPassword("7894515121");
//        users3.setEmail("upgrad@outlook.com");
//        users3.setMobileNo("2761021649");
//        users3.setWalletMoney(50000);
//        users3.setRole("USER");
//        users3 = usersDao.save(users3);
//
//        Users users4 = new Users();
//        users4.setFirstName("Danilo");
//        users4.setLastName("Lima");
//        users4.setPassword("12345");
//        users4.setEmail("Danilolima@outlook.com");
//        users4.setMobileNo("41234544646");
//        users4.setWalletMoney(20000);
//        users4.setRole("USER");
//        users4 = usersDao.save(users4);
//
//        Users users5 = new Users();
//        users5.setFirstName("Michael");
//        users5.setLastName("Thomas");
//        users5.setPassword("abcde");
//        users5.setEmail("MichaelThomas@gamil.com");
//        users5.setMobileNo("21345464679");
//        users5.setWalletMoney(1000);
//        users3.setRole("USER");
//        users5 = usersDao.save(users5);
//
//        //UsersDao.saveAll(List.of(users1, users2, users3, users4, users5));
//
//        System.out.println("*************find By First Name*************");
//        usersDao.findByFirstName("Faisal")
//                .forEach(users -> System.out.println(users.getFirstName()));
//
//        System.out.println("*************find By First Name Or Last Name*************");
//        usersDao.findByFirstNameOrLastName("Faisal","Suleman")
//                .forEach(users -> System.out.println(users.getFirstName()));
//
//        System.out.println("*************find By Email*************");
//        usersDao.findByEmail("faisal25march99@gmail.com")
//                .forEach(users -> System.out.println(users.getEmail()));
//
//        System.out.println("*************find By Mobile Number*************");
//        usersDao.findByEmail("8790792928")
//                .forEach(users -> System.out.println(users.getMobileNo()));
//
//        System.out.println("**************Roles***********");
//        roleDao.findAll().forEach(System.out::println);
//
//        System.out.println("**************Users***********");
//        usersDao.findAll().forEach(System.out::println);
//
//        System.out.println("**************Admin Role***********");
//        roleDao.findById(admin.getRoleId())
//                .ifPresent(role -> role.getRoleName());
    }

}