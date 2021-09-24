
/**
 * Membuat program tupai lompat
 * @Muny Safitri
 * program ini berada pada package tugas.
 */
package tugas;

import static tugas.Aksi.ulang;
import static tugas.Aksi.clearScreen;
import static tugas.Aksi.Lompat1;
import static tugas.Aksi.Enter;
import java.util.Scanner;

public class Main {
    /**
     * mendeklarasikan variable global (dimana ini akan sering digunakan)
     */

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
    static Scanner input;
    static Scanner inputAngka;

    public static void main(String args[]){
        int randomBaris;
        int randomKolom;
        int posisiTupai;
        Boolean nextGame = true;

        /**
         * membuat looping agar user dapat bermain sepuasnya,
         * lalu untuk posisi pertama tupai, ditentukan oleh program
         * dengan fungsi Math.random()
         * jika posisi awal tupai <=50 maka user memiliki kesempatan 20x
         * jika lebih, user memiliki kesempatan 10x melompatkan tupai
         */

        while(nextGame){
            clearScreen();
            randomBaris = (int) Math.floor(Math.random() * 10);
            randomKolom = (int) (Math.random()*10);
            posisiTupai = luasBidang[randomBaris][randomKolom];

            if(posisiTupai>0 && posisiTupai<=50){
                System.out.println("\nkarena posisi tupai berada pada rentang 1-50 \nTupai hanya bisa melompat sebanyak 20 kali\n");
                Enter();
                Lompat1(randomBaris,randomKolom,posisiTupai);//fungsi aksi pada tupai
                nextGame = ulang(nextGame); //yang akan mengembalikan bolean untuk looping 
            }
            else{
                System.out.printf("\nkarena posisi tupai berada pada rentang 51-100 \nTupai hanya bisa melompat sebanyak 10 kali\n");
                Enter();
                Lompat1(randomBaris,randomKolom,posisiTupai); //fungsi aksi pada tupai
                nextGame = ulang(nextGame);  //yang akan mengembalikan bolean untuk looping
            }
        }
        System.out.printf("\nTerimakasih sudah bermain^^\n"); // permainan selesai
    }
}   
/*
 * progran ini memiliki 2 class, yaitu Main.java (class utama) dan 
 * Aksi.java (Class tambahan untuk aksi tupai)
*/ 
