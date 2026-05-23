/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginproject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
     
       
    
    Login testLogin;
    
    @BeforeEach
    public void setUp() {
        testLogin = new Login(
            "John",
            "Doe",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27123456789"
        );
    }
    
    // ===== assertEquals TESTS =====
    
    // Username correctly formatted - kyl_1
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertEquals(true, 
            testLogin.checkUserName(),
            "Welcome John, Doe it is great " +
            "to see you.");
    }
    
    // Username incorrectly formatted - kyle!!!!!!!
    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login badUser = new Login(
            "John", "Doe",
            "kyle!!!!!!!",
            "Ch&&sec@ke99!",
            "+27123456789"
        );
        assertEquals(false,
            badUser.checkUserName(),
            "Username is not correctly formatted; " +
            "please ensure that your username " +
            "contains an underscore and is no more " +
            "than five characters in length.");
    }
    
    // Password meets complexity - Ch&&sec@ke99!
    @Test
    public void testPasswordMeetsComplexity() {
        assertEquals(true,
            testLogin.checkPasswordComplexity(),
            "Password successfully captured.");
    }
    
    // Password does not meet complexity - password
    @Test
    public void testPasswordFailsComplexity() {
        Login badPass = new Login(
            "John", "Doe",
            "kyl_1",
            "password",
            "+27123456789"
        );
        assertEquals(false,
            badPass.checkPasswordComplexity(),
            "Password is not correctly formatted; " +
            "please ensure that the password " +
            "contains at least eight characters, " +
            "a capital letter, a number, and " +
            "a special character.");
    }
    
    // Cell phone correctly formatted
    @Test
    public void testCellCorrectlyFormatted() {
        assertEquals(true,
            testLogin.checkCellPhoneNumber(),
            "Cell phone number successfully added.");
    }
    
    // Cell phone incorrectly formatted - 0836300555
    @Test
    public void testCellIncorrectlyFormatted() {
        Login badCell = new Login(
            "John", "Doe",
            "kyl_1",
            "Ch&&sec@ke99!",
            "0836300555"
        );
        assertEquals(false,
            badCell.checkCellPhoneNumber(),
            "Cell number is incorrectly formatted " +
            "or does not contain an international " +
            "code; please correct the number " +
            "and try again.");
    }
    
    // ===== assertTrue/assertFalse TESTS =====
    
    // Login successful
    @Test
    public void testLoginStatusSuccess() {
        assertTrue(
            testLogin.loginUser("kyl_1", 
            "Ch&&sec@ke99!"),
            "Login should return true.");
    }
    
    // Login failed
    @Test
    public void testLoginStatusFailed() {
        assertFalse(
            testLogin.loginUser("wrong", 
            "wrongpass"),
            "Login should return false.");
    }
    
    // Username correctly formatted - assertTrue
    @Test
    public void testUsernameValid() {
        assertTrue(testLogin.checkUserName(),
            "Username should return true.");
    }
    
    // Username incorrectly formatted - assertFalse
    @Test
    public void testUsernameInvalid() {
        Login badUser = new Login(
            "John", "Doe",
            "kyle!!!!!!!",
            "Ch&&sec@ke99!",
            "+27123456789"
        );
        assertFalse(badUser.checkUserName(),
            "Username should return false.");
    }
    
    // Password meets complexity - assertTrue
    @Test
    public void testPasswordValid() {
        assertTrue(
            testLogin.checkPasswordComplexity(),
            "Password should return true.");
    }
    
    // Password fails complexity - assertFalse
    @Test
    public void testPasswordInvalid() {
        Login badPass = new Login(
            "John", "Doe",
            "kyl_1",
            "password",
            "+27123456789"
        );
        assertFalse(badPass.checkPasswordComplexity(),
            "Password should return false.");
    }
    
    // Cell correctly formatted - assertTrue
    @Test
    public void testCellValid() {
        assertTrue(
            testLogin.checkCellPhoneNumber(),
            "Cell should return true.");
    }
    
    // Cell incorrectly formatted - assertFalse
    @Test
    public void testCellInvalid() {
        Login badCell = new Login(
            "John", "Doe",
            "kyl_1",
            "Ch&&sec@ke99!",
            "0836300555"
        );
        assertFalse(badCell.checkCellPhoneNumber(),
            "Cell should return false.");
    }
}
