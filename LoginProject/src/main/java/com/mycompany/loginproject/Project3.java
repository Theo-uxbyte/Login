/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginproject;

/**
 *
 * @author Student
 */


import java.util.ArrayList;
import java.util.Scanner;
public class Project3 {
    
    




    // Arrays defined here in Part3
    public static ArrayList<Message> sentMessages =
                                    new ArrayList<>();
    public static ArrayList<Message> disregardedMessages =
                                    new ArrayList<>();
    public static ArrayList<Message> storedMessages =
                                    new ArrayList<>();
    public static ArrayList<String> messageHashes =
                                    new ArrayList<>();
    public static ArrayList<String> messageIDs =
                                    new ArrayList<>();

    // Add message to correct array
    public static void addMessage(Message msg,
                                  int choice) {
        String hash = msg.createMessageHash();
        String id = msg.getMessageID();

        switch (choice) {
            case 1:
                sentMessages.add(msg);
                messageHashes.add(hash);
                messageIDs.add(id);
                System.out.println(
                    "Message successfully sent");
                System.out.println(
                    msg.printMessages());
                break;
            case 2:
                disregardedMessages.add(msg);
                System.out.println(
                    "Press 0 to delete " +
                    "the message");
                break;
            case 3:
                storedMessages.add(msg);
                messageHashes.add(hash);
                messageIDs.add(id);
                System.out.println(
                    "Message successfully stored");
                break;
            default:
                System.out.println(
                    "Invalid option.");
        }
    }

    // Stored Messages Menu
    public static void storedMessagesMenu(
                       Scanner input) {
        int choice = 0;
        do {
            System.out.println(
                "\n--- STORED MESSAGES MENU ---");
            System.out.println(
                "1. Display all stored messages");
            System.out.println(
                "2. Display longest message");
            System.out.println(
                "3. Search by message ID");
            System.out.println(
                "4. Search by recipient");
            System.out.println(
                "5. Delete message by hash");
            System.out.println(
                "6. Display full report");
            System.out.println(
                "7. Back to main menu");
            System.out.println("Enter choice: ");

            choice = Integer.parseInt(
                     input.nextLine());

            switch (choice) {
                case 1:
                    displayStoredMessages();
                    break;
                case 2:
                    System.out.println(
                        "Longest message: \n" +
                        getLongestMessage());
                    break;
                case 3:
                    System.out.println(
                        "Enter message ID: ");
                    String id = input.nextLine();
                    System.out.println(
                        searchByID(id));
                    break;
                case 4:
                    System.out.println(
                        "Enter recipient number: ");
                    String recipient =
                        input.nextLine();
                    System.out.println(
                        searchByRecipient(
                        recipient));
                    break;
                case 5:
                    System.out.println(
                        "Enter message hash: ");
                    String hash = input.nextLine();
                    System.out.println(
                        deleteByHash(hash));
                    break;
                case 6:
                    System.out.println(
                        displayReport());
                    break;
                case 7:
                    System.out.println(
                        "Returning to main menu.");
                    break;
                default:
                    System.out.println(
                        "Invalid option.");
            }
        } while (choice != 7);
    }

    // a. Display stored messages
    public static void displayStoredMessages() {
        if (storedMessages.isEmpty()) {
            System.out.println(
                "No stored messages.");
            return;
        }
        for (Message m : storedMessages) {
            System.out.println(
                "Recipient: " +
                m.getRecipient() +
                "\nMessage: " +
                m.getMessageText() +
                "\n---");
        }
    }
    public static String getLongestMessage() {
    ArrayList<Message> all = new ArrayList<>();
    all.addAll(sentMessages);
    all.addAll(storedMessages);
    if (all.isEmpty()) {
        return "No messages available.";
    }
    Message longest = all.get(0);
    for (Message m : all) {
        if (m.getMessageText().length() >
            longest.getMessageText().length()) {
            longest = m;
        }
    }
    return longest.getMessageText();
}

public static String searchByID(String id) {
    ArrayList<Message> all = new ArrayList<>();
    all.addAll(sentMessages);
    all.addAll(storedMessages);
    for (Message m : all) {
        if (m.getMessageID().equals(id)) {
            return "Recipient: " +
                   m.getRecipient() +
                   "\nMessage: " +
                   m.getMessageText();
        }
    }
    return "Message ID not found.";
}

public static String searchByRecipient(
                     String recipient) {
    ArrayList<Message> all = new ArrayList<>();
    all.addAll(sentMessages);
    all.addAll(storedMessages);
    String result = "";
    for (Message m : all) {
        if (m.getRecipient().equals(recipient)) {
            result += m.getMessageText() + "\n";
        }
    }
    if (result.isEmpty()) {
        return "No messages found for " + recipient;
    }
    return result;
}

public static String deleteByHash(String hash) {
    ArrayList<Message> all = new ArrayList<>();
    all.addAll(sentMessages);
    all.addAll(storedMessages);
    for (Message m : all) {
        if (m.createMessageHash().equals(
            hash.toUpperCase())) {
            String text = m.getMessageText();
            sentMessages.remove(m);
            storedMessages.remove(m);
            messageHashes.remove(
                m.createMessageHash());
            messageIDs.remove(m.getMessageID());
            return "Message: \"" + text +
                   "\" successfully deleted.";
        }
    }
    return "Hash not found.";
}

public static String displayReport() {
    ArrayList<Message> all = new ArrayList<>();
    all.addAll(sentMessages);
    all.addAll(storedMessages);
    if (all.isEmpty()) {
        return "No messages to display.";
    }
    String report =
        "===== MESSAGE REPORT =====\n";
    for (Message m : all) {
        report +=
            "\nMessage Hash: " +
            m.createMessageHash() +
            "\nRecipient: " +
            m.getRecipient() +
            "\nMessage: " +
            m.getMessageText() +
            "\n--------------------------";
    }
    return report;
}
        }
    

    