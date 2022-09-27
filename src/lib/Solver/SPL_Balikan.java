package lib.Solver;

import lib.Matrix.Matrix;

public class SPL_Balikan {

    public static void Balikan(Matrix inverse){
        /*I.S. Matrix inverse terdefinisi dan isSquare()*/
        /*F.s. Matrix inverse sudah berubah menjadi inverse */

        // Kamus Lokal
        int i,j;

        // Membuat matrix augmented dari inverse
        Matrix inverse2 = new Matrix();
        Matrix.copyMatrix(inverse, inverse2);
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
        SPL_GaussJordan.Jordan(inverse2);

        //inverse2.Display();

        // Mengcopy kembali hasil balikan ke Matrix inverse
        for(i=0;i<inverse.row;i++){
            for(j=0;j<inverse.col;j++){
                inverse.array[i][j]=inverse2.array[i][j+inverse.col];
            }
        }
        //inverse.Display();

    }

    // public static void main(String[] args){
    //     Matrix a = new Matrix();
    //     a.IsiMatriks();
    //     Balikan(a);
    //     System.out.println("Hasil inverse adalah :");
    //     a.Display();
    // }
}
