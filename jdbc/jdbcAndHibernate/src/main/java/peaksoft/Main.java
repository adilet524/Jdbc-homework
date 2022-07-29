package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
         // Here we are creating new table!
//        userService.createUsersTable();

        // Here we are saving users!
//        userService.saveUser("Adilet", "Zhumakadyrov", (byte) 18);
//        userService.saveUser("Maksat", "Kyrgyzbaev", (byte) 34);
//        userService.saveUser("Kubat", "Ashymzhanov", (byte) 16);

//      Here we are getting all students!
//        userService.getAllUsers().stream().forEach(System.out::println);


        // Here we are dropping users table!
//        userService.dropUsersTable();

//         Here we are removing user by id!
//        userService.removeUserById(2);

        // Here we are truncating users!
//        userService.cleanUsersTable();
    }
}
