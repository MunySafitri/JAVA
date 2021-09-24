
package tugas;


import static tugas.Action.tampilan;
import static tugas.Action.ulang;
import static tugas.Action.clearScreen;
import static tugas.Action.Lompat1;
import java.util.Scanner;
import java.lang.*;
public class Coba {

    public static int[][] luasBidang = new int[][] {
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

        while(nextGame){
            clearScreen();
            randomBaris = (int) Math.floor(Math.random() * 10);
            randomKolom = (int) (Math.random()*10);
            posisiTupai = luasBidang[randomBaris][randomKolom];
            System.out.println("posisi tupai sekarang berada di kotak ke- "+ posisiTupai);

            if(posisiTupai>0 && posisiTupai<=50){
                System.out.println("\nkarena posisi tupai berada pada rentang 1-50 \nTupai hanya bisa melompat sebanyak 20 kali\n");
                posisiTupai = Lompat1(randomBaris,randomKolom,posisiTupai);
                nextGame = ulang(nextGame);   
            }
            else{
                System.out.printf("\nkarena posisi tupai berada pada rentang 51-100 \nTupai hanya bisa melompat sebanyak 10 kali\n");
                posisiTupai = Lompat1(randomBaris,randomKolom,posisiTupai);
                nextGame = ulang(nextGame);  
            }
        }
        System.out.printf("\nTerimakasih sudah bermain^^\n"); 
    }
}                               
