package lib.Solver;

import lib.Matrix.Matrix;

public class SPL_Balikan {

    // Menggunakan GaussJordan
    public static Matrix INV_GaussJordan(Matrix inverse){
        /*I.S. Matrix inverse terdefinisi dan isSquare()*/
        /*F.S. Matrix inverse sudah berubah menjadi inverse */
        /*F.S. Jika matrix tidak memiliki balikan, akan diberikan matrix kosong*/

        // Kamus Lokal
        int i,j;

        // Membuat matrix augmented dari inverse
        Matrix inverse2 = new Matrix();
        Matrix inverse3 = new Matrix();

        Matrix.copyMatrix(inverse, inverse2);

        inverse3.row = inverse.row;
        inverse3.col = inverse.col;
        inverse2.col*=2;

        if(Determinan.DET_Gauss(inverse)!=0.0){
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


            // Mengcopy kembali hasil balikan ke Matrix inverse3
            for(i=0;i<inverse.row;i++){
                for(j=0;j<inverse.col;j++){
                    inverse3.array[i][j]=inverse2.array[i][j+inverse.col];
                }
            }
        }
        inverse3.mintoZero();
        return inverse3;
    }

    // Menggunakan Ax=b
    public static Matrix Balikan_SPL(Matrix inverse){
        /*I.S. Matrix inverse terdefinisi dan isSquare()*/
        /*F.s. Matrix inverse sudah berubah menjadi inverse */
        /*F.S. Jika matrix tidak memiliki balikan, akan diberikan matrix kosong*/

        // KAMUS LOKAL
        double det; 
        int i,j;
        int x,y;
        int m,n;
        int tanda;
        Matrix esrevni = new Matrix();

        // ALGORITMA
        det = Determinan.DET_Gauss(inverse);
        esrevni.row = inverse.row;
        esrevni.col = inverse.col;

        if(det!=0.0){
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
                        esrevni.array[i][j]=tanda*(Determinan.DET_Gauss(MatKof));
                        tanda*=-1;
                    }
                }
                Matrix.transpose(esrevni);
                for(i=0;i<esrevni.row;i++){
                    esrevni.KaliMatriks(1/det, i);
                }
                
            }
        }
        esrevni.mintoZero();
        return esrevni;
    }
    public static void main() {
        
        
    }
    // public static void main(String[] args){
    //     Matrix a = new Matrix();
    //     Matrix b = new Matrix();
    //     Matrix c = new Matrix();
    //     int ukuran = 16;
    //     a.IsiMatriks(ukuran, ukuran);
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
