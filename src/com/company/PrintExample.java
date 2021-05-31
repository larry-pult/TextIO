package com.company;

import java.io.*;

public class PrintExample {

    public static void main(String[] args) {
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    try {
            System.out.println("masukkan nama anda");
            String nama = bufferedReader.readLine();
            System.out.println("Halo, " + nama + "!");
        }
	    catch (IOException e) {
            System.out.println("ada error");
        }
    }
}
