package lib.Solver;

import java.util.Scanner;

import lib.Matrix.Matrix;
import lib.Utils.IO;

public class SPL_Cramer {
    /*I.S. Matrik MatCram sudah terisi berukuran NxN+1 */
    /*F.S. Solusi SPL */
    public static void Cramer(Matrix MatCram){
        // KAMUS LOKAL
        int i,j;
        double detCram,detCramXi;
        double[] solusi = new double[MatCram.row];

            // Untuk matrix NxN
        Matrix MatDet = new Matrix();
        MatDet.row = MatCram.row;
        MatDet.col = MatCram.col-1;

            // Untuk matrix NxN yang diisi b (Ax=b)
        Matrix MatDetXi = new Matrix();
        MatDetXi.row = MatDet.row;
        MatDetXi.col = MatDet.col;

        // ALGORITMA

        if(MatCram.col!=MatCram.row+1){
            System.out.println("Matrix masukan salah!");
        }else{
            // Buat Matrix ukuran NxN dari MatCram ke MatDet
            for(i=0;i<MatCram.row;i++){
                for(j=0;j<MatCram.row;j++){
                    MatDet.array[i][j]=MatCram.array[i][j];
                }
            }

            detCram = Determinan.DET_Reduksi_Baris_Kofaktor(MatDet);
            

            // Mengisi masing-masing nilai
            for(j=0;j<MatDet.row;j++){
                Matrix.copyMatrix(MatDet, MatDetXi);
                for(i=0;i<MatDet.row;i++){
                    MatDetXi.array[i][j]=MatCram.array[i][MatCram.row];
                }

                detCramXi = Determinan.DET_Reduksi_Baris_Kofaktor(MatDetXi);
                solusi[j] = detCramXi/detCram;

            }

            // Mengeluarkan hasil perhitungan
            System.out.println("Hasil Operasi Perhitungan Cramer adalah: ");
            for(i=0;i<solusi.length;i++){
                System.out.println("X-"+(i+1)+": "+String.format("%.2f",solusi[i]));
            }
        }
        
    }
    public static void main() {
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
            System.out.print("Masukkan jumlah m: ");
            int m = input3.nextInt();
            System.out.print("Masukkan jumlah n: ");
            int n = input2.nextInt();
            solver.IsiMatriks(m, n);
            }
            Cramer(solver);
            solusi = Matrix.SolusiSPL(solver);
        do{
            System.out.print("Simpan solusi ke file (y/n) : ");
            file = input.nextLine();
        }
        while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            IO.outputOBEFile(filename, solusi);
        }
    }    
    public static void main(String[] args) {
        Matrix a = new Matrix();
        a.IsiMatriks(3,4);
        Cramer(a);
    }
}
