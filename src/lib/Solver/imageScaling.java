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
        Matrix matriks = new Matrix();
        
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
                output.setRGB(i*2, j*2, newColor.getRGB());
                output.setRGB(i*2+1, j*2, newColor.getRGB());
                output.setRGB(i*2, j*2+1, newColor.getRGB());
                output.setRGB(i*2+1, j*2+1, newColor.getRGB());
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
        img.perbesarGambar();
        img.outputImage();
    }
}
