package lib.Solver;

import java.util.Scanner;

import lib.Matrix.Matrix;
import lib.Utils.IO;

public class Determinan {
    public static double DET_Reduksi_Baris_Kofaktor(Matrix DetMat){
        // KAMUS LOKAL
        double det=0;
        int sum0,largest0,i,j,k,i0;
        int tanda = -1;
        // ini untuk sub-matrix
        int x,y;

        // ALGORITMA

        if(DetMat.row==1){          // 1x1
            det=DetMat.array[0][0];
        } else if(DetMat.row==2){   // 2x2
            det=(DetMat.array[0][0]*DetMat.array[1][1])-(DetMat.array[0][1]*DetMat.array[1][0]);
        } else{                     // 3x3
            largest0 = 0;
            i0 = 0;

            // mencari 0 terbanyak
            for(i=0;i<DetMat.row;i++){
                sum0 = 0;
                for(j=0;j<DetMat.col;j++){
                    if(DetMat.array[i][j]==0.0){
                        sum0++;
                    }
                }
                if(sum0>largest0){
                    largest0 = sum0;
                    i0 = i;
                }
            }

            // Tanda untuk +-nya
            if (i0%2==0){
                tanda = 1;
            }

            for(k=0;k<DetMat.row;k++){
                if(DetMat.array[i0][k]==0){
                    tanda*=-1;
                    continue;
                }else{
                    // Bikin matrix baru untuk kofaktornya
                    Matrix KofMat = new Matrix();
                    KofMat.row=(DetMat.row)-1;
                    KofMat.col=(DetMat.col)-1;

                    x=0;
                    y=0;
                    for(i=0;i<DetMat.row;i++){
                        for(j=0;j<DetMat.col;j++){
                            if(i==i0 || j==k){
                                continue;
                            }else{
                                KofMat.array[x][y]=DetMat.array[i][j];
                                if(y==KofMat.col-1){
                                    y=0;
                                    x++;
                                }else{
                                    y++;
                                }
                            }
                        }
                    }
                    det+=tanda*DetMat.array[i0][k]*DET_Reduksi_Baris_Kofaktor(KofMat);
                    tanda*=-1;


                }
            }
        }
        return det;
    }
    
    public static double DET_Gauss(Matrix DetMat){
        double det=1.0;
        int i;

        Matrix DetMatBerubah = new Matrix();

        Matrix.copyMatrix(DetMat, DetMatBerubah);

        DetMatBerubah.Hasil_OBE();
        
        for(i=0;i<DetMatBerubah.row;i++){
            det*=DetMatBerubah.array[i][i];
        }
        // System.out.println(det);
        // System.out.println(DetMat.peubahDeterminan);
        det = det/DetMatBerubah.peubahDeterminan;
        // System.out.println(det);

        return det;
    }
    public static void mainKofaktor() {
        Scanner input = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String file ;
        String[] solusi;
        Matrix solver = new Matrix();
        do{
            System.out.print("Input file (y/n) : ");
            file = input.nextLine();
        }while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            solver = IO.inputMatrixFile(filename);
            }
        else{
            System.out.print("Masukkan jumlah n: ");
            int n = input2.nextInt();
            solver.IsiMatriks(n, n);
            }
            double det = DET_Reduksi_Baris_Kofaktor(solver);
            System.out.println("Determinan dengan metode reduksi baris kofaktor: "+det);
        do{
            System.out.print("Simpan solusi ke file (y/n) : ");
            file = input.nextLine();
        }
        while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            IO.outputDeterminanFile(filename, det);
        }
    }
    public static void mainGauss() {
        Scanner input = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String file ;
        String[] solusi;
        Matrix solver = new Matrix();
        do{
            System.out.print("Input file (y/n) : ");
            file = input.nextLine();
        }while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            solver = IO.inputMatrixFile(filename);
            }
        else{
            System.out.print("Masukkan jumlah n: ");
            int n = input2.nextInt();
            solver.IsiMatriks(n, n);
            }
            double det = DET_Gauss(solver);
            System.out.println("Determinan dengan metode Gauss: "+det);
        do{
            System.out.print("Simpan solusi ke file (y/n) : ");
            file = input.nextLine();
        }
        while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            IO.outputDeterminanFile(filename, det);
        }
    }    
    // public static void main(String[] args) {
    //     Matrix a = new Matrix();
    //     a.IsiMatriks();
    //     double determinan = DET_Reduksi_Baris_Kofaktor(a);
    //     double det2 = DET_Gauss(a);
    //     System.out.println("Hasil determinan1 adalah : " + determinan);
    //     System.out.println("Hasil determinan1 adalah : " + det2);
    // }
}
