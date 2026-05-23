/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginproject;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Message {
    



    String messageID;
    String recipient;
    String messageText;
    String messageHash;
    int messageNumber;

   
   
    private static int numMessagesSent = 0;
    
    public Message(String recipient, String messageText) {
        this.recipient = recipient;
        this.messageText = messageText;
        numMessagesSent++;
        this.messageID = generateMessageID();
    }
    
    // Generate random 10 digit ID
    private String generateMessageID() {
        return String.valueOf((long)(Math.random() * 
               9000000000L) + 1000000000L);
    }
    
    // Check message ID not more than 10 characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }
    
    // Check recipient cell - max 10 chars, starts with +
    public String checkRecipientCell() {
        if (recipient.length() <= 12 && 
            recipient.startsWith("+")) {
            return "Recipient cell valid.";
        } else {
            return "Invalid recipient cell number.";
        }
    }
    
    // Check message max 250 characters
    public String checkMessageLength() {
        if (messageText.length() > 250) {
            return "Please enter a message of " +
                   "less than 250 characters.";
        } else {
            return "Message sent";
        }
    }
    
    // Create hash: first 2 of ID + : + msgNum + : 
    //              + firstWord + lastWord in CAPS
    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return (messageID.substring(0, 2) + ":" + 
                numMessagesSent + ":" + 
                firstWord + lastWord).toUpperCase();
    }
    
    // Send, store or disregard message
    public String sentMessage(int choice) {
        switch (choice) {
            case 1:
                return "Message successfully sent";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message successfully stored";
            default:
                return "Invalid option";
        }
    }
    
    // Print full message details
    public String printMessages() {
        return "Message ID: " + messageID +
               "\nMessage Hash: " + createMessageHash() +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }
    
    // Return total messages sent
    public static int returnTotalMessages() {
        return numMessagesSent;
    }
    
    // Getters
    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
}