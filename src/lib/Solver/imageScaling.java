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
    Color c,newColor,cc,c1,c2,c3,c4;
    Color newColor1,newColor2,newColor3,newColor4,newColor5;
    int red,green,blue,alpha,red1,green1,blue1,alpha1;
    Matrix resr = new Matrix();
    Matrix resg=new Matrix();
    Matrix resb=new Matrix();
    Matrix resa=new Matrix();
    int nr2,ng2,nb2,nr1,ng1,nb1,nr3,ng3,nb3,nr4,ng4,nb4;
    int hasilred,hasilgreen,hasilblue;
    
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
    public void idxundef(int i,int j,int ii,int jj){
        if(this.hasilred<0 || this.hasilred>255){
            this.c1= new Color(this.image.getRGB(i, j));
            this.c2= new Color(this.image.getRGB(ii, jj));
            this.nr1=this.c1.getRed();
            this.nr2=this.c2.getRed();
            this.hasilred=(int)(this.nr1+this.nr2)/2;
        }
        if(this.hasilgreen<0 || this.hasilgreen>255){
            this.c1= new Color(this.image.getRGB(i, j));
            this.c2= new Color(this.image.getRGB(ii, jj));
            this.ng1=this.c1.getGreen();
            this.ng2=this.c2.getGreen();
            this.hasilgreen=(int)(this.ng1+this.ng2)/2;
        }
        if(this.hasilblue<0 || this.hasilblue>255){
            this.c1= new Color(this.image.getRGB(i, j));
            this.c2= new Color(this.image.getRGB(ii, jj));
            this.nb1=this.c1.getBlue();
            this.nb2=this.c2.getBlue();
            this.hasilblue=(int)(this.nb1+this.nb2)/2;
        }
    }
    public void idxundefmid(int i,int j){
        if(this.hasilred<0 || this.hasilred>255){
            this.c1= new Color(this.image.getRGB(i+1, j+1));
            this.c2= new Color(this.image.getRGB(i+1, j+2));
            this.c3= new Color(this.image.getRGB(i+2, j+1));
            this.c4= new Color(this.image.getRGB(i+2, j+2));
            this.nr1=this.c1.getRed();
            this.nr2=this.c2.getRed();
            this.nr3=this.c3.getRed();
            this.nr4=this.c4.getRed();
            this.hasilred=(int)(this.nr1+this.nr2+this.nr3+this.nr4)/4;
        }
        if(this.hasilgreen<0 || this.hasilgreen>255){
            this.c1= new Color(this.image.getRGB(i+1, j+1));
            this.c2= new Color(this.image.getRGB(i+1, j+2));
            this.c3= new Color(this.image.getRGB(i+2, j+1));
            this.c4= new Color(this.image.getRGB(i+2, j+2));
            this.ng1=this.c1.getGreen();
            this.ng2=this.c2.getGreen();
            this.ng3=this.c3.getGreen();
            this.ng4=this.c4.getGreen();
            this.hasilgreen=(int)(this.ng1+this.ng2+this.ng3+this.ng4)/4;
        }
        if(this.hasilblue<0 || this.hasilblue>255){
            this.c1= new Color(this.image.getRGB(i+1, j+1));
            this.c2= new Color(this.image.getRGB(i+1, j+2));
            this.c3= new Color(this.image.getRGB(i+2, j+1));
            this.c4= new Color(this.image.getRGB(i+2, j+2));
            this.nb1=this.c1.getBlue();
            this.nb2=this.c2.getBlue();
            this.nb3=this.c3.getBlue();
            this.nb4=this.c4.getBlue();
            this.hasilblue=(int)(this.nb1+this.nb2+this.nb3+this.nb4)/4;
        }
    }
    public void MakeRGB(int i,int j){
        this.cc = new Color(this.image.getRGB(i, j));
        this.red1 = (int)(cc.getRed());
        this.green1 = (int)(cc.getGreen());
        this.blue1 = (int)(cc.getBlue());
        this.alpha1 = (int)(cc.getAlpha());
    }
    public void makeArrayRGB(int i,int j){
        this.resr.array[i][j] =this.red1 ;
        this.resg.array[i][j] =this.green1 ;
        this.resb.array[i][j] =this.blue1 ;
        this.resa.array[i][j] =this.alpha1 ;
    }
    public void isigambar(int i0,int it,int j0,int jt,int ket){
        Matrix in = new Matrix();
        in.row=16;
        in.col=16;
        
        for(int i=-1;i<3;i++){
            for(int j=-1;j<3;j++){
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){
                        in.array[(i+1)*4+j+1][k*4+l]=Math.pow(i, k)*Math.pow(j, l);
                    }
                }
            }
        }
        in=SPL_Balikan.Balikan_SPL(in);
        for(int i=i0;i<it;i++){
            for(int j=j0;j<jt;j++){
                if(ket==0){
                    this.c = new Color(this.image.getRGB(i, j));
                    this.red = (int)(c.getRed());
                    this.green = (int)(c.getGreen());
                    this.blue = (int)(c.getBlue());
                    this.alpha = (int)(c.getAlpha());
                    this.newColor = new Color(this.red, this.green, this.blue, this.alpha);
                    this.output.setRGB(i*2, j*2, this.newColor.getRGB());
                }
                
                this.resr.row = 4;
                this.resr.col = 4;
                this.resg.row = 4;
                this.resg.col = 4;
                this.resb.row = 4;
                this.resb.col = 4;
                this.resa.row = 4;
                this.resa.col = 4;

                

                for(int ii=i;ii<i+4;ii++){
                    for(int jj=j;jj<j+4;jj++){
                        // ket 0 menandakan isi semua pixel kecuali atas kiri kanan bawah 
                        if(ket==0){
                            MakeRGB(ii, jj);
                            makeArrayRGB(ii-i, jj-j);
                        }
                        // ket 1 mendakan isi sisi atas
                        else if(ket==1){
                            if(jj==-1){
                                MakeRGB(ii, jj+1);
                                makeArrayRGB(ii-i, 0);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        // ket 2 isi sisi kiri
                        else if(ket==2){
                            if(ii==-1){
                                MakeRGB(ii+1, jj);
                                makeArrayRGB(0, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        //ket 3 isi sisi kanan
                        else if(ket==3){
                            if(ii==i+3){
                                MakeRGB(ii-1, jj);
                                makeArrayRGB(3, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                            
                        }
                        // ket 4 bawah
                        else if(ket==4){
                            if(jj==j+3){
                                MakeRGB(ii, jj-1);
                                makeArrayRGB(ii-i, 3);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        // kiri atas
                        else if(ket==5){
                            if(jj==-1 && ii==-1){
                                MakeRGB(ii+1, 1+jj);
                                makeArrayRGB(0,0);
                            }
                            else if(jj==-1){
                                MakeRGB(ii, jj+1);
                                makeArrayRGB(ii-i, 0);
                            }
                            else if(ii==-1){
                                MakeRGB(ii+1, jj);
                                makeArrayRGB(0, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);

                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        // kanan atas
                        else if(ket==6){
                            if(jj==-1 && ii==i+3){
                                MakeRGB(ii-1, jj+1);
                                makeArrayRGB(3,0);
                            }
                            else if(jj==-1){
                                MakeRGB(ii, jj+1);
                                makeArrayRGB(ii-i, 0);
                            }
                            else if(ii==i+3){
                                MakeRGB(ii-1, jj);
                                makeArrayRGB(3, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        // kiri bawah
                        else if(ket==7){
                            if(jj==j+3 && ii==-1){
                                MakeRGB(ii+1, jj-1);
                                makeArrayRGB(0,3);
                            }
                            else if(jj==j+3){
                                MakeRGB(ii, jj-1);
                                makeArrayRGB(ii-i, 3);
                            }
                            else if(ii==-1){
                                MakeRGB(ii+1, jj);
                                makeArrayRGB(0, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        // kanan bawah
                        else if(ket==8){
                            if(jj==j+3 && ii==i+3){
                                MakeRGB(ii-1, jj-1);
                                makeArrayRGB(3,3);
                            }
                            else if(jj==j+3){
                                MakeRGB(ii, jj-1);
                                makeArrayRGB(ii-i,3);
                            }
                            else if(ii==i+3){
                                MakeRGB(ii-1, jj);
                                makeArrayRGB(3, jj-j);
                            }
                            else{
                                MakeRGB(ii, jj);
                                makeArrayRGB(ii-i, jj-j);
                                Color nc = new Color(red1,green1,blue1,alpha1);
                                this.output.setRGB(ii*2, jj*2, nc.getRGB());
                            }
                        }
                        


                        
                    }
                }
                int[] tempr = new int[10];
                int[] tempg = new int[10];
                int[] tempb = new int[10];
                tempr=bicubic.hasil(in, this.resr);
                tempg=bicubic.hasil(in, this.resg);
                tempb=bicubic.hasil(in, this.resb);
                
                //atas
                this.hasilred=tempr[0];
                this.hasilgreen=tempg[0];
                this.hasilblue=tempb[0];
                idxundef(i+1, j+1,i+1,j+2);
                
                
                this.newColor1 = new Color(hasilred, this.hasilgreen, this.hasilblue, 255);
                output.setRGB(i*2+2, j*2+3, this.newColor1.getRGB());
                //kiri
                this.hasilred=tempr[1];
                this.hasilgreen=tempg[1];
                this.hasilblue=tempb[1];
                idxundef(i+1, j+1, i+2, j+1);
                
                
                newColor2 = new Color(this.hasilred, this.hasilgreen, this.hasilblue, 255);
                output.setRGB(i*2+3, j*2+2, this.newColor2.getRGB());
                //kanan
                this.hasilred=tempr[2];
                this.hasilgreen=tempg[2];
                this.hasilblue=tempb[2];
                idxundef(i+1, j+2, i+2, j+2);
                
                
                this.newColor3 = new Color(this.hasilred, this.hasilgreen, this.hasilblue, 255);
                output.setRGB(i*2+3, j*2+4, this.newColor3.getRGB());
                //bawah
                this.hasilred=tempr[3];
                this.hasilgreen=tempg[3];
                this.hasilblue=tempb[3];
                idxundef(i+2, j+1,i+2, j+2);

                newColor4 = new Color(this.hasilred, this.hasilgreen, this.hasilblue, 255);
                output.setRGB(i*2+4, j*2+3, this.newColor4.getRGB());
                //tengah
                this.hasilred=tempr[4];
                this.hasilgreen=tempg[4];
                this.hasilblue=tempb[4];
                idxundefmid(i,j);
                
                this.newColor5 = new Color(this.hasilred, this.hasilgreen, this.hasilblue, 255);
                output.setRGB(i*2+3, j*2+3, this.newColor5.getRGB());



            }
        }
    }
    public void perbesarGambar() {
        /*
         * Perbesar gambar
         * I.S : Gambar terdefinisi
         * F.S : Gambar diperbesar
         */
        this.output = new BufferedImage(this.width*2, this.height*2, BufferedImage.TYPE_INT_ARGB);
        isigambar(0, this.width-3, 0, this.height-3,0); // tengah
        isigambar(0, this.width-3, -1, 0,1); // atas
        isigambar(-1, 0, 0, this.height-3,2); // kiri
        isigambar(this.width-3, this.width-2, 0, this.height-3,3); // kanan
        isigambar(0, this.width-3, this.height-3, this.height-2,4); // bawah
        
        isigambar(-1, 0, -1, 0, 5); // kiri atas
        isigambar(this.width-3, this.width-2, -1, 0, 6); // kanan atas
        isigambar(-1, 0, this.height-3, this.height-2, 7); // kiri bawah
        isigambar(this.width-3, this.width-2, this.height-3, this.height-2, 8); // kanan bawah

        
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
        img.inputImage("test.png");
        img.perbesarGambar();
        img.outputImage();
        
    }
}
