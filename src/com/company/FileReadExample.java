package com.company;

import java.io.*;

public class FileReadExample {

        public static void main(String[] args) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("grocery.txt"));
                //BufferedReader br = new BufferedReader(new FileReader("D:\\intellij\\TextIO\\grocery.txt"));
                for (int i = 0; i < 100; i++) {
                    // ngebaca 1 baris dari filenya
                    String belanja = br.readLine();
                    // kalau line nya bukan null, print linenya
                    if (belanja != null) {
                        System.out.println("saya beli " + belanja);
                    }
                    // kalau linenya null, break
                    else {
                        System.out.println("oke sudah habis");
                        break;
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("file tidak ditemukan");
            }
            catch (IOException e) {
                System.out.println("ada error");
            }
        }
}
