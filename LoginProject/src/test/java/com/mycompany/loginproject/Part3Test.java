/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginproject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author Student
 */
public class Part3Test {
    
    @BeforeEach
                public void setUp(){
        Project3.sentMessages.clear();
        Project3.storedMessages.clear();
        Project3.disregardedMessages.clear();
        Project3.messageHashes.clear();
        Project3.messageIDs.clear();

        // Message 1 - SENT
        Message msg1 = new Message(
            "+27834557896",
            "Did you get the cake?");
        Project3.sentMessages.add(msg1);
        Project3.messageHashes.add(
            msg1.createMessageHash());
        Project3.messageIDs.add(
            msg1.getMessageID());

        // Message 2 - STORED
        Message msg2 = new Message(
            "+27838884567",
            "Where are you? You are late! " +
            "I have asked you to be on time.");
       Project3.storedMessages.add(msg2);
       Project3.messageHashes.add(
            msg2.createMessageHash());
       Project3.messageIDs.add(
            msg2.getMessageID());

        // Message 3 - DISREGARD
        Message msg3 = new Message(
            "+27834484567",
            "Yohoooo, I am at your gate.");
        Project3.disregardedMessages.add(msg3);

        // Message 4 - SENT
        Message msg4 = new Message(
            "0838884567",
            "It is dinner time!");
        Project3.sentMessages.add(msg4);
        Project3.messageHashes.add(
            msg4.createMessageHash());
        Project3.messageIDs.add(
            msg4.getMessageID());

        // Message 5 - STORED
        Message msg5 = new Message(
            "+27838884567",
            "Ok, I am leaving without you.");
        Project3.storedMessages.add(msg5);
        Project3.messageHashes.add(
            msg5.createMessageHash());
        Project3.messageIDs.add(
            msg5.getMessageID());
    }

    // Test 1: Sent messages correctly populated
    @Test
    public void testSentMessagesPopulated() {
        assertEquals(2,
            Project3.sentMessages.size());
        assertEquals("Did you get the cake?",
            Project3.sentMessages.get(0)
            .getMessageText());
        assertEquals("It is dinner time!",
            Project3.sentMessages.get(1)
            .getMessageText());
    }

    // Test 2: Longest message
    @Test
    public void testLongestMessage() {
        assertEquals(
            "Where are you? You are late! " +
            "I have asked you to be on time.",
            Project3.getLongestMessage());
    }

    // Test 3: Search by recipient
    @Test
    public void testSearchByRecipient() {
        String result =
            Project3.searchByRecipient(
            "+27838884567");
        assertTrue(result.contains(
            "Where are you? You are late!"));
        assertTrue(result.contains(
            "Ok, I am leaving without you."));
    }

    // Test 4: Delete by hash
    @Test
    public void testDeleteByHash() {
        String hash = Project3.storedMessages
            .get(0).createMessageHash();
        String result =
            Project3.deleteByHash(hash);
        assertTrue(result.contains(
            "successfully deleted"));
    }

    // Test 5: Display report
    @Test
    public void testDisplayReport() {
        String report =
            Project3.displayReport();
        assertTrue(report.contains(
            "MESSAGE REPORT"));
        assertTrue(report.contains(
            "Did you get the cake?"));
    }

    // Test 6: Search by message ID
    @Test
     public void testSearchByID() {
        String id = Project3.sentMessages
            .get(1).getMessageID();
        String result =
            Project3.searchByID(id);
        assertTrue(result.contains(
            "It is dinner time!"));
    }
}

        
        
    
    
    
    