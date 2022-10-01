package lib.Solver;

import lib.Matrix.Matrix;

public class Determinan {
    public static double DET_Reduksi_Baris_Kofaktor(Matrix DetMat){
        // KAMUS LOKAL
        double det=0;
        int sum0,largest0,i,j,k,i0;
        int tanda = -1;
        // ini untuk sub-matrix
        int x,y;

        // ALGORITMA

        if(DetMat.row==1){          // 1x1
            det=DetMat.array[0][0];
        } else if(DetMat.row==2){   // 2x2
            det=(DetMat.array[0][0]*DetMat.array[1][1])-(DetMat.array[0][1]*DetMat.array[1][0]);
        } else{                     // 3x3
            largest0 = 0;
            i0 = 0;

            // mencari 0 terbanyak
            for(i=0;i<DetMat.row;i++){
                sum0 = 0;
                for(j=0;j<DetMat.col;j++){
                    if(DetMat.array[i][j]==0.0){
                        sum0++;
                    }
                }
                if(sum0>largest0){
                    largest0 = sum0;
                    i0 = i;
                }
            }

            // Tanda untuk +-nya
            if (i0%2==0){
                tanda = 1;
            }

            for(k=0;k<DetMat.row;k++){
                if(DetMat.array[i0][k]==0){
                    tanda*=-1;
                    continue;
                }else{
                    // Bikin matrix baru untuk kofaktornya
                    Matrix KofMat = new Matrix();
                    KofMat.row=(DetMat.row)-1;
                    KofMat.col=(DetMat.col)-1;

                    x=0;
                    y=0;
                    for(i=0;i<DetMat.row;i++){
                        for(j=0;j<DetMat.col;j++){
                            if(i==i0 || j==k){
                                continue;
                            }else{
                                KofMat.array[x][y]=DetMat.array[i][j];
                                if(y==KofMat.col-1){
                                    y=0;
                                    x++;
                                }else{
                                    y++;
                                }
                            }
                        }
                    }
                    det+=tanda*DetMat.array[i0][k]*DET_Reduksi_Baris_Kofaktor(KofMat);
                    tanda*=-1;


                }
            }
        }
        return det;
    }
    
    public static double DET_Gauss(Matrix DetMat){
        double det=1.0;
        int i;

        Matrix DetMatBerubah = new Matrix();

        Matrix.copyMatrix(DetMat, DetMatBerubah);

        DetMatBerubah.Hasil_OBE();
        
        for(i=0;i<DetMatBerubah.row;i++){
            det*=DetMatBerubah.array[i][i];
        }
        // System.out.println(det);
        // System.out.println(DetMat.peubahDeterminan);
        det = det/DetMatBerubah.peubahDeterminan;
        // System.out.println(det);

        return det;
    }
    
    public static void Hasil_INV(Matrix Axb){
        /* I.S. Matrix NxN+1 terdefinisi dengan bentuk Ax=b, baris = N , kolom = N+1 */
        /* F.S  Solusi dari x dengan metode x = A^-1 * b*/
        
        // KAMUS LOKAL
        int i,j;
        Matrix Ax = new Matrix();
        Ax.row = Axb.row;
        Ax.col = Axb.row;
        Matrix invAx = new Matrix();
        Matrix b = new Matrix();
        b.row = Axb.row;
        b.col = 1;
        Matrix hasil = new Matrix();
        hasil.row = Axb.row;
        hasil.col = 1;

        // ALGORITMA
        
        // isi Matrix Ax ukuran NxN
        for(i=0;i<Ax.row;i++){
            for(j=0;j<Ax.col;j++){
                Ax.array[i][j]=Axb.array[i][j];
            }
        }
        // isi Matrix b ukuran Nx1
        for(i=0;i<Ax.row;i++){
            b.array[i][0]=Axb.array[i][Axb.col-1];
        }
        // balikan dari Ax
        invAx = INV_GaussJordan(Ax);

        if(!invAx.isEmpty()){
            // hasil perkalian invAx dan b
            hasil = Matrix.KaliMatrix(invAx, b);
            for(i=0;i<hasil.row;i++){
                System.out.println("X"+(i+1)+": "+hasil.array[i][0]);
            }
        } else{
            System.out.println("Tidak ada penyelesaian");
        }
    }
    
    // public static void main(String[] args) {
    //     Matrix a = new Matrix();
    //     a.IsiMatriks();
    //     double determinan = DET_Reduksi_Baris_Kofaktor(a);
    //     double det2 = DET_Gauss(a);
    //     System.out.println("Hasil determinan1 adalah : " + determinan);
    //     System.out.println("Hasil determinan1 adalah : " + det2);
    // }
}
