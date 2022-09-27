package lib.Matrix;
import java.util.Scanner;
public class Matrix {

    //Atribut
    public double [][] array= new double[100][100] ;
    public int row;
    public int col;

    // Method

    // Konstruktor
    public Matrix(){
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                this.array[i][j]=0;
            }
        }
    }
    // input matriks dengan n baris dan m kolom
    public void IsiMatriks(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Masukkan baris: ");
        int baris = scanner.nextInt();
        System.out.printf("Masukkan kolom: ");
        int kolom = scanner.nextInt();

        this.row=baris;
        this.col=kolom;

        for(int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){
                this.array[i][j]=scanner.nextInt();
            }
        }
        scanner.close();
    }
    // mengecek banyak nol pada indeks awal
    public int CheckZero(int index){
        int res;
        boolean cek;
        cek=true;
        res=0;
        for(int i=0;i<this.col;i++){
            if(this.array[index][i]==0.0 && cek){
                res++;
            }
            else{
                cek=false;
            }
        }
        return res;
    }

    //mengecek matriks persegi 
    public boolean isSquare(){
        return this.col==this.row;
    }

    //mengecek matriks segitiga atas
    public boolean isSegitigaAtas(){
        boolean res;
        res=true;
        for(int i=0;i<this.row;i++){
            for(int j=0;j<i;j++){
                if(this.array[i][j]!=0){
                    res=false;
                }
            }
        }
        return res;
    }

    // mengecek matriks segitiga bawah
    public boolean isSegitigaBawah(){
        boolean res;
        res=true;
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.row-i-1;j++){
                if(this.array[i][this.row-j-1]!=0){
                    res=false;
                }
            }
        }
        return res;
    }

    // menukar matriks indeks ke-x dengan matriks indeks ke-y
    public void SwapBaris(int x,int y){
        for(int i=0;i<this.col;i++){
            double temp;
            temp=this.array[x][i];
            this.array[x][i]=this.array[y][i];
            this.array[y][i]=temp;
        }
    }

    // mengecek matriks eselon
    public boolean Eselon(){
        int nol;
        boolean res;
        res=true;
        nol=-1;
        for(int i=0;i<this.row;i++){
            if(CheckZero(i)>nol){
                nol=CheckZero(i);
            }
            else{
                if(CheckZero(i)==nol){
                    if(CheckZero(i)!=this.col){
                        res=false;
                    }
                }
                else{
                    res=false;
                }
            }
        }
        return res;
    }

    // mengecek matriks eselon reduksi
    public boolean EselonR(){
        boolean res;
        res=true;
        if(Eselon()){
            for(int i=0;i<this.row;i++){
                for(int j=0;j<this.col;j++){
                    if(this.array[i][j]!=0){
                        for(int k=i-1;k>=0;k--){
                            if(this.array[k][j]!=0){
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

    // menampilkan matriks
    public void Display(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(j==0){
                    System.out.printf("%.2f",this.array[i][j]);
                }
                else{
                    System.out.printf(" %.2f",this.array[i][j]);
                }
            }
            System.out.println();
        }
    }

    // mengecek pada matriks terdapat solusi atau tidak
    public boolean CheckSolution(){
        boolean res=true;
        for(int i=0;i<this.row;i++){
            if(CheckZero(i)==this.col-1){
                res=false;
            }
        }
        return res;
    }

    // mengalikan seluruh baris pada matriks indeks ke-index dengan pengali
    public void KaliMatriks(double pengali,int index){
        for(int i=0;i<=this.col;i++){
            if(this.array[index][i]!=0){
                this.array[index][i]*=pengali;
            }
        }
    }

    // mengurangi seluruh baris pada matriks indeks ke-idx1 dengan matriks pada baris ke-idx2 dikali dengan pengali
    public void KurangmMatriks(int idx1,int idx2,double pengali){
        for(int i=0;i<=this.col;i++){
            if(this.array[idx2][i]!=0){
                this.array[idx1][i]=this.array[idx1][i]-pengali*this.array[idx2][i];
            }
        }
    }


    public void Hasil_OBE(){
        int idx;
        double pengurang;
        idx=1;
        int [] nol = new int[10];
        while(!Eselon() || idx<this.row){
            for(int i=0;i<this.row;i++){
                nol[i]=CheckZero(i);
            }

            // sorting banyak nol
            for(int i=0;i<this.row;i++){
                for(int j=i+1;j<this.row;j++){
                    if(nol[i]>nol[j]){
                        int temp1;
                        temp1=nol[j];
                        nol[j]=nol[i];
                        nol[i]=temp1;

                        SwapBaris(i, j);
                    }
                }
            }
            // menjadikan 1
            boolean cek=true;
            for(int j=0;j<this.col;j++){
                if(this.array[idx-1][j]!=0 && cek){
                    cek=false;
                    if(this.array[idx-1][j]!=1){
                        KaliMatriks(1/this.array[idx-1][j], idx-1);
                    }
                }
            }
            //mencari index pengurang
            int acuan=-1;
            
            for(int i=0;i<this.col;i++){
                if(this.array[idx-1][i]!=0.0){
                    acuan=i;
                    break;
                }
            }

            // kurangi dengan index atasnya
            if(acuan!=-1){
                for(int i=idx;i<this.row;i++){
                    pengurang=this.array[i][acuan]/this.array[idx-1][acuan];
                    if(pengurang!=0.0){
                        for(int j=acuan;j<this.col;j++){
                            this.array[i][j]-=pengurang*this.array[idx-1][j];
                        }
                        
                    }
                }
            }
            

            // menjadikan index awal menjadi 1
            
            idx++;            
        }
        //menjadikan 1
        boolean cek2=true;
        for(int j=0;j<this.col;j++){
            if(this.array[idx-1][j]!=0 && cek2){
                cek2=false;
                if(this.array[idx-1][j]!=1){
                    KaliMatriks(1/this.array[idx-1][j], idx-1);
                }
            }
        }

        boolean [] sol = new boolean[100];
        for(int i=0;i<this.row;i++){
            boolean cek=true;
            for(int j=0;j<this.col-1;j++){
                if(this.array[i][j]!=0 && cek){
                    sol[j]=true;
                    cek=false;
                }
            }
        }
        
        int sumsol;
        sumsol=0;
        for(int i=0;i<this.col-1;i++){
            if(sol[i]){
                sumsol++;
            }
        }
        if(CheckSolution()){
            for(int i=this.row-1;i>=0;i--){
                boolean cek=true;
                for(int j=0;j<=this.col;j++){
                    // sudah ketemu index pengurang
                    if(this.array[i][j]!=0 && cek){
                        cek=false;
                        for(int k=i-1;k>=0;k--){
                            if(this.array[k][j]!=0){
                                KurangmMatriks(k, i, this.array[k][j]);
                            }
                        }
                    }
                }
            }            
        }
    }
    public float sum1(int col1){
        float sum;
        sum=0;
        for(int i=0;i<this.row;i++){
            sum+=this.array[i][col1];
        }
        return sum;
    }
    public float sum2(int col1,int col2){
        float sum;
        sum=0;
        for(int i=0;i<this.row;i++){
            sum+=this.array[i][col1]*this.array[i][col2];
        }
        return sum;
    }
    public void Regresi_Linear_Berganda(){
        float[][] arrayl = new float[1000][1000];
        int a;
        a=this.row;

        for(int i=0;i<this.col;i++){
            for(int j=0;j<this.col+1;j++){
                if(i==0){
                    if(j==0){
                        arrayl[i][j]=a;
                    }
                    else{
                        arrayl[i][j]=sum1(j-1);
                    }
                }
                else{
                    if(j==0){
                        arrayl[i][j]=sum1(i-1);
                    }
                    else{
                        arrayl[i][j]=sum2(i-1,j-1);
                    }
                }
            }
        }
        //merubah matriks
        this.row=this.col;
        this.col=this.col+1;

        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                this.array[i][j]=arrayl[i][j];
            }
        }
        Hasil_OBE();
        
        Display();        
        
        //print solusi

        System.out.printf("Y = ");
        for(int i=0;i<this.row;i++){
            if(this.array[i][this.col-1]!=0){
                if(i==0){
                    System.out.printf("%.3f ",this.array[i][this.col-1]);
                }
                else{
                    if(this.array[i][this.col-1]>0){
                        System.out.printf("+ %.3f*X%d ",this.array[i][this.col-1],i);
                    }
                    else{
                        System.out.printf("- %.3f*X%d ",-this.array[i][this.col-1],i);
                        
                    }
                }
            }
        }
    }

    public static void copyMatrix(Matrix Min, Matrix Mout){
        Mout.row = Min.row;
        Mout.col = Min.col;
        int i,j;
        for(i=0;i<Min.row;i++){
            for(j=0;j<Min.col;j++){
                Mout.array[i][j]=Min.array[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Matrix a = new Matrix();
        a.IsiMatriks();
        // a.SPL_GaussJordan();
        // a.Display();
        a.SPL_Gauss();
    }
}
