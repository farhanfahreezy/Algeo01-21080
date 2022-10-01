package lib.Solver;

import java.util.Scanner;

import lib.Matrix.Matrix;

public class RLB {
    Scanner input = new Scanner(System.in);
    public void RLB_Ganda(Matrix solver) {
        float[][] arrayl = new float[1000][1000];
        int a;
        a=solver.row;

        for(int i=0;i<solver.col;i++){
            for(int j=0;j<solver.col+1;j++){
                if(i==0){
                    if(j==0){
                        arrayl[i][j]=a;
                    }
                    else{
                        arrayl[i][j]=solver.sum1(j-1);
                    }
                }
                else{
                    if(j==0){
                        arrayl[i][j]=solver.sum1(i-1);
                    }
                    else{
                        arrayl[i][j]=solver.sum2(i-1,j-1);
                    }
                }
            }
        }
        //merubah matriks
        solver.row=solver.col;
        solver.col=solver.col+1;

        for(int i=0;i<solver.row;i++){
            for(int j=0;j<solver.col;j++){
                solver.array[i][j]=arrayl[i][j];
            }
        }
        solver.Hasil_OBE();
        System.out.println("Diperoleh hasil RLB Ganda");
        solver.Display();        
        
        //print solusi
        solver.mintoZero();
        System.out.printf("Y = ");
        for(int i=0;i<solver.row;i++){
            if(solver.array[i][solver.col-1]!=0){
                if(i==0){
                    System.out.printf("%.3f ",solver.array[i][solver.col-1]);
                }
                else{
                    if(solver.array[i][solver.col-1]>0){
                        System.out.printf("+ %.3f*X%d ",solver.array[i][solver.col-1],i);
                    }
                    else{
                        System.out.printf("- %.3f*X%d ",-solver.array[i][solver.col-1],i);
                        
                    }
                }
            }
        }
    }
    public String save(Matrix solver){
        String hasil = "Y = ";
        for(int i=0;i<solver.row;i++){
            if(solver.array[i][solver.col-1]!=0){
                if(i==0){
                    hasil+=String.format("%.3f ",solver.array[i][solver.col-1]);
                    // System.out.printf("%.3f ",solver.array[i][solver.col-1]);
                }
                else{
                    if(solver.array[i][solver.col-1]>0){
                        hasil+=String.format("+ %.3f*X%d ",solver.array[i][solver.col-1],i);
                        // System.out.printf("+ %.3f*X%d ",solver.array[i][solver.col-1],i);
                    }
                    else{
                        hasil+=String.format("- %.3f*X%d ",-solver.array[i][solver.col-1],i);
                        // System.out.printf("- %.3f*X%d ",-solver.array[i][solver.col-1],i);
                        
                    }
                }
            }
        }
        return hasil;       
    }
    public void Hasil(Matrix solver){
        Double hasil = 0.0;
        for(int i=1;i<solver.row;i++){
            System.out.printf("Masukkan nilai X%d",1+i);
            Double inp=input.nextDouble();
            hasil+=solver.array[i][solver.col-1]*inp;
        }
        System.out.printf("Y = %.3f",solver.array[0][solver.col-1]+hasil);
    }

    // public static void main(String[] args) {
    //     Matrix a = new Matrix();
    //     // Matrix b = new Matrix();
    //     a.IsiMatriks(20, 4);
    //     // b.transpose(a);
    //     RLB_Ganda(a);
    //     System.out.println();
    //     System.out.println(save(a));
    // }
}
