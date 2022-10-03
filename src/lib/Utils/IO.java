package lib.Utils;
import lib.Matrix.Matrix;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
    public static Matrix inputMatrixFile(String filename) {
        /*
         * Spesifikasi Fungsi : Membaca file dan mengembalikan matriks yang terdapat di dalam file
         */
        Matrix matriks = new Matrix();
        try {
            FileReader file = new FileReader("../test/"+filename);
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();  
            int row = 0;
            while (line != null) {
                String[] temp = line.split(" ");
                matriks.col = temp.length;
                for (int i = 0; i < temp.length; i++) {
                    matriks.array[row][i] = Double.parseDouble(temp[i]);
                }
                row++;
                line = br.readLine();
            }
            matriks.row = row;
            br.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
        }
        return matriks;
    }
    public static void outputOBEFile(String filename,String array[]) {
        /*
         * Spesifikasi Fungsi : Menulis array ke dalam file
         * I.S. array terdefinisi
         * F.S. array ditulis ke dalam file
         */
        try {
            FileWriter file = new FileWriter("../hasil/"+filename);
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < array.length; i++) {
                bw.write(array[i]);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
            }
    }
    public static void outputDeterminanFile(String filename,double det) {
        /*
         * Spesifikasi Fungsi : Menulis hasil determinan ke dalam file
         * I.S. det terdefinisi
         * F.S. det ditulis ke dalam file
         */
        try {
            FileWriter file = new FileWriter("../hasil/"+filename);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write("Determinan: "+det);
            bw.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
            }
        
    }
    public static void outputInversFile(String filename,Matrix matriks) {
        /*
         * Spesifikasi Fungsi : Menulis hasil invers ke dalam file
         * I.S. matriks terdefinisi
         * F.S. matriks ditulis ke dalam file
         */
        try {
            FileWriter file = new FileWriter("../hasil/"+filename);
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < matriks.row; i++) {
                for (int j = 0; j < matriks.col; j++) {
                    bw.write(String.format("%.3f", matriks.array[i][j])+" ");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
            }
    }
    public static void main(String[] args) throws IOException {
        Matrix matriks = new Matrix();
        matriks = inputMatrixFile("3.txt");
        matriks.Display();
    }
}


