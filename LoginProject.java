/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginproject;

/**
 *
 * @author Student
 */


import java.util.Scanner;
public class LoginProject {
    

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("--- REGISTRATION ---");
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter a username: ");
        String username = input.nextLine();

        System.out.println("Enter a password: ");
        String password = input.nextLine();

        System.out.println("Enter your cell phone number e.g +27838968976: ");
        String cellPhone = input.nextLine();

        Login login = new Login(firstName, lastName, username, password, cellPhone);

        if (login.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (login.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (login.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        System.out.println("--- LOGIN ---");
        System.out.println("Enter your username to log in: ");
        String enteredUsername = input.nextLine();

        System.out.println("Enter your password to log in: ");
        String enteredPassword = input.nextLine();

        System.out.println(login.returnLoginStatus(enteredUsername, enteredPassword));

        input.close();
                        
                        
                    }
                }
       
    

