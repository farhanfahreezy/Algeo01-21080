package lib.Solver;

import lib.Matrix.Matrix;

public class bicubic {
    public static int[] hasil(Matrix inv,Matrix matriksInput){
        int [] res = new int[5];
        // inv.Display();
        Matrix f = new Matrix();
        f.row=16;
        f.col=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                f.array[i*4+j][0]=matriksInput.array[i][j];
            }
        }

        Matrix a = new Matrix();
        a.row=16;
        a.col=1;
        a=Matrix.KaliMatrix(inv, f);

        double hasil=0;
        double hasil1=0;
        double hasil2=0;
        double hasil3=0;
        double hasil4=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                hasil+=a.array[i*4+j][0]*Math.pow(0, i)*Math.pow(0.5, j);
                hasil1+=a.array[i*4+j][0]*Math.pow(0.5, i)*Math.pow(0, j);
                hasil2+=a.array[i*4+j][0]*Math.pow(0.5, i)*Math.pow(1, j);
                hasil3+=a.array[i*4+j][0]*Math.pow(1, i)*Math.pow(0.5, j);
                hasil4+=a.array[i*4+j][0]*Math.pow(0.5, i)*Math.pow(0.5, j);
            }
        }
        res[0]=(int)hasil;
        res[1]=(int)hasil1;
        res[2]=(int)hasil2;
        res[3]=(int)hasil3;
        res[4]=(int)hasil4;
        return res;
        
    }
}
