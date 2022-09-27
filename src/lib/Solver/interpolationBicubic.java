package lib.Solver;
import java.util.Scanner;
import lib.Matrix.Matrix;
import lib.Solver.SPL_Balikan;

public class interpolationBicubic {
    Matrix matriksInput = new Matrix();
    Matrix matriks = new Matrix();
    double a,b;
    public void inputMatrix() {
        /*
         * Mengisi Matriks dan Nilai yang dicari dengan inputan user
         * I.S. Matriks terdefinisi
         * F.S. Matriks dan Nilai terisi dengan inputan user
         */
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriksInput.array[i][j] = input.nextDouble();
            }
        }
        a = input.nextDouble();
        b = input.nextDouble();
    }
    
    public void persamaanInterpolasi() {
        /*
         * Mengeluarkan persamaan interpolasi dari matriks yang telah diinputkan
         * I.S. Matriks terdefinisi
         * F.S. Persamaan interpolasi ditampilkan
         */
        
         //Mengisi matriks
        int col = 0;
        int row = 0;
        for (int y = -1 ; y<3 ;y++){
            for (int x = -1;x<3;x++){
                for (int j = 0;j<4;j++){
                    for (int i = 0;i<4;i++){
                        matriks.array[row][col]=Math.pow(x, i)*Math.pow(y, j);
                        col++;
                    }
                }
                col = 0;
                row++;
            }
        }
        matriks.col = 16;
        matriks.row = 16;
        matriks.Display();
        System.out.printf("--------------------------------------------------------------");
        //Ubah menjadi Matriks Inverse
        SPL_Balikan.Balikan(matriks);
        matriks.Display();
    }
        public static void main(String[] args) {
        interpolationBicubic interpolasi = new interpolationBicubic();
        interpolasi.persamaanInterpolasi();
        }
    }
