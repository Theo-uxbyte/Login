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
public class MessageTest {
    
    public MessageTest() {
    }
    
    
     // Create one test message to use in all tests
    Message testMessage = new Message(
        "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?"
    );
    
    // Test 1: Message ID is 10 characters
    @Test
    public void testCheckMessageID() {
        assertTrue(testMessage.checkMessageID(),
            "Message ID should be 10 characters.");
    }
    
    // Test 2: Recipient cell is valid
    @Test
    public void testCheckRecipientCell() {
        assertEquals("Recipient cell valid.",
            testMessage.checkRecipientCell(),
            "Recipient should start with + " +
            "and be max 10 chars.");
    }
    
    // Test 3: Message length is within 250 chars
    @Test
    public void testCheckMessageLength() {
        assertEquals("Message sent",
            testMessage.checkMessageLength(),
            "Message should be under 250 characters.");
    }
    
    // Test 4: Message hash is created correctly
    @Test
    public void testCreateMessageHash() {
        String hash = testMessage.createMessageHash();
        assertNotNull(hash, 
            "Message hash should not be null.");
        assertTrue(hash.contains(":"),
            "Hash should contain colons.");
    }
    
    // Test 5: Total messages sent is correct
    @Test
    public void testReturnTotalMessages() {
        int total = Message.returnTotalMessages();
        assertTrue(total >= 1,
            "Total messages should be at least 1.");
    }
    
    // Test 6: sentMessage returns correct output
    @Test
    public void testSentMessage() {
        assertEquals("Message successfully sent",
            testMessage.sentMessage(1),
            "Option 1 should send the message.");
        assertEquals("Press 0 to delete the message",
            testMessage.sentMessage(2),
            "Option 2 should disregard message.");
        assertEquals("Message successfully stored",
            testMessage.sentMessage(3),
            "Option 3 should store the message.");
    }
    
    // Test 7: printMessages returns all details
    @Test
    public void testPrintMessages() {
        String output = testMessage.printMessages();
        assertTrue(output.contains("Message ID"),
            "Output should contain Message ID.");
        assertTrue(output.contains("Message Hash"),
            "Output should contain Message Hash.");
        assertTrue(output.contains("+27718693002"),
            "Output should contain recipient.");
        assertTrue(output.contains("Hi Mike"),
            "Output should contain message text.");
    }
}