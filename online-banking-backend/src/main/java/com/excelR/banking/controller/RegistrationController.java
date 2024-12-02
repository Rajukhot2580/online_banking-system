
package com.excelR.banking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelR.banking.model.User;
import com.excelR.banking.serviceImpl.EmailService;
import com.excelR.banking.serviceImpl.UserServiceImpl;

//@RestController
//@RequestMapping("/banking")
//public class RegistrationController {
//
//    @Autowired
//    private UserServiceImpl userServiceImpl;
//    
//    @Autowired
//    private EmailService emailService;
//    
//    @CrossOrigin(origins = "http://localhost:3000")
//    
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user) {
//        try {
//            if (user.getEmail() == null || user.getEmail().isEmpty()) {
//                return ResponseEntity.badRequest().body("Email cannot be null or empty.");
//            }
//            userServiceImpl.registerUser(user);
//            
//            
//            // sending login details to the user via email 
//            Optional<User> optionalUser = userServiceImpl.authenticateUser(user.getEmail());
//            
//            
//            String subject = "Registration Successful";
//
//            String body = "Dear " + user.getFirstName() + ",\n\n" +
//                          "We are pleased to confirm that your registration has been successfully completed. Below are your login credentials:\n\n" +
//                          "Username: " + optionalUser.get().getId() + "\n" +
//                          "Password: " + user.getPassword() + "\n" +
//                          "Registered Email ID: " + user.getEmail() + "\n\n" +
//                          "Please keep these credentials secure and confidential. If you have any questions or require further assistance, feel free to contact our customer support team.\n\n" +
//                          "Thank you for choosing our services.\n\n" +
//                          "Best Regards,\n" +
//                          "Customer Support Team\n" +
//                          "ExcelR Bank";
//
//            emailService.sendRegistrationEmail(user.getEmail(), subject, body);
//
//            
//            return ResponseEntity.ok("Registration successful");
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getMessage();
//            return ResponseEntity.status(500).body("You Already have Account.");
//        }
//    }
//    
//    
//    @PutMapping("/updateuser/{customerId}")
//    public ResponseEntity<String> updateUser(@PathVariable Long customerId,
//                                             @RequestParam int age,
//                                             @RequestParam String email,
//                                             @RequestParam long phoneNumber,
//                                             @RequestParam String address) {
//        userServiceImpl.updateUser(customerId, age, email, phoneNumber, address);
//        return ResponseEntity.ok("User details updated successfully.");
//    }
//
//}


@RestController
@RequestMapping("/banking")
public class RegistrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            if (user.getEmail() == null || user.getEmail().isEmpty()) {
                return ResponseEntity.badRequest().body("Email cannot be null or empty.");
            }
            if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
                return ResponseEntity.badRequest().body("First name cannot be null or empty.");
            }
            
            userServiceImpl.registerUser(user);
            
            Optional<User> optionalUser = userServiceImpl.authenticateUser(user.getEmail());

            String subject = "Registration Successful";
            String body = "Dear " + user.getFirstName() + ",\n\n" +
                          "We are pleased to confirm that your registration has been successfully completed. Below are your login credentials:\n\n" +
                          "Username: " + optionalUser.get().getId() + "\n" +
                          "Password: " + user.getPassword() + "\n" +
                          "Registered Email ID: " + user.getEmail() + "\n\n" +
                          "Please keep these credentials secure and confidential. If you have any questions or require further assistance, feel free to contact our customer support team.\n\n" +
                          "Thank you for choosing our services.\n\n" +
                          "Best Regards,\n" +
                          "Customer Support Team\n" +
                          "ExcelR Bank";

            emailService.sendRegistrationEmail(user.getEmail(), subject, body);

            return ResponseEntity.ok("Registration successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
    
    @PutMapping("/updateuser/{customerId}")
    public ResponseEntity<String> updateUser(@PathVariable Long customerId,
                                             @RequestParam int age,
                                             @RequestParam String email,
                                             @RequestParam long phoneNumber,
                                             @RequestParam String address) {
        userServiceImpl.updateUser(customerId, age, email, phoneNumber, address);
        return ResponseEntity.ok("User details updated successfully.");
    }
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Controller is working");
    }

}

