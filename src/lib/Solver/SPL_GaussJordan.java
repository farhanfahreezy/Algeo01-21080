package lib.Solver;

import lib.Matrix.Matrix;

public class SPL_GaussJordan {
    public static void Jordan(Matrix solver){
        int idx;
        double pengurang;
        idx=1;
        int [] nol = new int[10];
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
            // menjadikan 1
            boolean cek=true;
            for(int j=0;j<solver.col;j++){
                if(solver.array[idx-1][j]!=0 && cek){
                    cek=false;
                    if(solver.array[idx-1][j]!=1){
                        if(solver.array[idx-1][j]>0){
                            System.out.printf("R%d -> R%d/%.2f\n",idx,idx,solver.array[idx-1][j]);
                        }
                        else{
                            System.out.printf("R%d -> -R%d/%.2f\n",idx,idx,-solver.array[idx-1][j]);

                        }
                        solver.KaliMatriks(1/solver.array[idx-1][j], idx-1);
                        solver.Display();
                        System.out.println();
                    }
                }
            }
            //mencari index pengurang
            int acuan=-1;
            
            for(int i=0;i<solver.col;i++){
                if(solver.array[idx-1][i]!=0.0){
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
                        for(int j=acuan;j<solver.col;j++){
                            solver.array[i][j]-=pengurang*solver.array[idx-1][j];
                        }
                        solver.Display();
                        System.out.println();
                        
                    }
                }
            }
            

            // menjadikan index awal menjadi 1
            
            idx++;            
        }
        //menjadikan 1
        boolean cek2=true;
        for(int j=0;j<solver.col;j++){
            if(solver.array[idx-1][j]!=0 && cek2){
                cek2=false;
                if(solver.array[idx-1][j]!=1){
                    if(solver.array[idx-1][j]>0){
                        System.out.printf("R%d -> R%d/%.2f\n",idx,idx,solver.array[idx-1][j]);
                    }
                    else{
                        System.out.printf("R%d -> -R%d/%.2f\n",idx,idx,-solver.array[idx-1][j]);

                    }
                    solver.KaliMatriks(1/solver.array[idx-1][j], idx-1);
                    solver.Display();
                    System.out.println();
                }
            }
        }

        boolean [] sol = new boolean[100];
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
                if(!sol[i]){
                    // System.out.printf("%d gaada solusi\n",i+1);
                    Solution[i]+='X'+Integer.toString(i+1);
                    // System.out.println(Solution[i]);
                }
            }

            System.out.println("ngurangi jordan\n");
            for(int i=solver.row-1;i>=0;i--){
                boolean cek=true;
                for(int j=0;j<=solver.col;j++){
                    // sudah ketemu index pengurang
                    if(solver.array[i][j]!=0 && cek){
                        cek=false;
                        for(int k=i-1;k>=0;k--){
                            if(solver.array[k][j]!=0){
                                if(solver.array[k][j]>0){
                                    if(solver.array[k][j]==-solver.array[i][j]){
            
                                        System.out.printf("R%d -> R%d - R%d\n",k+1,k+1,i+1);
                                    }
                                    else{
                                        System.out.printf("R%d -> R%d - %.2f*R%d\n",k+1,k+1,solver.array[k][j],i+1);
                                    }
                                }
                                else{
                                    if(solver.array[k][j]==-solver.array[i][j]){
            
                                        System.out.printf("R%d -> R%d + R%d\n",k+1,k+1,i+1);
                                    }
                                    else{
                                        System.out.printf("R%d -> R%d + %.2f*R%d\n",k+1,k+1,-solver.array[k][j],i+1);
                                    }
                                }
                                solver.KurangmMatriks(k, i, solver.array[k][j]);
                                solver.Display();
                                System.out.println();
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
                        if(solver.array[i][solver.col-1]==0){
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
}
