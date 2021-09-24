package tugas;

import static tugas.Coba.inputAngka;
import static tugas.Coba.input;
import java.util.Scanner;
import java.util.*;
import java.io.IOException;
import static tugas.Coba.luasBidang;
import java.lang.*;

class Action{
    static int[][] luasBidang = new int[][] {
        {1,2,3,4,5,6,7,8,9,10},
        {11,12,13,14,15,16,17,18,19,20},
        {21,22,23,24,25,26,27,28,29,30},
        {31,32,33,34,35,36,37,38,39,40},
        {41,42,43,44,45,46,47,48,49,50},
        {51,52,53,54,55,56,57,58,59,60},
        {61,62,63,64,65,66,67,68,69,70},
        {71,72,73,74,75,76,77,78,79,80},
        {81,82,83,84,85,86,87,88,89,90},
        {91,92,93,94,95,96,97,98,99,100}
    };
    
    static Boolean ulang(Boolean nextGame){
        do{  
            System.out.printf("Apakah anda ingin melanjutkan (Ya/Tidak): ");
            inputAngka = new Scanner(System.in);
            String input2 = inputAngka.nextLine();
            
            if("Tidak".equalsIgnoreCase(input2)){
                nextGame = false; 
               break;
            }else if("Ya".equalsIgnoreCase(input2)){
                break;
            }else{
                System.err.println("Masukkan input dengan benar");
            }
        }while(true);

        return nextGame;
    }

    static void tampilan(int[][] luasBidang){
        for(int baris[] : luasBidang ){
            for (int kolom : baris){
                System.out.print(kolom+"\t|");
            }
            System.out.println();
        }
    }
    
    static void clearScreen(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\143");
            }
        }catch (Exception e){
            System.err.println("Tidak bisa clear screen");
        }

    }
    
    static int Lompat1(int randomBaris,int randomKolom,int posisiTupai){
        int angkaAcak;
        int batas;
        int jumlah=0;
        int benar=0;
        tampilan(luasBidang);

        if(posisiTupai <=50 && posisiTupai>0){
            batas=20;
        }else if(posisiTupai > 50){
            batas = 10;
        }else{
            batas =20;
        }
        for(int i =0; i < batas; i++){
            tampilan2(posisiTupai);

            randomKolom = (int) Math.floor(Math.random() * 10);
            randomBaris = (int) (Math.random()*(10-randomBaris)+randomBaris);
            posisiTupai = luasBidang[randomBaris][randomKolom];

            System.out.print("Percobaan ke-"+(i+1));

            Action jawaban = new Action();
            jawaban.acakPilihan(posisiTupai);

            System.out.print("\nMelompat ke: ");
            input = new Scanner(System.in);
            angkaAcak = input.nextInt();

            if(posisiTupai == angkaAcak){
                if(posisiTupai==100){
                    benar++;
                    System.out.println("\nSelamat! Tupai mencapai garis finish di angka 100");
                    System.out.println("Anda melompak sebanyak "+ jumlah +  "kali \nDengan menjawab benar sebanyak "+ benar);
                    break;
                }else{
                    System.out.printf("Tupai berada pada kotak %d\n",posisiTupai);
                    jumlah++;
                    benar++;
                }
            }
            else if(angkaAcak >=  luasBidang[randomBaris][0] && angkaAcak < luasBidang[randomBaris][9]){
                if(posisiTupai >=  luasBidang[randomBaris][0] && posisiTupai < luasBidang[randomBaris][9] ){
                    System.err.println("Jarak tupai berada pada posisi "+ posisiTupai +", sejauh ");
                }else{
                    System.err.println("Anda hanya bisa melompat pada baris yang berbeda..\n");
                    System.err.println("Jarak tupai berada pada posisi "+ posisiTupai +", sejauh ");
                }

                if(posisiTupai< angkaAcak){
                    System.err.print((angkaAcak-posisiTupai)+" angka dari anda");
                }else{
                    System.err.print((posisiTupai-angkaAcak)+" angka dari anda");
                }
                jumlah++;
            }
            else{
                System.err.println("Lokasi loncat salah!, coba lagi..");
                System.err.println("Tupai berada pada kotak ke-"+ posisiTupai+ " pada baris " + randomBaris);
                jumlah++;   
            }
            if(jumlah==(batas-1)){
                System.err.println("Tupai sudah lelah melompat\n");
            }
            System.out.println("\nTekan Enter untuk Lanjut");
            Scanner Enter =new Scanner(System.in);
            Enter.nextLine();
            clearScreen();
        }
        return posisiTupai;
    }
    
    private void acakPilihan(int posisiTupai) {
        try{
            int acak[] = new int[7];
            for(int i=0;i<6;i++){
                acak[i] = (int) Math.floor(Math.random() *(101-posisiTupai) +posisiTupai);
            }
            int benar = (int) Math.random() * 6;
            acak[benar] = posisiTupai;
            System.out.print("\nOption: ");
            for(int i=0;i<6;i++){
                System.out.print(acak[i]);
                if(acak[i+1] !=0){
                    System.out.print(", ");
                }
            }
        }catch(Exception e){
            System.out.print(e);
        }    
    }

    private static void tampilan2(int posisiTupai){
        tampilan(luasBidang);
        if(posisiTupai>0 && posisiTupai<=50){
            System.out.println("\nPosisi tupai berada pada rentang 1-50 \n");
        }else{
            System.out.println("\nPosisi tupai berada pada rentang 51-100 \n");
        }
    }
}
