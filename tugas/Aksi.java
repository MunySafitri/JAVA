package tugas;

/**masih dalam package yang sama
 * dilakukan import
 */
import static tugas.Main.inputAngka;
import static tugas.Main.input;
import java.util.*;
import static tugas.Main.luasBidang;
import java.util.InputMismatchException;

class Aksi{
    /**
     * Fungsi yang akan menanyakan kepada user apakah ingin lanjut atau tidak..
     * dan akan mengembalikan nilai true atau false sesuai keingin user untuk melanjutkan
     * permainan atau tidak
     */
    static Boolean ulang(Boolean nextGame){
        do{  
            System.out.printf("\nApakah anda ingin melanjutkan (Ya/Tidak): ");
            inputAngka = new Scanner(System.in);
            String input2 = inputAngka.nextLine();
            
            if("Tidak".equalsIgnoreCase(input2)){
                nextGame = false; 
               break;
            }else if("Ya".equalsIgnoreCase(input2)){
                break;
            }else{
                System.err.println("\nMasukkan input dengan benar");
                Enter();
                clearScreen();
            }
        }while(true);

        return nextGame;
    }
    /**
     * Fungsi untuk menyalin luas bidang 
     * yang bertujuan supaya tupai terlihat keberadaannya
     * supaya tidak mengubah nilai variabel luasBidang
     */
    static void Salin(int[][] luasBidang,int[][] luasBidang2){
        int i = 0;
        for(int baris[] : luasBidang ){
            int j = 0;
            for (int kolom : baris){
                luasBidang2[i][j]=kolom;
                j++;
            }
            i++;
        }
    }

    /**
     * fungsi untuk menghapus screen di terminal 
     **/
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
    /**
     * fungsi aksi tupai untuk mencari garis finish
     */
    static void Lompat1(int randomBaris,int randomKolom,int posisiTupai){
        int jumlahLangkah = 0,jumlahCompute,angkaAcak,batas,jumlah=0, benar=0;
        int posisiAwal=posisiTupai;
        int i =0;
        int[][] luasBidang2 = new int[10][10];
        
        Salin(luasBidang,luasBidang2);
        //syarat batas melompat sesuai posisi tupai
        if(posisiTupai <=50 && posisiTupai>0){
            batas=20;
        }else if(posisiTupai > 50){
            batas = 10;
        }else{
            batas =20;
        }
        int jumlahNyawa=batas;
        //dilakukan perulangan sesuai dengan variabel batas
        for(i = 0; i < batas; ){
            
            clearScreen();
            int nyawa = 0;
            
            System.out.print("Lompat: "+ (jumlahNyawa--));

            System.out.println("\nTupai diwakili dengan angka 0");
            tampilan2(posisiTupai,luasBidang2);

            System.out.println("Tupai berada pada kotak ke-"+posisiTupai);

            Aksi pilihan = new Aksi();
            int[] acak = pilihan.acakPilihan(posisiTupai);

            System.out.print("\nMelompat ke: ");
            input = new Scanner(System.in);
            // menggunakan konsep try dan catch apabila user tidak menginput angka
            try{
                angkaAcak = input.nextInt(); 

                for(int j=0; j<=acak.length-1 ; j++){  
                    if(angkaAcak==acak[j]){
                        posisiTupai = acak[j];
                        System.out.println("Tupai berada di posisi "+ posisiTupai);
                        jumlahLangkah++;
                        break;
                    }
                    else if(angkaAcak==posisiTupai){
                        System.out.println("\nPosisi Anda masih sama");
                        i--; 
                        break;   
                    
                    } if (j+1 == 8){
                        System.out.println("\ndiluar jangkauan");
                        i--;
                        break;
                    }
                }

                if(angkaAcak < 0 || angkaAcak>100){
                    System.err.println("Anda memasukkan input yang salah");
                    i--;
                    Enter();
                    continue;
                }
            }catch(InputMismatchException e){//fungsi akan dijalankan ketika user memasukkan selain angka
                i--;
                System.err.println("Anda memasukkan input yang salah");
                Enter();
                continue;
            }
            if(i+1 == batas){// jika tupai sudah dibatasnya, tupai akan lelah dalam melompat
                System.out.println("\nTupai sudah Lelah");
                Enter();
                break;
            }
              
            if(posisiTupai==100){
                System.out.println("Selamat! tupai sudah berada di garis finish\n");
                Enter();
                compute( posisiAwal, jumlahLangkah);//dilakukan perhitungan dan membandingkannya dengan prediksi komputer
                break;
            }    
            
            System.out.println("\nTekan Enter untuk Lanjut");
            i++;
            Enter();     
        }
    }
    /**
     * fungsi batasan tupai agar tetap bergerak secara diagonal,
     * agar tupai tidak melompat terlalu jauh dan tetap dalam kotak 1-100
     * fungsi ini akan mengembalikan 
    */
    private int[] acakPilihan(int posisiTupai) {
        int acak[] = new int[8];
        try{
            acak[0] = posisiTupai-11;
            acak[1] = posisiTupai-10;
            acak[2] = posisiTupai-9;
            acak[3] = posisiTupai-1;
            acak[4] = posisiTupai+1;
            acak[5] = posisiTupai+9;
            acak[6] = posisiTupai+10;
            acak[7] = posisiTupai+11;
            if(acak[5] > 100 && acak[6]>100 && acak[7]>100) {
                acak[5] = 0;
                acak[6] = 0;
                acak[7] = 0;
            }else if(acak[5] < 0 && acak[6]<0 && acak[7]<0){
                acak[1] = 0;
                acak[2] = 0;
                acak[3] = 0;
            }
        }catch(Exception e){
            System.out.print(e);
        } 
        return acak;   
    }
    /** fungsi untuk menaempatkan
     * posisi tupai, dengan diwakili angka 0
     */
    private static void tampilan2(int posisiTupai,int[][] luasBidang2){
        
        for(int i = 0; i<10; i++){
            for(int j=0;j<10;j++){
                if(luasBidang2[i][j] == posisiTupai){
                    luasBidang2[i][j] = 0;
                }
            }
        } 
        tampilan(luasBidang2); 
        Salin(luasBidang,luasBidang2);  
    }
    /**fungsi yang digunakan untuk
     * menampilkan posisi tupai di monitor
     */

    private static void tampilan(int[][] luasBidang2){
        for(int baris[] : luasBidang2 ){
            for (int kolom : baris){
                System.out.print(kolom+"\t|");
            }
            System.out.println();
        }
    }
    //fungsi untuk enter
    static void Enter(){
        Scanner Enter = new Scanner(System.in);
        Enter.nextLine();
    } 
    /**
     * fungsi untuk membandingkan langkah user
     * dengan langkah hitungan komputer
     * 
    */
    private static void compute(int posisiTupai,int jumlahLangkah){
        int jumlah=0;

        while(posisiTupai<=100){
            if(posisiTupai % 10 == 0){
                posisiTupai = posisiTupai+10;
                jumlah=jumlah+1;
            }
            else if(posisiTupai<90){
               posisiTupai = posisiTupai + 11;
               jumlah=jumlah+1;
               
            }else{
                posisiTupai = posisiTupai+1;
                jumlah=jumlah+1;
            }    
        }
        System.out.println("Anda melompatkan tupai sebanyak "+ jumlahLangkah + "\ndan jarak terpendek untuk melangkah menurut komputer adalah "+ (jumlah-1));

        /**percabangan untuk membandingkan
         * langkah user dengan langkah program 
        */ 

        if(jumlahLangkah>jumlah-1){
            System.out.println("\nLangkah anda " + (jumlahLangkah-(jumlah-1)) +" lebih banyak");
        }else if(jumlahLangkah == jumlah-1){
            System.out.println("\nLangkah anda sama dengan jumlah langkah terpendek menurut komputer");
        }else{
            System.out.println("\nLangkah anda " + ((jumlah-1)-jumlahLangkah + " lebih pendek daripada prediksi komputer") );
        }
    }
}