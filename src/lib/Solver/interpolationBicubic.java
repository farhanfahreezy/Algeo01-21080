package lib.Solver;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import lib.Matrix.Matrix;
import lib.Solver.SPL_Balikan;

public class interpolationBicubic {
    Matrix matriksInput = new Matrix();
    Matrix matriks = new Matrix();
    String persamaan;
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
        //Create inverse
        matriks.Display();

    }

    public void inputMatrixFile(String filename) {
        /*
         * Mengisi Matriks dan Nilai yang dicari dengan inputan file
         * I.S. Matriks terdefinisi
         * F.S. Matriks dan Nilai terisi dengan inputan file
         */
        try {
            FileReader file = new FileReader("test/"+filename);
            BufferedReader br = new BufferedReader(file);
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                if (row <4){
                    for (int i = 0; i < temp.length; i++) {
                        matriksInput.array[row][i] = Double.parseDouble(temp[i]);
                    }
                }else{
                    a = Double.parseDouble(temp[0]);
                    b = Double.parseDouble(temp[1]);
                }
                row++;
            }
            br.close();
            matriksInput.row = row-1;
            matriksInput.col = row-1;
        }
        catch (Exception e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
        }
    }

    public void outputMatrixFile(String filename) {
        /*
         * Menulis hasil interpolasi ke file
         * I.S. Sembarang
         * F.S. Terbentuk file interpolasi.txt
         */
        try {
            FileWriter file = new FileWriter("hasil/"+filename);
            file.write(this.persamaan);
            file.write("\n");
            file.close();
        }
        catch (Exception e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
        }
    }
        public static void main(String[] args) {
        interpolationBicubic interpolasi = new interpolationBicubic();
        interpolasi.inputMatrixFile("2.txt");
        }
    }


