import java.util.Scanner;
class matriks {

    //Atribut
    public double [][] array= new double[100][100] ;
    public int row;
    public int col;

    // Method

    // Konstruktor
    matriks(){
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                this.array[i][j]=0;
            }
        }
    }
    // input matriks dengan n baris dan m kolom
    void IsiMatriks(){
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
    }
    // mengecek banyak nol pada indeks awal
    int CheckZero(int index){
        int res;
        boolean cek;
        cek=true;
        res=0;
        for(int i=0;i<this.col;i++){
            if(this.array[index][i]==0 && cek){
                res++;
            }
            else{
                cek=false;
            }
        }
        return res;
    }

    //mengecek matriks persegi 
    boolean isSquare(){
        return this.col==this.row;
    }

    //mengecek matriks segitiga atas
    boolean isSegitigaAtas(){
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
    boolean isSegitigaBawah(){
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
    void SwapBaris(int x,int y){
        for(int i=0;i<this.col;i++){
            double temp;
            temp=this.array[x][i];
            this.array[x][i]=this.array[y][i];
            this.array[y][i]=temp;
        }
    }

    // mengecek matriks eselon
    boolean Eselon(){
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
    boolean EselonR(){
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
    void Display(){
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
    boolean CheckSolution(){
        boolean res=true;
        for(int i=0;i<this.row;i++){
            if(CheckZero(i)==this.col-1){
                res=false;
            }
        }
        return res;
    }

    // mengalikan seluruh baris pada matriks indeks ke-index dengan pengali
    void KaliMatriks(double pengali,int index){
        for(int i=0;i<=this.col;i++){
            this.array[index][i]*=pengali;
        }
    }

    // mengurangi seluruh baris pada matriks indeks ke-idx1 dengan matriks pada baris ke-idx2 dikali dengan pengali
    void KurangmMatriks(int idx1,int idx2,double pengali){
        for(int i=0;i<=this.col;i++){
            this.array[idx1][i]=this.array[idx1][i]-pengali*this.array[idx2][i];
        }
    }
}

public class driverMatrix {
    public static void main(String[] args) {
        matriks aa=new matriks();
        aa.IsiMatriks();
        System.out.println(aa.CheckZero(0));
        System.out.println(aa.isSquare());
        System.out.println(aa.isSegitigaAtas());
        System.out.println(aa.isSegitigaBawah());
        aa.SwapBaris(1, 2);
        aa.Display();
        System.out.println(aa.Eselon());
        System.out.println(aa.EselonR());
        System.out.println(aa.CheckSolution());

    }
    
}
