package com.company;

import java.io.*;

public class FileWriteExample {

    public static void main(String[] args) {
        // inisiasi objek BufferedReader untuk membaca dari console
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            // membuat objek file dengan argumen "todolist.txt"
            File f = new File("todolist.txt");
            // kalau filenya tidak ada, filenya ditulis
            if (!f.exists()) {
                // inisiasi objek PrintWriter untuk melakukan input/output
                PrintWriter pw = new PrintWriter(f);
                // tuliskan "to do list:" pada baris pertama
                pw.println("to do list:");
                // loop untuk menulis sebanyak yang kita mau
                for (int i = 0; i < 100; i++) {
                    System.out.println("silahkan input");
                    // baca dari console dan dimasukan ke variabel
                    String task = consoleReader.readLine();
                    if (task.equalsIgnoreCase("quit")) {
                        // kalau string nya terbaca "quit", break dari loop dan program selesai
                        // tutup writer dan reader
                        consoleReader.close();
                        pw.close();
                        break;
                    }
                    else {
                        // print string nya ke file (kalau stringnya bukan "quit")
                        pw.println(task);
                    }
                }

            }
            // kalau filenya sudah ada, filenya dibaca
            else {
                // inisiasi objek BufferedReader untuk membaca dari file
                BufferedReader fileReader = new BufferedReader(new FileReader(f));
                // print header
                System.out.println(fileReader.readLine());
                // for loop untuk membaca seluruh isi dari file
                for (int i = 0; i <= 100; i++) {
                    // baca baris dan dimasukkan ke variabel
                    String task = fileReader.readLine();
                    if (task != null) {
                        // kalau string nya bukan null, print stringnya
                        System.out.println("- " + task);
                    }
                    else {
                        // kalau string nya null, artinya filenya sudah habis, dan break dari loop
                        break;
                    }
                }
                // menanyakan apabila to do list nya sudah diselesaikan
                System.out.println("apakah anda sudah menyelesaikannya? (y/n)");
                // mengambil input yes/no
                String quit = consoleReader.readLine();
                if (quit.equalsIgnoreCase("y")) {
                    // close semua input stream (kalau nggak ntar filenya nggak bisa didelete)
                    consoleReader.close();
                    fileReader.close();
                    f.delete();
                }
            }
        }
        catch (IOException e) {
            System.out.println("ada error");
        }
    }
}
