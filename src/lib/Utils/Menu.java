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
                int pilihanSPL = input.nextInt();
                switch(pilihanSPL) {
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