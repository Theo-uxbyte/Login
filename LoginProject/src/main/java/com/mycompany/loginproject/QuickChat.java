/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class QuickChat {
    
 public static void startChat(Scanner input) {
        
        System.out.println("Welcome to QuickChat.");
        ArrayList<Message> messages = new ArrayList<>();
        int menuChoice = 0;
        
        do {
            System.out.println("\n--- QUICKCHAT MENU ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent " +
                               "messages");
            System.out.println("3. Quit");
            System.out.println("Enter choice: ");
            menuChoice = Integer.parseInt(
                         input.nextLine());
            
            switch (menuChoice) {
                case 1:
                    // Ask how many messages
                    System.out.println(
                        "How many messages do you " +
                        "want to send? ");
                    int numMessages = Integer.parseInt(
                                     input.nextLine());
                    
                    for (int i = 0; i < numMessages; i++){
   System.out.println("\n--- Message " 
        + (i+1) + " of " + numMessages + " ---");
                        
// Get recipient
System.out.println("Enter recipient cell " + " number (+xx max 10): ");
String recipient =input.nextLine();
                        
 // Get message
 System.out.println("Enter message " + "(max 250 chars): ");
 String text = input.nextLine();
                        
                        Message msg = new Message(
                                      recipient, text);
                        
                        // Check length
                        System.out.println(
                            msg.checkMessageLength());
                        
                        if (text.length() <= 250) {
                            // Ask send/store/disregard
                            System.out.println(
                                "1. Send Message");
                            System.out.println(
                                "2. Disregard Message");
                            System.out.println(
                                "3. Store Message " +
                                "to send later");
                            int sendChoice = 
                                Integer.parseInt(
                                input.nextLine());
                            
                            System.out.println(
                                msg.sentMessage(
                                sendChoice));
                            
                            if (sendChoice == 1) {
                                messages.add(msg);
                                // Print message details
                                System.out.println(
                                    msg.printMessages());
                            } else if (sendChoice == 2) {
                                System.out.println(
                                "Press 0 to delete " +
                                "the message");
                            } else if (sendChoice == 3) {
                                messages.add(msg);
                            }
                        }
                    }
                    // Show total messages sent
                    System.out.println(
                        "\nTotal messages sent: " +
                        Message.returnTotalMessages());
                    break;
                    
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                    
                case 3:
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
            
        } while (menuChoice != 3);
    }
}




     