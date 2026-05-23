/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginproject;

/**
 *
 * @author Student
 *
 * */
public class Login {

    String firstName;
    String lastName;
    String username;
    String password;
    String cellPhone;

    public Login(String fn, String ln, String un, String pw, String cp) {
        firstName = fn;
        lastName = ln;
        username = un;
        password = pw;
        cellPhone = cp;
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
        if (password.equals(password.toLowerCase())) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[!@#$%^&].*")) {
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
    

    

