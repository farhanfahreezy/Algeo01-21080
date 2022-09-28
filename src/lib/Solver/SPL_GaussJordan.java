package lib.Solver;

import lib.Matrix.Matrix;

public class SPL_GaussJordan {
    public static void Jordan(Matrix solver){
        int idx;
        double pengurang;
        idx=1;
        int [] nol = new int[5000];
        
        while(!solver.Eselon() && idx<solver.row){
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
                        solver.mintoZero();
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
                        solver.KurangmMatriks(i, idx-1, pengurang);
                        // for(int j=acuan;j<solver.col;j++){
                        //     if(solver.array[i][j]!=0){
                        //         solver.array[i][j]=solver.array[i][j]-pengurang*solver.array[idx-1][j];
                        //     }
                        //     // solver.array[i][j]-=pengurang*solver.array[idx-1][j];
                        // }
                        solver.mintoZero();
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
                    solver.mintoZero();
                    solver.Display();
                    System.out.println();
                }
            }
        }

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
                                solver.mintoZero();
                                solver.Display();
                                System.out.println();
                            }
                        }
                    }
                }
            }
            // Display();
            solver.DisplaySolution();
        }
        

    }
    public static void main(String[] args) {
        Matrix a = new Matrix();
        a.IsiMatriks(9,16);
        // a.Hasil_OBE();
        SPL_GaussJordan.Jordan(a);
        // System.out.println();
        // a.Display();
    }
}
