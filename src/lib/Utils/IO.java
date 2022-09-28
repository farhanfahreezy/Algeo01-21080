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
            FileReader file = new FileReader("test/"+filename);
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();    // read first line 
            int row = 0;
            while (line != null) {
                String[] temp = line.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    matriks.array[row][i] = Double.parseDouble(temp[i]);
                }
                row++;
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
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
            FileWriter file = new FileWriter("test/"+filename);
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
    public static void outputDeterminanFile(String filename,String det) {
        /*
         * Spesifikasi Fungsi : Menulis hasil determinan ke dalam file
         * I.S. det terdefinisi
         * F.S. det ditulis ke dalam file
         */
        try {
            FileWriter file = new FileWriter("test/"+filename);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write("Determinan: "+det);
            bw.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            System.out.println(e);
            }
        
    }
    public static void main(String[] args) throws IOException {

    }
}


