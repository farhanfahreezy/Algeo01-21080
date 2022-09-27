package lib.Solver;

import lib.Matrix.Matrix;

public class SPL_Balikan {

    // Menggunakan GaussJordan
    public static Matrix INV_GaussJordan(Matrix inverse){
        /*I.S. Matrix inverse terdefinisi dan isSquare()*/
        /*F.s. Matrix inverse sudah berubah menjadi inverse */

        // Kamus Lokal
        int i,j;

        // Membuat matrix augmented dari inverse
        Matrix inverse2 = new Matrix();
        Matrix inverse3 = new Matrix();
        Matrix.copyMatrix(inverse, inverse2);
        Matrix.copyMatrix(inverse, inverse3);
        inverse2.col*=2;
        for(i=0;i<inverse.row;i++){
            for(j=inverse.col;j<inverse2.col;j++){
                if(i==(j-inverse.col)){
                    inverse2.array[i][j]=1.0;
                } else{
                    inverse2.array[i][j]=0.0;
                }
            }
        }

        // Melakukan GaussJordan sehingga matrix indentitas berpindah ke kiri
        inverse2.Hasil_OBE();

        //inverse2.Display();

        // Mengcopy kembali hasil balikan ke Matrix inverse3
        for(i=0;i<inverse.row;i++){
            for(j=0;j<inverse.col;j++){
                inverse3.array[i][j]=inverse2.array[i][j+inverse.col];
            }
        }
        //inverse.Display();
        return inverse3;
    }

    // Menggunakan Ax=b
    public static Matrix Balikan_SPL(Matrix inverse){
        /*I.S. Matrix inverse terdefinisi dan isSquare()*/
        /*F.s. Matrix inverse sudah berubah menjadi inverse */

        // KAMUS LOKAL
        double det; 
        int i,j;
        int x,y;
        int m,n;
        int tanda;
        Matrix esrevni = new Matrix();

        // ALGORITMA
        det = Determinan.DET_Reduksi_Baris_Kofaktor(inverse);
        Matrix.copyMatrix(inverse, esrevni);

        if (inverse.row==2){
            esrevni.array[0][0]=inverse.array[1][1];
            esrevni.array[0][1]=(-1)*inverse.array[1][0];
            esrevni.array[1][0]=(-1)*inverse.array[0][1];
            esrevni.array[1][1]=inverse.array[0][0];
            for(i=0;i<esrevni.row;i++){
                esrevni.KaliMatriks(1/det, i);
            }
        } else{
            
            for(i=0;i<inverse.row;i++){
                if(i%2==0){
                    tanda = 1;
                } else{
                    tanda = -1;
                }
                for(j=0;j<inverse.row;j++){
                    
                    // Mengisi matrix kofaktor ke dalam adjoint
                    Matrix MatKof = new Matrix();
                    MatKof.row=inverse.row-1;
                    MatKof.col=inverse.row-1;

                    m = 0;
                    n = 0;
                    for(x=0;x<inverse.row;x++){
                        for(y=0;y<inverse.col;y++){
                            if(x!=i && y!=j){
                                
                                MatKof.array[m][n]=inverse.array[x][y];
                                if(n==MatKof.col-1){
                                    n=0;
                                    m++;
                                }else{
                                    n++;
                                }
                            }
                        }
                    }
                    esrevni.array[i][j]=tanda*(Determinan.DET_Reduksi_Baris_Kofaktor(MatKof));
                    tanda*=-1;
                }
            }
            Matrix.transpose(esrevni);
            for(i=0;i<esrevni.row;i++){
                esrevni.KaliMatriks(1/det, i);
            }
            
        }
        return esrevni;
    }

    // public static void main(String[] args){
    //     Matrix a = new Matrix();
    //     Matrix b = new Matrix();
    //     Matrix c = new Matrix();
    //     a.IsiMatriks();
    //     b = INV_GaussJordan(a);
    //     c = Balikan_SPL(a);
    //     System.out.println("Hasil sebelum inverse adalah :");
    //     a.Display();
    //     System.out.println("Hasil inverse adalah :");
    //     b.Display();
    //     System.out.println("Hasil inverse adalah :");
    //     c.Display();
    // }
}
