package com.medium.musyokaian;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	cracker();
    }
    public static void cracker(){
        System.out.println("[+] MD5 Hash cracker written in Java\n[+] Author: Musyoka Ian");
        Scanner scanner = new Scanner(System.in);
        System.out.print("[+] Enter the wordlist: ");
        String wordlist = scanner.nextLine();
        System.out.println("[*] Reading the file");
        System.out.print("\n[+] Enter the hash you want to crack: ");
        String hash = scanner.nextLine();
        try {
            BufferedReader file = new BufferedReader(new FileReader(wordlist));
            String words;
            System.out.println("[*] Hashing the wordlist\n");
            while ((words = file.readLine()) != null){
                try {
                    String hashed;
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(words.getBytes(StandardCharsets.UTF_8), 0, words.length());
                    hashed = new BigInteger(1, messageDigest.digest()).toString(16);
                    if (hash.equals(hashed)) {
                        System.out.println("[+] Hash successfully cracked\n[+] Password: " + words + "\n[+] Exiting");
                        System.exit(1);
                    }
                }catch (NoSuchAlgorithmException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        }
    }
