package lib.Solver;

import java.util.*;

import lib.Matrix.Matrix;
import lib.Utils.IO;

/**
 * SPL_Gauss
 */
public class SPL_Gauss {

    public static void Gauss(Matrix solver){
        int idx;
        double pengurang;
        idx=1;
        int [] nol = new int[5000];
        while(!solver.Eselon() || idx<solver.row){
            for(int i=0;i<solver.row;i++){
                nol[i]=solver.CheckZero(i);
            }

            // sorting banyak nol
            for(int i=0;i<solver.row;i++){
                for(int j=i+1;j<solver.row;j++){
                    if(nol[i]>nol[j]){
                        int temp1;
                        temp1=nol[j];
                        nol[j]=nol[i];
                        nol[i]=temp1;

                        solver.SwapBaris(i, j);
                        solver.mintoZero();
                        System.out.printf("Tukar matriks indeks ke-%d dengan indeks ke-%d\n",i+1,j+1);
                        solver.Display();
                        System.out.println();
                    }
                }
            }
            //mencari index pengurang
            int acuan=-1;
            
            for(int i=0;i<solver.col;i++){
                if(solver.array[idx-1][i]!=0){
                    acuan=i;
                    break;
                }
            }

            // kurangi dengan index atasnya
            if(acuan!=-1){
                for(int i=idx;i<solver.row;i++){
                    pengurang=solver.array[i][acuan]/solver.array[idx-1][acuan];
                    if(pengurang!=0.0){
                        if(pengurang>0.0){
                            if(solver.array[i][acuan]==solver.array[idx-1][acuan]){
    
                                System.out.printf("R%d -> R%d - R%d\n",i+1,i+1,idx);
                            }
                            else{
                                System.out.printf("R%d -> R%d - %.2f*R%d\n",i+1,i+1,pengurang,idx);
                            }
                        }
                        else{
                            if(solver.array[idx-1][acuan]==solver.array[i][acuan]){
    
                                System.out.printf("R%d -> R%d + R%d\n",i+1,i+1,idx);
                            }
                            else{
                                System.out.printf("R%d -> R%d + %.2f*R%d\n",i+1,i+1,-pengurang,idx);
                            }
                        }
                        // System.out.printf("R%d -> R%d + %.2f*R%d\n",i+1,i+1,pengurang,idx);
                        solver.KurangmMatriks(i, idx-1, pengurang);
                        solver.mintoZero();
                        solver.Display();
                        System.out.println();
                        
                    }
                }
            }
            idx++;            
        }
        System.out.println("Diperoleh hasil matriks :\n");
        solver.mintoZero();
        solver.Display();

        

        boolean [] sol = new boolean[5000];
        for(int i=0;i<solver.row;i++){
            boolean cek=true;
            for(int j=0;j<solver.col-1;j++){
                if(solver.array[i][j]!=0 && cek){
                    // System.out.printf("%d %d\n",i,j);
                    sol[j]=true;
                    cek=false;
                }
            }
        }
        
        int sumsol;
        sumsol=0;
        for(int i=0;i<solver.col-1;i++){
            if(sol[i]){
                sumsol++;
            }
        }
        if(!solver.CheckSolution()){
            System.out.println("Solusi tidak ada\n");
        }
        else{
            String [] Solution = new String[5000];
            String [] PS = new String[5000];
            for(int i=0;i<5000;i++){
                PS[i]="";
                Solution[i]="";
            }
            // System.out.printf("terdapat %d solusi\n",sumsol);
            for(int i=0;i<solver.col-1;i++){
                PS[i]='X'+Integer.toString(i+1);
            }


            // Solusi pertama
            for(int i=0;i<solver.row;i++){
                boolean temp=true;
                for(int j=0;j<solver.col;j++){
                    
                    if(solver.array[i][j]!=0 && temp){
                        int banyaksolusi=0;
                        temp=false;
                        for(int k=j;k<solver.col-1;k++){
                            if(banyaksolusi==0){
                                if(solver.array[i][k]==1.0 || solver.array[i][k]==-1.0){
                                    Solution[i]+=PS[k]+' '; // aman
                                }
                                else if(solver.array[i][k]!=0){
                                    Solution[i]+=String.format("%.2f",solver.array[i][k])+'*'+PS[k]+' '; // aman
                                }
                            }
                            else{
                                if(solver.array[i][k]>0){
                                    if(solver.array[i][k]==1.0){
                                        Solution[i]+="+ "+PS[k]+' '; // aman
                                    }
                                    else{
                                        Solution[i]+="+ "+String.format("%.2f",solver.array[i][k])+'*'+PS[k]+' '; // aman
                                    }
                                }
                                else if(solver.array[i][k]<0){
                                    if(solver.array[i][k]==-1.0){
                                        Solution[i]+="- "+PS[k]+' '; 
                                    }
                                    else{
                                        Solution[i]+="- "+String.format("%.2f",-solver.array[i][k])+'*'+PS[k]+' ';
                                    }
                                }
                                
                            }
                            
                            banyaksolusi++;
                        }
                    }
                }
                Solution[i]+=String.format("= %.2f",solver.array[i][solver.col-1]);
            }
            System.out.println();
            System.out.println("Hasil persamaan Gauss diperoleh sebagai berikut\n");
            for(int i=0;i<solver.col-1;i++){
                if(solver.CheckZero(i)!=solver.col){
                    System.out.printf("%s\n",Solution[i]);
                }
            }

            
            // solusi x1,x2,x3,...
            // System.out.println("ngurangi jordan\n");
            
            
            for(int i=solver.row-1;i>=0;i--){
                boolean cek=true;
                for(int j=0;j<=solver.col;j++){
                    // sudah ketemu index pengurang
                    if(solver.array[i][j]!=0 && cek){
                        cek=false;
                        solver.KaliMatriks(1/solver.array[i][j],i);
                        for(int k=i-1;k>=0;k--){
                            if(solver.array[k][j]!=0){
                                
                                solver.KurangmMatriks(k, i, solver.array[k][j]);
                                // Display();
                                // System.out.println();
                            }
                        }
                    }
                }
            }
            solver.DisplaySolution();
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
            Gauss(solver);
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
}