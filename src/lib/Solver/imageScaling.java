package lib.Solver;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageScaling {
    BufferedImage image = null;
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

    public void outputImage() {
        /*
         * Output gambar
         * I.S : Gambar terdefinisi
         * F.S : Gambar teroutput
         */
        BufferedImage output = new BufferedImage(this.width*2, this.height*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gph = output.createGraphics();
        gph.drawImage(this.image, 0, 0, this.width, this.height, null);
        try {
            File file = new File("test/output.png");
            ImageIO.write(output, "png", file);
        } catch (IOException e) {
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        imageScaling img = new imageScaling();
        img.inputImage("test.png");
        img.outputImage();
    }
}
