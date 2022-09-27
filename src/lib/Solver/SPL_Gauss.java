package lib.Solver;

import lib.Matrix.Matrix;

/**
 * SPL_Gauss
 */
public class SPL_Gauss {
    public static void Gauss(Matrix solver){
        int idx;
        double pengurang;
        idx=1;
        int [] nol = new int[1000];
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
                    if(pengurang!=0){
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
                        for(int j=acuan;j<solver.col;j++){
                            solver.array[i][j]-=pengurang*solver.array[idx-1][j];
                        }
                        solver.Display();
                        System.out.println();
                        
                    }
                }
            }
            idx++;            
        }
        System.out.println("Diperoleh hasil matriks :\n");
        solver.Display();

        

        boolean [] sol = new boolean[1000];
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
            String [] Solution = new String[100];
            String [] PS = new String[100];
            for(int i=0;i<100;i++){
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
                                        Solution[i]+="+"+String.format("%.2f",solver.array[i][k])+'*'+PS[k]+' '; // aman
                                    }
                                }
                                else if(solver.array[i][k]<0){
                                    if(solver.array[i][k]==-1.0){
                                        Solution[i]+="- "+PS[k]+' '; 
                                    }
                                    else{
                                        Solution[i]+="-"+String.format("%.2f",-solver.array[i][k])+'*'+PS[k]+' ';
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

            for(int i=0;i<100;i++){
                PS[i]="";
                Solution[i]="";
            }
            // System.out.printf("terdapat %d solusi\n",sumsol);
            for(int i=0;i<solver.col-1;i++){
                PS[i]='X'+Integer.toString(i+1);
            }
            // solusi x1,x2,x3,...
            System.out.println("ngurangi jordan\n");
            
            for(int i=0;i<100;i++){
                PS[i]="";
                Solution[i]="";
            }
            // System.out.printf("terdapat %d solusi\n",sumsol);
            for(int i=0;i<solver.col-1;i++){
                PS[i]='X'+Integer.toString(i+1);
                if(!sol[i]){
                    // System.out.printf("%d gaada solusi\n",i+1);
                    Solution[i]+='X'+Integer.toString(i+1);
                    // System.out.println(Solution[i]);
                }
            }
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
            // Display();
            for(int i=0;i<solver.row;i++){
                boolean cek=true;
                for(int j=0;j<solver.col-1;j++){
                    if(solver.array[i][j]!=0 && cek){
                        cek=false;
                        int banyaksolusi=0;
                        for(int k=j+1;k<solver.col-1;k++){
                            if(solver.array[i][k]!=0){
                                if(banyaksolusi==0){
                                    if(solver.array[i][k]==-1){
                                        Solution[j]+=PS[k]+' ';
                                    }
                                    else if(solver.array[i][k]==1){
                                        Solution[j]+='-'+PS[k]+' ';
                                    }
                                    else{
                                        Solution[j]+=String.format("%.2f",-1*solver.array[i][k]/solver.array[i][j])+'*'+PS[k]+' ';
                                    }
                                }
                                else{
                                    if(solver.array[i][k]<0){
                                        Solution[j]+="+ "+String.format("%.2f",-1*solver.array[i][k]/solver.array[i][j])+'*'+PS[k]+' ';
                                    }
                                    else{
                                        Solution[j]+=String.format("%.2f",-1*solver.array[i][k]/solver.array[i][j])+'*'+PS[k]+' ';
                                    }
                                }
                                banyaksolusi++;
                            }
                        }
                        if(solver.array[i][solver.col-1]==0 && banyaksolusi==0){
                            Solution[j]+=String.format("0.00");
                        }
                        else if(solver.array[i][solver.col-1]>0){
                            if(banyaksolusi==0){
                                Solution[j]+=String.format("%f",solver.array[i][solver.col-1]/solver.array[i][j]);

                            }
                            else{
                                Solution[j]+=String.format("+ %f",solver.array[i][solver.col-1]/solver.array[i][j]);

                            }
                        }
                        else{
                            Solution[j]+=String.format("- %f",-solver.array[i][solver.col-1]/solver.array[i][j]);
                        }
                    }
                }
            }
            for(int i=0;i<solver.col-1;i++){
                System.out.printf("X%d = %s\n",i+1,Solution[i]);
            }
            if(sumsol==solver.col-1){
                System.out.println("Solusi unik\n");
            }
            else{
                System.out.println("Solusi banyak\n");
            }
        }
    }
    public static void main(String[] args) {
        Matrix a = new Matrix();
        a.IsiMatriks();
        SPL_Gauss.Gauss(a);
    }
    
}