package lib.Utils;

import java.util.Scanner;

import lib.Matrix.Matrix;
import lib.Solver.SPL_Gauss;
import lib.Solver.SPL_GaussJordan;

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
    public static void subMenu() {
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
    public static void main() {
        Scanner input = new Scanner(System.in);
        mainMenu();
        int pilihan = input.nextInt();
        System.out.println("\n");
        System.out.println("====================================");
        switch (pilihan) {
            case 1:
                System.out.println("Sistem Persamaan Linier");
                subMenu();
                int pilihan1 = input.nextInt();
                switch (pilihan1) {
                case 1:
                    System.out.println("Metode Eliminasi Gauss");
                    String pilihan2;
                    do{
                        System.out.println("Input File (y/n): ");
                        pilihan2 = input.next();
                    if (pilihan2.equals("y")) {
                        System.out.println("Input File");
                    } else if (pilihan2.equals("n")) {
                        // Masukin banyak baris dan kolom
                        System.out.println("Input Manual");
                        int baris=input.nextInt();
                        int kolom=input.nextInt();

                        //inisiasi matriks
                        Matrix result = new Matrix();
                        result.IsiMatriks(baris, kolom);

                        //eksekusi
                        SPL_Gauss.Gauss(result);
                
                        
                    } else {
                        System.out.println("Input salah, mohon masukkan sesuai format");
                    }
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
                    } else if (pilihan3.equals("n")) {
                        // Masukin banyak baris dan kolom
                        System.out.println("Input Manual");
                        int baris=input.nextInt();
                        int kolom=input.nextInt();

                        //inisiasi matriks
                        Matrix result = new Matrix();
                        result.IsiMatriks(baris, kolom);

                        //eksekusi
                        SPL_GaussJordan.Jordan(result);
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
                    } else if (pilihan4.equals("n")) {
                        // Masukin banyak baris dan kolom
                        System.out.println("Input Manual");
                        int baris=input.nextInt();
                        int kolom=input.nextInt();

                        //inisiasi matriks
                        Matrix result = new Matrix();
                        result.IsiMatriks(baris, kolom);

                        //eksekusi
                        SPL_Gauss.Gauss(result);
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
                    } else if (pilihan5.equals("n")) {
                        System.out.println("Input Manual");
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
                switch (pilihan2) {
                    case 1:
                    System.out.println("Metode Eliminasi Gauss");
                    break;
                    case 2:
                    System.out.println("Metode Eliminasi Gauss-Jordan");
                    break;
                    case 3:
                    System.out.println("Metode Matriks Balikan");
                    break;
                    case 4:
                    System.out.println("Kaidah Cramer");
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
            case 3:
                System.out.println("Matriks Balikan");
                subMenu();
                int pilihan3 = input.nextInt();
                switch (pilihan3) {
                    case 1:
                    System.out.println("Metode Eliminasi Gauss");
                    break;
                    case 2:
                    System.out.println("Metode Eliminasi Gauss-Jordan");
                    break;
                    case 3:
                    System.out.println("Metode Matriks Balikan");
                    break;
                    case 4:
                    System.out.println("Kaidah Cramer");
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
            case 4:
                System.out.println("Interpolasi Polinom");
                break;
            case 5:
                System.out.println("Interpolasi Bicubic");
                break;
            case 6:
                System.out.println("Regresi Linear Berganda");
                break;
            case 7:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
        }
    }
}
