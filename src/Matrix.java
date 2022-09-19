class matrix {
    public double [][] array= new double[100][100] ;
    public int row;
    public int col;
}

public class Matrix {
    static int Jumlah(int a, int b){
        return a+b;
    }

    public static int checkzero(matrix m,int index){
        int res;
        boolean cek;
        cek=true;
        res=0;
        for(int i=0;i<m.col;i++){
            if(m.array[index][i]==0 && cek){
                res++;
            }
            else{
                cek=false;
            }
        }
        return res;
    }

    public static boolean isSquare(matrix m){
        return m.col==m.row;
    }
    public static boolean isSegitigaAtas(matrix m){
        boolean res;
        res=true;
        for(int i=0;i<m.row;i++){
            for(int j=0;j<i;j++){
                if(m.array[i][j]!=0){
                    res=false;
                }
            }
        }
        return res;
    }
    public static boolean isSegitigaBawah(matrix m){
        boolean res;
        res=true;
        for(int i=0;i<m.row;i++){
            for(int j=0;j<m.row-i-1;j++){
                if(m.array[i][m.row-j-1]!=0){
                    res=false;
                }
            }
        }
        return res;
    }
    public static matrix swapbaris(matrix m,int x,int y){
        for(int i=0;i<m.col;i++){
            double temp;
            temp=m.array[x][i];
            m.array[x][i]=m.array[y][i];
            m.array[y][i]=temp;
        }
        return m;
    }
    public static boolean eselon(matrix m){
        int nol;
        boolean res;
        res=true;
        nol=-1;
        for(int i=0;i<m.row;i++){
            // System.out.println(checkzero(m,i));
            if(checkzero(m,i)>nol){
                nol=checkzero(m,i);
            }
            else{
                res=false;
            }
        }
        return res;
    }
    public static boolean eselonr(matrix m){
        boolean res;
        res=true;
        if(eselon(m)){
            for(int i=0;i<m.row;i++){
                for(int j=0;j<m.col;j++){
                    if(m.array[i][j]!=0){
                        for(int k=i-1;k>=0;k--){
                            if(m.array[k][j]!=0){
                                res=false;
                            }
                        }
                    }
                }
            }
        }
        else{
            res=false;
        }
        return res;
    }
    public static void gauss(matrix m){
        int idx,res;
        double pengurang;
        idx=1;
        int [] nol = new int[10];
        res=1;
        while(!eselon(m) && idx<m.row){
            for(int i=0;i<m.row;i++){
                nol[i]=checkzero(m, i);
            }

            // sorting banyak nol
            for(int i=0;i<m.row;i++){
                for(int j=i+1;j<m.row;j++){
                    if(nol[i]>nol[j]){
                        int temp1;
                        temp1=nol[j];
                        nol[j]=nol[i];
                        nol[i]=temp1;

                        m=swapbaris(m,i,j);
                        res*=-1;
                        System.out.print("Tukar matriks\n");
                        display(m);
                        System.out.println();
                    }
                }
            }
            //mencari index pengurang
            int acuan=0;
            
            for(int i=0;i<m.col;i++){
                if(m.array[idx-1][i]!=0){
                    acuan=i;
                    break;
                }
            }
            System.out.printf("acuan %d %d\n",idx-1,acuan);
            // kurangi dengan index atasnya
            for(int i=idx;i<m.row;i++){
                pengurang=m.array[i][acuan]/m.array[idx-1][acuan];
                System.out.println(pengurang);
                for(int j=acuan;j<m.col;j++){
                    m.array[i][j]-=pengurang*m.array[idx-1][j];
                }
            }
            idx++;
            display(m);
            System.out.println();
        }
        for(int i=0;i<m.row;i++){
            res*=m.array[i][i];
        }
        System.out.printf("Hasil determinan %d\n",res);
    }
    static void display(matrix m){
        for(int i=0;i<m.row;i++){
            for(int j=0;j<m.col;j++){
                if(j==0){
                    System.out.printf("%f",m.array[i][j]);
                }
                else{
                    System.out.printf(" %f",m.array[i][j]);
                }
            }
            System.out.println();
        }
    }
}
