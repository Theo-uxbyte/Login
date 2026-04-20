/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import java.util.Scanner;
class Login {
   String firstName;
    String lastName;
    String username;
    String password;
    String cellPhone;

    public Login(String firstName, String lastName, String username, String password, String cellPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        
    }

    public boolean checkUserName() {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }
        if(!password.matches(".*[A-Z].*")){//At least one uppercase 
            return false;
        }
        if(!password.matches(".*[a-z].*")){//at least one lowercase
    return false;
          
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if(!password.matches(".*[!@#$%^&*].*")) {
            return false;
        }
        return true;
    }

    public boolean checkCellPhoneNumber() {
        if (cellPhone.startsWith("+") && cellPhone.length() <= 12) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
} 
    

