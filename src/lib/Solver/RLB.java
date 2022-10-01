package lib.Solver;

import lib.Matrix.Matrix;

public class RLB {
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
        
        solver.Display();        
        
        //print solusi

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
    
}
