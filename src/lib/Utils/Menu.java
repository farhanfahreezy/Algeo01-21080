package lib.Utils;

import java.util.Scanner;

import lib.Matrix.Matrix;
import lib.Solver.SPL_Balikan;
import lib.Solver.SPL_Cramer;
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
        mainMenu();
        Scanner myobj = new Scanner(System.in);
        int pilihan = myobj.nextInt();
        switch (pilihan) {
            /* Sistem Persamaan Liniear */
            case 1 :
                subMenu();
                int pilihan2 ;
                do{ pilihan2 = myobj.nextInt();
                    if (pilihan2 < 1 || pilihan2 > 5) {
                        System.out.println("Pilihan tidak tersedia");
                        subMenu();
                    }
                }while(pilihan2 < 1 || pilihan2 > 5);
    
                switch (pilihan2) {
                    /* Metode Eliminasi Gauss */
                    case 1 :
                        String solution[];
                        String pilihan3,filename;
                        Scanner myobj2 = new Scanner(System.in);
                        Scanner myobj3 = new Scanner(System.in);
                        Scanner myobj4 = new Scanner(System.in);
                        Scanner myobj5 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan3 = myobj2.nextLine();
                            if ((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N")));
                        Matrix inp = new Matrix();
                        if (pilihan3.equals("y") || pilihan3.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename = myobj4.nextLine();
                            inp = IO.inputMatrixFile(filename);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        SPL_Gauss.Gauss(inp);
                        solution = Matrix.SolusiSPL(inp);
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan3 = myobj3.nextLine();
                            if ((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N")));
                        if (pilihan3.equals("y") || pilihan3.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename = myobj5.nextLine();
                            IO.outputOBEFile(filename, solution);
                        } 
                        break;
                    /* Metode Eliminasi Gauss-Jordan */
                    case 2 :
                        String solution2[];
                        String pilihan4,filename2;
                        Scanner myobj6 = new Scanner(System.in);
                        Scanner myobj7 = new Scanner(System.in);
                        Scanner myobj8 = new Scanner(System.in);
                        Scanner myobj9 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan4 = myobj6.nextLine();
                            if ((!pilihan4.equals("y") && !pilihan4.equals("n"))  && (!pilihan4.equals("Y") && !pilihan4.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan4.equals("y") && !pilihan4.equals("n"))  && (!pilihan4.equals("Y") && !pilihan4.equals("N")));
                        Matrix inp2 = new Matrix();
                        if (pilihan4.equals("y") || pilihan4.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename2 = myobj8.nextLine();
                            inp2 = IO.inputMatrixFile(filename2);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp2.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        SPL_GaussJordan.Jordan(inp2);
                        solution2 = Matrix.SolusiSPL(inp2);
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan4 = myobj7.nextLine();
                            if ((!pilihan4.equals("y") && !pilihan4.equals("n"))  && (!pilihan4.equals("Y") && !pilihan4.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan4.equals("y") && !pilihan4.equals("n"))  && (!pilihan4.equals("Y") && !pilihan4.equals("N")));
                        if (pilihan4.equals("y") || pilihan4.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename2 = myobj9.nextLine();
                            IO.outputOBEFile(filename2, solution2);
                        }
                        break;
                    case 3 :
                    
                        break;
                    case 4 :
                
                        break;
                    case 5 :
                        main();
                        break;
                    default :
                        System.out.println("Pilihan tidak ada");
                        break;
                }

                break;
            
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                break;
            case 5 :
                break;
            case 6 :
                break;
            case 7 :
                System.out.println("Terima kasih");
                break;
            default :
                System.out.println("Pilihan tidak ada");
                main();
                break;
        }
    }
}