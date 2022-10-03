package lib.Solver;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import lib.Matrix.Matrix;
import java.lang.Math;

public class interpolationBicubic {
    Matrix matriksInput = new Matrix();
    Matrix matriks = new Matrix();
    double a,b,hasilInterpolasi;
    String persamaan;

    public void inputMatrix() {
        /*
         * Mengisi Matriks dan Nilai yang dicari dengan inputan user
         * I.S. Matriks terdefinisi
         * F.S. Matriks dan Nilai terisi dengan inputan user
         */
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("f(%d,%d) = ", i-1,j-1);
                this.matriksInput.array[i][j] = input.nextDouble();
            }
        }
        System.out.print("Masukkan x y [0,1]: ");
        this.a = input.nextDouble();
        this.b = input.nextDouble();
        this.matriksInput.row = 4;
        this.matriksInput.col = 4;
    }
    
    public void hasilBicubicInterpolasi() {
        /*
         * Mengeluarkan hasil interpolasi dari matriks yang telah diinputkan
         * I.S. Matriks terdefinisi
         * F.S. hasil interpolasi ditampilkan
         */
        
         //Ubah ukuran matriksInput dari 4x4 menjadi 16x1
        Matrix hasil = new Matrix();
        hasil.row = 16;
        hasil.col = 1;
        int k = 0;
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                hasil.array[k][0] = this.matriksInput.array[m][n];
                k++;
            }
        }
         //Mengisi matriks
        int col = 0;
        int row = 0;
        for (int y = -1 ; y<3 ;y++){
            for (int x = -1;x<3;x++){
                for (int j = 0;j<4;j++){
                    for (int i = 0;i<4;i++){
                        this.matriks.array[row][col]=Math.pow(x, i)*Math.pow(y, j);
                        col++;
                    }
                }
                col = 0;
                row++;
            }
        }
        this.matriks.col = 16;
        this.matriks.row = 16;
        //Create inverse
        Matrix inverse = new Matrix();
        inverse.row = 16;
        inverse.col = 16;
        inverse = SPL_Balikan.INV_GaussJordan(this.matriks);
        //Hasil kali inverse dengan matriks input
        Matrix hasilKali = new Matrix();
        hasilKali.row = 16;
        hasilKali.col = 1;
        hasilKali = Matrix.KaliMatrix(inverse, hasil);
        this.persamaan = "P(x,y) = ";
        //Hasil interpolasi f(a,b)
        this.hasilInterpolasi = 0;
        k = 0;
        for (int j = 0;j<4;j++){
            for (int i = 0;i<4;i++){
                this.persamaan += hasilKali.array[k][0]+"x^"+i+"y^"+j+" + ";
                this.hasilInterpolasi = this.hasilInterpolasi + hasilKali.array[k][0]*Math.pow(this.a, i)*Math.pow(this.b, j);
                k++;
            }
        }
        System.out.println("f("+this.a+","+this.b+") = "+String.format("%.2f",this.hasilInterpolasi));
    }
    
    public void inputMatrixFile(String filename) {
        /*
        * Mengisi Matriks dan Nilai yang dicari dengan inputan file
        * I.S. Matriks terdefinisi
        * F.S. Matriks dan Nilai terisi dengan inputan file
        */
        try {
            FileReader file = new FileReader("../test/"+filename);
            BufferedReader br = new BufferedReader(file);
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                if (row <4){
                    for (int i = 0; i < temp.length; i++) {
                        this.matriksInput.array[row][i] = Double.parseDouble(temp[i]);
                    }
                }else{
                    this.a = Double.parseDouble(temp[0]);
                    this.b = Double.parseDouble(temp[1]);
                }
                row++;
            }
            br.close();
            this.matriksInput.row = row-1;
            this.matriksInput.col = row-1;
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
            FileWriter file = new FileWriter("../hasil/"+filename);
            file.write("f("+this.a+","+this.b+") = "+String.format("%.3f", this.hasilInterpolasi));
            file.close();
        }
        catch (Exception e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
        }
    }
    public static void main() {
        Scanner input = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String file ;
        interpolationBicubic interpolasi = new interpolationBicubic();
        do{
            System.out.print("Input file (y/n) : ");
            file = input.nextLine();
        }while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            interpolasi.inputMatrixFile(filename);
            
            }
        else{
            interpolasi.inputMatrix();
            }
        interpolasi.hasilBicubicInterpolasi();

        do{
            System.out.print("Simpan solusi ke file (y/n) : ");
            file = input2.nextLine();
        }
        while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input3.nextLine();
            interpolasi.outputMatrixFile(filename);
        }
    }
}


