package lib.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import lib.Matrix.Matrix;
import lib.Solver.Determinan;
import lib.Solver.SPL_Balikan;
import lib.Solver.SPL_Cramer;
import lib.Solver.SPL_Gauss;
import lib.Solver.SPL_GaussJordan;
import lib.Solver.interpolationBicubic;
import lib.Solver.interpolationPolinom;

public class Menu {
    
    public static void mainMenu() {   
        System.out.println("====================================");
        System.out.println("=                                  =");
        System.out.println("=          TUBES ALGEO 1           =");
        System.out.println("=                                  =");
        System.out.println("====================================");
        System.out.println("=                                  =");
        System.out.println("= Menu                             =");
        System.out.println("= 1. Sistem Persamaan Linier       =");
        System.out.println("= 2. Determinan                    =");
        System.out.println("= 3. Matriks Balikan               =");
        System.out.println("= 4. Interpolasi Polinom           =");
        System.out.println("= 5. Interpolasi Bicubic           =");
        System.out.println("= 6. Regresi linear berganda       =");
        System.out.println("= 7. Keluar                        =");
        System.out.println("=                                  =");
        System.out.println("====================================");
        System.out.print("Pilihan : ");
    }
    public static void subMenuSPL() {
        System.out.println("====================================");
        System.out.println("=                                  =");
        System.out.println("= 1. Metode Eliminasi Gauss        =");
        System.out.println("= 2. Metode Eliminasi Gauss-Jordan =");
        System.out.println("= 3. Metode Matriks Balikan        =");
        System.out.println("= 4. Kaidah Cramer                 =");
        System.out.println("= 5. Kembali                       =");
        System.out.println("=                                  =");
        System.out.println("====================================");
        System.out.print("Pilihan : ");

    }
    public static void subMenuDet() {
        System.out.println("====================================");
        System.out.println("=                                  =");
        System.out.println("= 1. Metode Ekspansi Kofaktor      =");
        System.out.println("= 2. Metode Gauss                  =");
        System.out.println("= 3. Kembali                       =");
        System.out.println("=                                  =");
        System.out.println("====================================");
        System.out.print("Pilihan : ");
    }
    public static void subMenuInverse() {
        System.out.println("====================================");
        System.out.println("=                                  =");
        System.out.println("= 1. Metode Gauss-Jordan           =");
        System.out.println("= 2. Metode Adjoin                 =");
        System.out.println("= 3. Kembali                       =");
        System.out.println("=                                  =");
        System.out.println("====================================");
        System.out.print("Pilihan : ");

    }
    public static void main() {
        mainMenu();
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        switch(pilihan) {
            /* Sistem Persamaan Linier */
            case 1:
                subMenuSPL();
<<<<<<< HEAD
                int pilihanSPL = input.nextInt();
                switch(pilihanSPL) {
=======
                int pilihan2 ;
                do{ pilihan2 = myobj.nextInt();
                    if (pilihan2 < 1 || pilihan2 > 5) {
                        System.out.println("Pilihan tidak tersedia");
                        subMenuSPL();
                    }
<<<<<<< HEAD
                    System.out.println(pilihan2);
                    } while (!pilihan2.equals("y")|| !pilihan2.equals("n"));
                    break;
                case 2:
                    System.out.println("Metode Eliminasi Gauss-Jordan");
                    String pilihan3;
                    do{
                        System.out.println("Input File (y/n): ");
                        pilihan3 = input.next();
                    if (pilihan3.equals("y")) {
                        System.out.println("Input File");
                        System.out.println("Masukkan nama file: ");
                        String namaFile = input.next();
                        Matrix res2 = new Matrix();
                        res2=IO.inputMatrixFile(namaFile);
                        
                        SPL_GaussJordan.Jordan(res2);
                    } else if (pilihan3.equals("n")) {
                        // Masukin banyak baris dan kolom
                        System.out.println("Input Manual");
                        System.out.println("Masukkan banyak baris: ");
                        int baris=input.nextInt();
                        System.out.println("Masukkan banyak kolom: ");
                        int kolom=input.nextInt();

                        //inisiasi matriks
                        Matrix res2 = new Matrix();
                        res2.IsiMatriks(baris, kolom);

                        //eksekusi
                        SPL_GaussJordan.Jordan(res2);
                    } else {
                        System.out.println("Input salah");
                    }
                    } while (pilihan3 != "y" || pilihan3 != "n");
                    break;
                case 3:
                    System.out.println("Metode Matriks Balikan");
                    String pilihan4;
                    do{
                        System.out.println("Input File (y/n): ");
                        pilihan4 = input.next();
                        
                    if (pilihan4.equals("y")) {
                        System.out.println("Input File");
                        System.out.println("Masukkan nama file: ");
                        String namaFile = input.next();
                        Matrix inp = new Matrix();
                        inp=IO.inputMatrixFile(namaFile);
                        while(inp.col!=inp.row){
                            System.out.println("Matriks tidak persegi, mohon masukkan ulang");
                            System.out.println("Masukkan nama file: ");
                            namaFile = input.next();
                            inp=IO.inputMatrixFile(namaFile);
                        }
                        Matrix res3 = new Matrix();
                        res3=SPL_Balikan.INV_GaussJordan(inp);
                        //eksekusi
                        res3.Display();

                    } else if (pilihan4.equals("n")) {
                        // Masukin banyak baris dan kolom
                        System.out.println("Input Manual");
                        System.out.println("Masukkan banyak baris: ");
                        int baris=input.nextInt();
                        System.out.println("Masukkan banyak kolom: ");
                        int kolom=input.nextInt();

                        while(baris!=kolom){
                            System.out.println("Input tidak sesuai, masukkan kembali");
                            System.out.println("Masukkan banyak baris: ");
                            baris=input.nextInt();
                            System.out.println("Masukkan banyak kolom: ");
                            kolom=input.nextInt();
                        }

                        //inisiasi matriks
                        Matrix inp = new Matrix();
                        inp.IsiMatriks(baris, kolom);

                        Matrix res3 = new Matrix();
                        res3=SPL_Balikan.INV_GaussJordan(inp);
                        //eksekusi
                        res3.Display();
                    } else {
                        System.out.println("Input salah");
                    }
                    } while (pilihan4 != "y" || pilihan4 != "n");
                    break;
                case 4:
                    System.out.println("Kaidah Cramer");
                    String pilihan5;
                    do{
                        System.out.println("Input File (y/n): ");
                        pilihan5 = input.next();
                    if (pilihan5.equals("y")) {
                        System.out.println("Input File");
                        System.out.println("Masukkan nama file: ");
                        String namaFile = input.next();
                        Matrix inp = new Matrix();
                        inp=IO.inputMatrixFile(namaFile);
                        while(inp.col!=inp.row+1){
                            System.out.println("Matriks tidak persegi, mohon masukkan ulang");
                            System.out.println("Masukkan nama file: ");
                            namaFile = input.next();
                            inp=IO.inputMatrixFile(namaFile);
                        }
                        SPL_Cramer.Cramer(inp);                        
                        
                    } else if (pilihan5.equals("n")) {
                        System.out.println("Input Manual");
                        System.out.println("Masukkan banyak baris: ");
                        int baris=input.nextInt();
                        System.out.println("Masukkan banyak kolom: ");
                        int kolom=input.nextInt();

                        while(baris+1!=kolom){
                            System.out.println("Input tidak sesuai, masukkan kembali");
                            System.out.println("Masukkan banyak baris: ");
                            baris=input.nextInt();
                            System.out.println("Masukkan banyak kolom: ");
                            kolom=input.nextInt();
                        }
                        Matrix res = new Matrix();
                        res.IsiMatriks(baris, kolom);
                        SPL_Cramer.Cramer(res);
                        
                    } else {
                        System.out.println("Input salah");
                    }
                    } while (pilihan5 != "y" || pilihan5 != "n");
                    break;
                case 5:
                    System.out.println("\n");
                    main();
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
                }
                break;
            case 2:
                System.out.println("Determinan");
                subMenu();
                int pilihan2 = input.nextInt();
=======
                }while(pilihan2 < 1 || pilihan2 > 5);
    
>>>>>>> a3c039be7e9dd55158a2a916285489c96069e8ce
                switch (pilihan2) {
>>>>>>> fcb0dd048bfb73a7378b08630cac6cf763176d15
                    /* Metode Eliminasi Gauss */
                    case 1:
                        System.out.println("Metode Eliminasi Gauss");
                        SPL_Gauss.main();
                        break;
                    case 2:
                        // SPL_GaussJordan.main();
                        break;
                    case 3:
                        // SPL_Balikan.main();
                        break;
                    case 4:
                        // SPL_Cramer.main();
                        break;
                    case 5:
                        main();
                        break;
                    default:
                        System.out.println("Pilihan tidak ada");
                        break;
                }
                break;
            case 2:
                subMenuDet();
                int pilihanDet = input.nextInt();
                switch(pilihanDet) {
                    case 1:
                        // Determinan.main();
                        break;
                    case 2:
                        // Determinan.main();
                        break;
                    case 3:
                        main();
                        break;
                    default:
                        System.out.println("Pilihan tidak ada");
                        break;
                }
                break;
            case 3:
                subMenuInverse();
                int pilihanInverse = input.nextInt();
                switch(pilihanInverse) {
                    case 1:
                        // SPL_GaussJordan.main();
                        break;
                    case 2:
                        // SPL_GaussJordan.main();
                        break;
                    case 3:
                        main();
                        break;
                    default:
                        System.out.println("Pilihan tidak ada");
                        break;
                }
                break;
            case 4:
                // interpolationPolinom.main();
                break;
            case 5:
                // interpolationBicubic.main();
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak ada");
                main();
                break;
        }
    }
}