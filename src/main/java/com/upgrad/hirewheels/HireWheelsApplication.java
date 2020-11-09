package com.upgrad.hirewheels;


import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import org.junit.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

@SpringBootApplication
public class HireWheelsApplication {

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(HireWheelsApplication.class, args);
        UsersDao usersDao = context.getBean(UsersDao.class);

        Users users1 = new Users();
        users1.setFirstName("Yashwanth");
        users1.setLastName("Samala");
        users1.setPassword("12345");
        users1.setEmail("samalayashwanth.95@outlook.com");
        users1.setMobileNo("8790792928");
        users1.setWalletMoney(500);
        users1.setRole(users1.getRole());
        users1 = UsersDao.save(users1);

        Users users2 = new Users();
        users2.setFirstName("Deepika");
        users2.setLastName("kumari");
        users2.setPassword("10245");
        users2.setEmail("exampple@gmail.com");
        users2.setMobileNo("123456116");
        users2.setWalletMoney(400);
        users2.setRole(users2.getRole());
        users2 = UsersDao.save(users2);

        Users users3 = new Users();
        users3.setFirstName("Alex");
        users3.setLastName("Smith");
        users3.setPassword("7894515121");
        users3.setEmail("upgrad@outlook.com");
        users3.setMobileNo("2761021649");
        users3.setWalletMoney(50000);
        users3.setRole(users3.getRole());
        users3 = UsersDao.save(users3);

        Users users4 = new Users();
        users4.setFirstName("Danilo");
        users4.setLastName("Lima");
        users4.setPassword("12345");
        users4.setEmail("Danilolima@outlook.com");
        users4.setMobileNo("41234544646");
        users4.setWalletMoney(20000);
        users4.setRole(users4.getRole());
        users4 = UsersDao.save(users4);

        Users users5 = new Users();
        users5.setFirstName("Michael");
        users5.setLastName("Thomas");
        users5.setPassword("abcde");
        users5.setEmail("MichaelThomas@gamil.com");
        users5.setMobileNo("21345464679");
        users5.setWalletMoney(1000);
        users3.setRole(users5.getRole());
        users5 = UsersDao.save(users5);

        UsersDao.saveAll(List.of(users1, users2, users3, users4, users5));

        System.out.println("*************find By First Name*************");
        usersDao.findByFirstName("Yashwanth")
                .forEach(users -> System.out.println(users.getFirstName()));

        System.out.println("*************find By First Name Or Last Name*************");
        usersDao.findByFirstNameOrLastName("Yashwanth","Samala")
                .forEach(users -> System.out.println(users.getFirstName()));

        System.out.println("*************find By Email*************");
        usersDao.findByEmail("samalayashwanth.95@outlook.com")
                .forEach(users -> System.out.println(users.getEmail()));

        System.out.println("*************find By Mobile Number*************");
        usersDao.findByEmail("8790792928")
                .forEach(users -> System.out.println(users.getMobileNo()));
    }

}