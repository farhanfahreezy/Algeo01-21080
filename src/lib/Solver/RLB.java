package lib.Solver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import lib.Matrix.Matrix;

public class RLB {
    Matrix solver = new Matrix();
    Scanner input = new Scanner(System.in);
    Double nilaiTaksir[] = new Double[100];
    int length;
    String persamaan;
    public void RLB_Ganda() {
        this.solver.Display();
        float[][] arrayl = new float[1000][1000];
        int a;
        a=this.solver.row;

        for(int i=0;i<this.solver.col;i++){
            for(int j=0;j<this.solver.col+1;j++){
                if(i==0){
                    if(j==0){
                        arrayl[i][j]=a;
                    }
                    else{
                        arrayl[i][j]=this.solver.sum1(j-1);
                    }
                }
                else{
                    if(j==0){
                        arrayl[i][j]=this.solver.sum1(i-1);
                    }
                    else{
                        arrayl[i][j]=this.solver.sum2(i-1,j-1);
                    }
                }
            }
        }
        //merubah matriks
        this.solver.row=this.solver.col;
        this.solver.col=this.solver.col+1;

        for(int i=0;i<this.solver.row;i++){
            for(int j=0;j<this.solver.col;j++){
                this.solver.array[i][j]=arrayl[i][j];
            }
        }
        this.solver.Hasil_OBE();
        System.out.println("Diperoleh hasil RLB Ganda");
        this.solver.Display();        
        
        //print solusi
        this.solver.mintoZero();
        System.out.printf("Y = ");
        for(int i=0;i<this.solver.row;i++){
            if(this.solver.array[i][this.solver.col-1]!=0){
                if(i==0){
                    System.out.printf("%.3f ",solver.array[i][solver.col-1]);
                }
                else{
                    if(solver.array[i][solver.col-1]>0){
                        System.out.printf("+ %.3f*X%d ",solver.array[i][solver.col-1],i);
                    }
                    else{
                        System.out.printf("- %.3f*X%d ",-solver.array[i][solver.col-1],i);
                        
                    }
                }
            }
        }
    }
    public  void save(){
        String hasil = "Y = ";
        for(int i=0;i<this.solver.row;i++){
            if(this.solver.array[i][this.solver.col-1]!=0){
                if(i==0){
                    hasil+=String.format("%.3f ",this.solver.array[i][this.solver.col-1]);
                    // System.out.printf("%.3f ",solver.array[i][solver.col-1]);
                }
                else{
                    if(solver.array[i][solver.col-1]>0){
                        hasil+=String.format("+ %.3f*X%d ",this.solver.array[i][this.solver.col-1],i);
                        // System.out.printf("+ %.3f*X%d ",solver.array[i][solver.col-1],i);
                    }
                    else{
                        hasil+=String.format("- %.3f*X%d ",-this.solver.array[i][this.solver.col-1],i);
                        // System.out.printf("- %.3f*X%d ",-solver.array[i][solver.col-1],i);
                        
                    }
                }
            }
        }
        this.persamaan = hasil;      
    }
    public Double hasiltaksir(Double[] nilai){
        /*
         * Spesifikasi fungsi : menghitung hasil taksir dari suatu nilai
         */
        Double hasil = 0.0;
        hasil+=this.solver.array[0][this.solver.col-1];
        for(int i=1;i<solver.row;i++){
            if(solver.array[i][solver.col-1]!=0){
                hasil+=solver.array[i][solver.col-1]*nilai[i-1];
            }
        }
        return hasil;
         
    }
    public void inputRLB(){
        /*
         * input nilai taksir dan nilai observasi
         * I.S = nilai taksir dan nilai observasi belum diinput
         * F.S = nilai taksir dan nilai observasi sudah diinput
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah peubah : ");
        this.solver.col = input.nextInt()+1;
        System.out.println("Masukkan jumlah sampel : ");
        this.solver.row = input.nextInt();
        for (int i=0;i<solver.row;i++){
            for (int j=0;j<this.solver.col;j++){
                if (j==this.solver.col-1){
                    System.out.printf("Masukkan nilai Y%d : ",i+1);
                    this.solver.array[i][j] = input.nextFloat();
                }
                else{
                    System.out.printf("Masukkan nilai X%d%d : ",j+1,i+1);
                    this.solver.array[i][j] = input.nextFloat();
                }
            }
        }
        System.out.println("Masukkan nilai X yang ingin ditaksir ");
        // this.length = input.nextInt();
        for (int j = 0 ;j<this.solver.col-1;j++){
            System.out.printf("Masukkan nilai X%d : ",j+1);
            this.nilaiTaksir[j] = input.nextDouble();
        }
    }
    public void InputFile(String filename){
        /*
         * Membuat matriks dari masukan file
         * I.S. Masukkan nama file
         * F.S. Terbentuk Matriks
         */
        try{
            FileReader file = new FileReader("../test/"+filename);
            BufferedReader br = new BufferedReader(file);   
            String line = br.readLine();
            int i = 0;
            this.length = 0;
            while (line != null){
                String [] data = line.split(" ");
                if (data.length != 1){
                    this.solver.col = data.length;
                    for (int j=0;j<data.length;j++){
                        this.solver.array[i][j] = Double.parseDouble(data[j]);
                    }
                }else if (data.length == 1){
                    this.nilaiTaksir[this.length] = Double.parseDouble(data[0]);
                    this.length++;
                }
                line = br.readLine();
                i = i + 1;
            }
            System.out.println("Masukkan nilai X yang ingin ditaksir ");
            // this.length = input.nextInt();
            for (int j = 0 ;j<this.solver.col-1;j++){
                System.out.printf("Masukkan nilai X%d : ",j+1);
                this.nilaiTaksir[j] = input.nextDouble();
            }
            br.close();
            System.out.println(i);
            this.solver.row = i-length;
        }
        catch(Exception e){
            System.out.println("File tidak ditemukan");
            System.out.println(e);
        }
    }
    public void outputFile(String filename){
        /*
         * Menyimpan hasil perhitungan ke file
         * I.S. Matriks sudah terbentuk
         * F.S. File hasil perhitungan tersimpan
         */
         try{
            FileWriter file = new FileWriter("../hasil/"+filename);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(this.persamaan);
            bw.newLine();
            bw.write(String.format("Hasil taksiran nilai y dari regresi linear adalah : %.3f",hasiltaksir(this.nilaiTaksir)));
            bw.close();
         }
         catch(Exception e){
            System.out.println("File tidak ditemukan");
            System.out.println(e);
         }
    }
    public static void main(){
        Scanner input = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String file ;
        RLB rlb = new RLB();
        do{
            System.out.print("Input file (y/n) : ");
            file = input.nextLine();
        }while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input.nextLine();
            rlb.InputFile(filename);
            }
        else{
            rlb.inputRLB();
            }
            rlb.RLB_Ganda();
            rlb.save(); 
            System.out.print('\n');
            System.out.printf("Hasil taksiran nilai y dari regresi linear adalah : %.3f\n",rlb.hasiltaksir(rlb.nilaiTaksir));
        do{
            System.out.print("Simpan solusi ke file (y/n) : ");
            file = input2.nextLine();
        }
        while(!file.equals("y") && !file.equals("n") && !file.equals("Y") && !file.equals("N"));
        if(file.equals("y") || file.equals("Y")){
            System.out.print("Masukkan nama file (filename.txt): ");
            String filename = input3.nextLine();
            rlb.outputFile(filename);
        }
    }  
    public static void main(String[] args) {
        RLB.main();
    }
}
