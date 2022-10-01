package lib.Utils;

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
        Scanner myobj = new Scanner(System.in);
        int pilihan = myobj.nextInt();
        switch (pilihan) {
            /* Sistem Persamaan Liniear */
            case 1 :
                subMenuSPL();
                int pilihan2 ;
                do{ pilihan2 = myobj.nextInt();
                    if (pilihan2 < 1 || pilihan2 > 5) {
                        System.out.println("Pilihan tidak tersedia");
                        subMenuSPL();
                    }
                }while(pilihan2 < 1 || pilihan2 > 5);
    
                switch (pilihan2) {
                    /* Metode Eliminasi Gauss */
                    case 1 :
                        String solution[];
                        String pilihan3,filename;
                        Scanner input = new Scanner(System.in);
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
                            System.out.println("output file? (y/n): ");
                            pilihan3 = input.nextLine();
                            if ((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan3.equals("y") && !pilihan3.equals("n"))  && (!pilihan3.equals("Y") && !pilihan3.equals("N")));
                        if (pilihan3.equals("y") || pilihan3.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename = myobj5.nextLine();
                            IO.outputOBEFile(filename, solution);
                        }
                        main(); 
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
                        main();
                        break;
                    /* Metode Matriks Balikan */
                    case 3 :
                        String solution3[];
                        String pilihan5,filename3;
                        Scanner myobj10 = new Scanner(System.in);
                        Scanner myobj11 = new Scanner(System.in);
                        Scanner myobj12 = new Scanner(System.in);
                        Scanner myobj13 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan5 = myobj10.nextLine();
                            if ((!pilihan5.equals("y") && !pilihan5.equals("n"))  && (!pilihan5.equals("Y") && !pilihan5.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan5.equals("y") && !pilihan5.equals("n"))  && (!pilihan5.equals("Y") && !pilihan5.equals("N")));
                        Matrix inp3 = new Matrix();
                        if (pilihan5.equals("y") || pilihan5.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename3 = myobj12.nextLine();
                            inp3 = IO.inputMatrixFile(filename3);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp3.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        solution3 = Matrix.SolusiSPL(inp3);
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan5 = myobj11.nextLine();
                            if ((!pilihan5.equals("y") && !pilihan5.equals("n"))  && (!pilihan5.equals("Y") && !pilihan5.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan5.equals("y") && !pilihan5.equals("n"))  && (!pilihan5.equals("Y") && !pilihan5.equals("N")));
                        if (pilihan5.equals("y") || pilihan5.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename3 = myobj13.nextLine();
                            IO.outputOBEFile(filename3, solution3);
                        }
                        main();
                        break;
                    /* Metode Cramer */
                    case 4 :
                        String solution4[];
                        String pilihan6,filename4;
                        Scanner myobj14 = new Scanner(System.in);
                        Scanner myobj15 = new Scanner(System.in);
                        Scanner myobj16 = new Scanner(System.in);
                        Scanner myobj17 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan6 = myobj14.nextLine();
                            if ((!pilihan6.equals("y") && !pilihan6.equals("n"))  && (!pilihan6.equals("Y") && !pilihan6.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan6.equals("y") && !pilihan6.equals("n"))  && (!pilihan6.equals("Y") && !pilihan6.equals("N")));
                        Matrix inp4 = new Matrix();
                        if (pilihan6.equals("y") || pilihan6.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename4 = myobj16.nextLine();
                            inp4 = IO.inputMatrixFile(filename4);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp4.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        SPL_Cramer.Cramer(inp4);
                        solution4 = Matrix.SolusiSPL(inp4);
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan6 = myobj15.nextLine();
                            if ((!pilihan6.equals("y") && !pilihan6.equals("n"))  && (!pilihan6.equals("Y") && !pilihan6.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan6.equals("y") && !pilihan6.equals("n"))  && (!pilihan6.equals("Y") && !pilihan6.equals("N")));
                        if (pilihan6.equals("y") || pilihan6.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename4 = myobj17.nextLine();
                            IO.outputOBEFile(filename4, solution4);
                        }
                        main();
                        break;
                    /* Kembali */
                    case 5 :
                        main();
                        break;
                    default :
                        System.out.println("Pilihan tidak ada");
                        break;
                }
                break;
            /* Determinan */
            case 2 :
                subMenuDet();
                int pilihanDet;
                Scanner myobj18 = new Scanner(System.in);
                do{
                    pilihanDet = myobj18.nextInt();
                    if (pilihanDet < 1 || pilihanDet > 3) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while(pilihanDet < 1 || pilihanDet > 3);
                switch(pilihanDet){
                    /* Metode Ekspansi Kofaktor */
                    case 1:
                        String pilihan7,filename5;
                        Scanner myobj19 = new Scanner(System.in);
                        Scanner myobj20 = new Scanner(System.in);
                        Scanner myobj21 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan7 = myobj19.nextLine();
                            if ((!pilihan7.equals("y") && !pilihan7.equals("n"))  && (!pilihan7.equals("Y") && !pilihan7.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan7.equals("y") && !pilihan7.equals("n"))  && (!pilihan7.equals("Y") && !pilihan7.equals("N")));
                        Matrix inp5 = new Matrix();
                        if (pilihan7.equals("y") || pilihan7.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename5 = myobj21.nextLine();
                            inp5 = IO.inputMatrixFile(filename5);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp5.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        System.out.printf("Determinan matriks : %.2f",Determinan.DET_Reduksi_Baris_Kofaktor(inp5));
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan7 = myobj20.nextLine();
                            if ((!pilihan7.equals("y") && !pilihan7.equals("n"))  && (!pilihan7.equals("Y") && !pilihan7.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan7.equals("y") && !pilihan7.equals("n"))  && (!pilihan7.equals("Y") && !pilihan7.equals("N")));
                        if (pilihan7.equals("y") || pilihan7.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename5 = myobj21.nextLine();
                            IO.outputDeterminanFile(filename5, String.format("Determinan matriks: %.2f", Determinan.DET_Reduksi_Baris_Kofaktor(inp5)));
                        }
                        main();
                    break;
                    /* Metode Gauss */
                    case 2:
                        String pilihan8,filename6;
                        Scanner myobj22 = new Scanner(System.in);
                        Scanner myobj23 = new Scanner(System.in);
                        Scanner myobj24 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan8 = myobj22.nextLine();
                            if ((!pilihan8.equals("y") && !pilihan8.equals("n"))  && (!pilihan8.equals("Y") && !pilihan8.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan8.equals("y") && !pilihan8.equals("n"))  && (!pilihan8.equals("Y") && !pilihan8.equals("N")));
                        Matrix inp6 = new Matrix();
                        if (pilihan8.equals("y") || pilihan8.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename6 = myobj24.nextLine();
                            inp6 = IO.inputMatrixFile(filename6);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp6.IsiMatriks(baris, kolom);
                        }
                        System.out.print("\n");
                        System.out.printf("Determinan matriks : %.2f",Determinan.DET_Gauss(inp6));
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan8 = myobj23.nextLine();
                            if ((!pilihan8.equals("y") && !pilihan8.equals("n"))  && (!pilihan8.equals("Y") && !pilihan8.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan8.equals("y") && !pilihan8.equals("n"))  && (!pilihan8.equals("Y") && !pilihan8.equals("N")));
                        if (pilihan8.equals("y") || pilihan8.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename6 = myobj24.nextLine();
                            IO.outputDeterminanFile(filename6, String.format("Determinan matriks: %.2f", Determinan.DET_Gauss(inp6)));
                        }
                        main();
                        break;
                    /* Kembali */
                    case 3:
                        main();
                        break;
                }
                break;
            /* Matriks balikan */
            case 3 :
                subMenuInverse();
                int pilihan9 ;
                do {
                    System.out.print("Pilihan : ");
                    pilihan9 = myobj.nextInt();
                    if (pilihan9 < 1 || pilihan9 > 3) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while(pilihan9 < 1 || pilihan9 > 3);
                switch (pilihan9) {
                    /* Metode Gauss-Jordan */
                    case 1:
                        String pilihan10,filename7;
                        Scanner myobj25 = new Scanner(System.in);
                        Scanner myobj26 = new Scanner(System.in);
                        Scanner myobj27 = new Scanner(System.in);
                        do {
                            System.out.print("input file? (y/n): ");
                            pilihan10 = myobj25.nextLine();
                            if ((!pilihan10.equals("y") && !pilihan10.equals("n"))  && (!pilihan10.equals("Y") && !pilihan10.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan10.equals("y") && !pilihan10.equals("n"))  && (!pilihan10.equals("Y") && !pilihan10.equals("N")));
                        Matrix inp7 = new Matrix();
                        if (pilihan10.equals("y") || pilihan10.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename7 = myobj27.nextLine();
                            inp7 = IO.inputMatrixFile(filename7);
                        } else {
                            int baris,kolom;
                            System.out.println("Masukkan ukuran matriks");
                            System.out.print("Masukkan jumlah baris : ");
                            baris = myobj.nextInt();
                            System.out.print("Masukkan jumlah kolom : ");
                            kolom = myobj.nextInt();
                            inp7.IsiMatriks(baris, kolom);
                        }
                        Matrix inverse = new Matrix();
                        System.out.print("\n");
                        System.out.println("Matriks balikan : ");
                        inverse = SPL_Balikan.INV_GaussJordan(inp7);
                        inverse.Display();
                        System.out.print("\n");
                        do {
                            System.out.print("output file? (y/n): ");
                            pilihan10 = myobj26.nextLine();
                            if ((!pilihan10.equals("y") && !pilihan10.equals("n"))  && (!pilihan10.equals("Y") && !pilihan10.equals("N"))) {
                                System.out.println("Pilihan tidak tersedia");
                            }
                        }while((!pilihan10.equals("y") && !pilihan10.equals("n"))  && (!pilihan10.equals("Y") && !pilihan10.equals("N")));
                        if (pilihan10.equals("y") || pilihan10.equals("Y")) {
                            System.out.println("Masukkan nama file : ");
                            filename7 = myobj27.nextLine();
                            IO.outputInversFile(filename7, inverse);
                        }
                        main();
                        break;
                    /* Metode Adjoin */
                    case 2:
                        break;
                    /* Kembali */
                    case 3:
                        main();
                        break;
                }
                break;
            /* Interpolasi Polinom */
            case 4 :
            String pilihan11,filename8;
            Scanner myobj28 = new Scanner(System.in);
            Scanner myobj29 = new Scanner(System.in);
            Scanner myobj30 = new Scanner(System.in);
            interpolationPolinom inp8 = new interpolationPolinom();
            do{
                System.out.print("input file? (y/n): ");
                pilihan11 = myobj28.nextLine();
                if ((!pilihan11.equals("y") && !pilihan11.equals("n"))  && (!pilihan11.equals("Y") && !pilihan11.equals("N"))) {
                    System.out.println("Pilihan tidak tersedia");
                }
            }
            while((!pilihan11.equals("y") && !pilihan11.equals("n"))  && (!pilihan11.equals("Y") && !pilihan11.equals("N")));
            double x;
            if (pilihan11.equals("y") || pilihan11.equals("Y")) {
                System.out.println("Masukkan nama file : ");
                filename8 = myobj28.nextLine();
                inp8.interpolasiInputFile(filename8);
                
            } else {
                inp8.interpolasiInput();
                }
                inp8.persamaanPolinom();
                System.out.print("\n");
                inp8.nilaiTaksir();
                
                do{
                    System.out.print("output file? (y/n): ");
                    pilihan11 = myobj30.nextLine();
                    if ((!pilihan11.equals("y") && !pilihan11.equals("n"))  && (!pilihan11.equals("Y") && !pilihan11.equals("N"))) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while((!pilihan11.equals("y") && !pilihan11.equals("n"))  && (!pilihan11.equals("Y") && !pilihan11.equals("N")));
                if (pilihan11.equals("y") || pilihan11.equals("Y")) {
                    System.out.println("Masukkan nama file : ");
                    filename8 = myobj28.nextLine();
                    inp8.interpolasioutputFile(filename8);
                }
                main();
                break;
            /* Interpolasi Bicubic */
            case 5 :
                String pilihan12,filename9;
                interpolationBicubic inp9 = new interpolationBicubic();
                Scanner myobj31 = new Scanner(System.in);
                Scanner myobj32 = new Scanner(System.in);
                do{
                    System.out.print("input file? (y/n): ");
                    pilihan12 = myobj31.nextLine();
                    if ((!pilihan12.equals("y") && !pilihan12.equals("n"))  && (!pilihan12.equals("Y") && !pilihan12.equals("N"))) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while((!pilihan12.equals("y") && !pilihan12.equals("n"))  && (!pilihan12.equals("Y") && !pilihan12.equals("N")));
                if (pilihan12.equals("y") || pilihan12.equals("Y")) {
                    System.out.println("Masukkan nama file : ");
                    filename9 = myobj31.nextLine();
                    inp9.inputMatrixFile(filename9);
                } else {
                    inp9.inputMatrix();
                }
                inp9.hasilBicubicInterpolasi();
                System.out.print("\n");
                do{
                    System.out.print("output file? (y/n): ");
                    pilihan12 = myobj32.nextLine();
                    if ((!pilihan12.equals("y") && !pilihan12.equals("n"))  && (!pilihan12.equals("Y") && !pilihan12.equals("N"))) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while((!pilihan12.equals("y") && !pilihan12.equals("n"))  && (!pilihan12.equals("Y") && !pilihan12.equals("N")));
                if (pilihan12.equals("y") || pilihan12.equals("Y")) {
                    System.out.println("Masukkan nama file : ");
                    filename9 = myobj32.nextLine();
                    inp9.outputMatrixFile(filename9);
                }
                main();
                break;
            /* Regresi Linier Berganda */
            case 6 :
                String pilihan13,filename10;
                Scanner myobj34 = new Scanner(System.in);
                Scanner myobj35 = new Scanner(System.in);
                Scanner myobj36 = new Scanner(System.in);
                do{
                    System.out.print("input file? (y/n): ");
                    pilihan13 = myobj34.nextLine();
                    if ((!pilihan13.equals("y") && !pilihan13.equals("n"))  && (!pilihan13.equals("Y") && !pilihan13.equals("N"))) {
                        System.out.println("Pilihan tidak tersedia");
                    }
                }while((!pilihan13.equals("y") && !pilihan13.equals("n"))  && (!pilihan13.equals("Y") && !pilihan13.equals("N")));
                
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