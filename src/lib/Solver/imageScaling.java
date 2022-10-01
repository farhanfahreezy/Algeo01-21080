package lib.Solver;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import lib.Matrix.Matrix;

public class imageScaling {
    BufferedImage image = null;
    BufferedImage output = null;
    int width;
    int height;
    Matrix matriksRed = new Matrix();
    Matrix matriksGreen = new Matrix();
    Matrix matriksBlue = new Matrix();
    Matrix matriksAlpha = new Matrix();
    double red;
    double green;
    double blue;
    double alpha;
    
    public void inputImage(String filename) {
        /*
        * Input gambar
        * I.S : Gambar terdefinisi
        * F.S : Gambar terinput
        */
        try {
            File file = new File("test/"+filename);
            this.image = ImageIO.read(file);
            this.width = image.getWidth();
            this.height = image.getHeight();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
        }
        
    }
    
    public void partisiGambar(int i,int j) {
        
        /*
         * Mengambil 4 x 4 pixel dari gambar dan mengubahnya menjadi matriks 4 x 4 
         * I.S. : Gambar terdefinisi
         * F.S. : Matriks terdefinisi
         */
        this.matriksRed.row = 4;
        this.matriksRed.col = 4;

        this.matriksGreen.row = 4;
        this.matriksGreen.col = 4;

        this.matriksBlue.row = 4;
        this.matriksBlue.col = 4;

        this.matriksAlpha.row = 4;
        this.matriksAlpha.col = 4;

        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                Color c = new Color(image.getRGB(i+k, j+l));
                this.matriksRed.array[k][l] =   c.getRed();
                this.matriksGreen.array[k][l] = c.getGreen();
                this.matriksBlue.array[k][l] = c.getBlue();
                this.matriksAlpha.array[k][l] = c.getAlpha();
            }
        }
        matriksRed.Display();
        System.out.println("====================================");
        matriksGreen.Display();
        System.out.println("====================================");
        matriksBlue.Display();
        System.out.println("====================================");
        matriksAlpha.Display();
    }

    public void hasilinterpolasiRGB(double row, double col) {
        /*
         * Mencari nilai interpolasi dari matriks matriksRed, matriksGreen, matriksBlue
         * I.S. : Matriks terdefinisi
         * F.S : Hasil Interpolasi terdefinisi
         */
        interpolationBicubic interpolasiRed = new interpolationBicubic();
        interpolationBicubic interpolasiGreen = new interpolationBicubic();
        interpolationBicubic interpolasiBlue = new interpolationBicubic();
        interpolationBicubic interpolasiAlpha = new interpolationBicubic();

        interpolasiRed.matriksInput = this.matriksRed;
        interpolasiGreen.matriksInput = this.matriksGreen;
        interpolasiBlue.matriksInput = this.matriksBlue;
        interpolasiAlpha.matriksInput = this.matriksAlpha;

        interpolasiBlue.a = col;
        interpolasiBlue.b = row;
        interpolasiRed.a = col;
        interpolasiRed.b = row;
        interpolasiGreen.a = col;
        interpolasiGreen.b = row;
        interpolasiAlpha.a = col;
        interpolasiAlpha.b = row;

        interpolasiRed.hasilBicubicInterpolasi();
        interpolasiGreen.hasilBicubicInterpolasi();
        interpolasiBlue.hasilBicubicInterpolasi();
        interpolasiAlpha.hasilBicubicInterpolasi();

        this.red =  Math.round(interpolasiRed.hasilInterpolasi);
        this.green =  Math.round(interpolasiGreen.hasilInterpolasi);
        this.blue = Math.round(interpolasiBlue.hasilInterpolasi);
        this.alpha =  Math.round(interpolasiAlpha.hasilInterpolasi);
    }

    public void perbesarGambar() {
        /*
         * Perbesar gambar
         * I.S : Gambar terdefinisi
         * F.S : Gambar diperbesar
         */
        this.output = new BufferedImage(this.width*2, this.height*2, BufferedImage.TYPE_INT_ARGB);
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.height; j++) {
                Color c = new Color(this.image.getRGB(i, j));
                int red = (int)(c.getRed());
                int green = (int)(c.getGreen());
                int blue = (int)(c.getBlue());
                int alpha = (int)(c.getAlpha());
                Color newColor = new Color(red, green, blue, alpha);
                this.output.setRGB(i*2, j*2, newColor.getRGB());
                this.output.setRGB(i*2+1, j*2, newColor.getRGB());
                this.output.setRGB(i*2, j*2+1, newColor.getRGB());
                this.output.setRGB(i*2+1, j*2+1, newColor.getRGB());
            }
        }
    }
    public void outputImage() {
        /*
         * Output gambar
         * I.S : Gambar terdefinisi
         * F.S : Gambar teroutput
         */
        try {
            File file = new File("hasil/output.png");
            ImageIO.write(this.output, "png", file);
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        imageScaling img = new imageScaling();
        img.inputImage("albert.png");
        img.partisiGambar(0,0);
        img.hasilinterpolasiRGB(0.5, 0);
        System.out.println(img.red);
        System.out.println(img.green);
        System.out.println(img.blue);
        System.out.println(img.alpha);
    }
}
