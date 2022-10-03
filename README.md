# Tugas Besar 1 IF 2123 Aljabar Linier dan Geometri Sistem Persamaan Linier, Determinan, dan Aplikasinya Semester I Tahun 2022/2023

## ANGGOTA KELOMPOK
| Nama        | NIM           |
| ------------- |:-------------:|
| Fajar Maulana Herawan     | 13521080 |
| Vieri Fajar Firdaus      | 13521099  |   
| Mohammad Farhan Fahrezy | 13521105      |   

## Menjalankan Program
### Tanpa File .jar
1. Clone repository ini ```git clone https://github.com/farhanfahrezy/Tubes-1-Algeo-SPL.git``` atau download zip.
2. ```cd Algeo01-21080/src```
3. Untuk mengcompile program  ```javac -d ../bin main.java```
4. Untuk menjalankan program ```cd ../bin``` setelah itu ```java main```

### Menggunakan File .jar
1. Clone repository ini ```git clone https://github.com/farhanfahrezy/Tubes-1-Algeo-SPL.git``` atau download zip.
2. ```cd Algeo01-21080/src```
3. Untuk menjalankan program ``java -jar SPLdeck.jar``

## Menu Utama
Setelah menjalankan program, akan ditampilkan menu seperti berikut
```
====================================
 Selamat datang di Matrix Kalkulator
====================================
====================================
=                                  =
=          TUBES ALGEO 1           =
=                                  =
====================================
=                                  =
= Menu                             =
= 1. Sistem Persamaan Linier       =
= 2. Determinan                    =
= 3. Matriks Balikan               =
= 4. Interpolasi Polinom           =
= 5. Interpolasi Bicubic           =
= 6. Regresi linear berganda       =
= 7. Perbesar Gambar               =
= 8. Keluar                        =
=                                  =
====================================
Pilihan :
```
Masukan pilihan 1-8 (inklusif)
## Sistem Persamaan Linear
Saat memilih nomor 1, akan ditampilkan menu 
```
====================================
=                                  =
= 1. Metode Eliminasi Gauss        =
= 2. Metode Eliminasi Gauss-Jordan =
= 3. Metode Matriks Balikan        =
= 4. Kaidah Cramer                 =
= 5. Kembali                       =
=                                  =
====================================
Pilihan : 
```
Masukan pilihan 1-5 (inklusif)
### Metode Eliminasi Gauss
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan jumlah baris dan kolom matriks augmented
```
Masukkan jumlah m: 2
Masukkan jumlah n: 3
1 2 3
4 5 6
```
Setelah itu ditampilkan langkah-langkah OBE, hasil matriks, dan hasil persamaan 
```
diperoleh hasil matriks :

1.00 2.00 3.00
0.00 -3.00 -6.00

Hasil persamaan Gauss diperoleh sebagai berikut

X1 + 2.00*X2 = 3.00
-3.00*X2 = -6.00
Solusi dari persamaan diatas adalah: 
X1 = - 1.00
X2 = 2.00
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
### Metode Eliminasi Gauss Jordan
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan jumlah baris dan kolom matriks augmented
```
Masukkan jumlah m: 3
Masukkan jumlah n: 4
3 4 -2 1
5 1 3 10
2 0 -1 2
```
Setelah itu ditampilkan langkah-langkah OBE,hasil matriks, dan persamaan 
```
R1 -> R1/3.00
1.00 1.33 -0.67 0.33
5.00 1.00 3.00 10.00
2.00 0.00 -1.00 2.00

R2 -> R2 - 5.00*R1
1.00 1.33 -0.67 0.33
0.00 -5.67 6.33 8.33
2.00 0.00 -1.00 2.00

R3 -> R3 - 2.00*R1
1.00 1.33 -0.67 0.33
0.00 -5.67 6.33 8.33
0.00 -2.67 0.33 1.33

R2 -> -R2/5.67
1.00 1.33 -0.67 0.33
0.00 1.00 -1.12 -1.47
0.00 -2.67 0.33 1.33

R3 -> R3 + 2.67*R2
1.00 1.33 -0.67 0.33
0.00 1.00 -1.12 -1.47
0.00 0.00 -2.65 -2.59

R3 -> -R3/2.65
1.00 1.33 -0.67 0.33
0.00 1.00 -1.12 -1.47
0.00 0.00 1.00 0.98

R2 -> R2 + 1.12*R3
1.00 1.33 -0.67 0.33
0.00 1.00 0.00 -0.38
0.00 0.00 1.00 0.98

R1 -> R1 + 0.67*R3
1.00 1.33 0.00 0.99
0.00 1.00 0.00 -0.38
0.00 0.00 1.00 0.98

R1 -> R1 - 1.33*R2
1.00 0.00 0.00 1.49
0.00 1.00 0.00 -0.38
0.00 0.00 1.00 0.98

Solusi dari persamaan diatas adalah:
X1 = 1.49
X2 = - 0.38
X3 = 0.98
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
### Metode Matriks Balikan
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan jumlah baris dan kolom matriks augmented
```
Masukkan jumlah m: 3
Masukkan jumlah n: 4
3 4 -2 1
5 1 3 10
2 0 -1 2
```
Setelah itu ditampilkan solusi SPL metode balikan 
```
Solusi dari persamaan diatas adalah:
X1 = 1.49
X2 = - 0.38
X3 = 0.98
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
### Metode Kaidah Cramer
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan jumlah baris dan kolom matriks augmented
```
Masukkan jumlah m: 3
Masukkan jumlah n: 4
3 4 -2 1
5 1 3 10
2 0 -1 2
```
Setelah itu ditampilkan solusi SPL metode balikan 
```
Hasil Operasi Perhitungan Cramer adalah: 
X-1: 1.49
X-2: -0.38
X-3: 0.98
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
## Determinan
Saat memilih nomor 2, akan ditampilkan menu 
```
====================================
=                                  =
= 1. Metode Ekspansi Kofaktor      =
= 2. Metode Gauss                  =
= 3. Kembali                       =
=                                  =
====================================
Pilihan :
```
Masukan pilihan 1-3 (inklusif)
### Metode Ekspansi Kofaktor
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan nilai n untuk matriks square
```
Masukkan jumlah n: 4
4 1 4 2
5 3 6 2
9 8 1 0
7 9 9 1
```
Setelah itu ditampilkan hasil determinan metode ekspansi kofaktor 
```
Determinan dengan metode reduksi baris kofaktor: -9.0
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
### Metode Gauss
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan nilai n untuk matriks square
```
Masukkan jumlah n: 4
4 1 4 2
5 3 6 2
9 8 1 0
7 9 9 1
```
Setelah itu ditampilkan hasil Determinan metode Gauss
```
Determinan dengan metode Gauss: -9.0
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
## Matriks Balikan
Saat memilih nomor 3, akan ditampilkan menu 
```
====================================
=                                  =
= 1. Metode Gauss-Jordan           =
= 2. Metode Adjoin                 =
= 3. Kembali                       =
=                                  =
====================================
Pilihan :
```
Masukan pilihan 1-3 (inklusif)
### Metode Gauss-Jordan
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan nilai n untuk matriks square
```
Masukkan jumlah n: 4
4 1 4 2
5 3 6 2
9 8 1 0
7 9 9 1
```
Setelah itu ditampilkan hasil matriks balikan 
```
Hasil invers Gauss Jordan
-9.00 10.56 0.67 -3.11
11.00 -12.89 -0.67 3.78
-7.00 8.11 0.33 -2.22
27.00 -30.89 -1.67 8.78
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
### Metode Adjoin
Mula-mula akan ditanya masukan input file atau tidak ```Input file (y/n) : ```
jika memilih tidak (n) akan meminta masukan nilai n untuk matriks square
```
Masukkan jumlah n: 4
4 1 4 2
5 3 6 2
9 8 1 0
7 9 9 1
```
Setelah itu ditampilkan hasil matriks balikan 
```
Hasil invers Adjoin
-9.00 10.56 0.67 -3.11
11.00 -12.89 -0.67 3.78
-7.00 8.11 0.33 -2.22
27.00 -30.89 -1.67 8.78
```
Kemudian meminta masukan membuat file atau tidak ```Simpan solusi ke file (y/n) : ```
## Aplikasi
### Interpolasi Polinom
Mula-mula akan ditanya masukan input file atau tidak Input file (y/n) : jika memilih (y) akan meminta masukan file txt pada folder test
```
Interpolasi Polinom
Input file (y/n) : y
Masukkan nama file (filename.txt): polinom.txt
P(x) = 7.191043175045852E12 - 9.35161531589144E12X + 5.336587667141117E12 X^2 - 1.757526932593959E12 X^3 + 3.6868913056006055E11 X^4 - 5.114965157579532E10 X^5 + 4.697327200671469E9 X^6 - 2.755580954627556E8 X^7 + 9375523.81015 X^8 - 141031.71617072617 X^9
P(7.22) = 33377.75
```
### Interpolasi Bicubic
Mula-mula akan ditanya masukan input file atau tidak Input file (y/n) : jika memilih (y) akan meminta masukan file txt pada folder test
```
Interpolasi Bicubic
Input file (y/n) : y
Masukkan nama file (filename.txt): bicubic.txt
f(0.1,0.9) = 104.23
```

### Regresi Linier Berganda
Mula-mula akan ditanya masukan input file atau tidak Input file (y/n) : jika memilih  (y) akan meminta masukan file txt pada folder test
```
Regresi Linear Berganda
Input file (y/n) : y
Masukkan nama file (filename.txt): 4.txt
Masukkan nilai X yang ingin ditaksir 
Masukkan nilai X1 : 50
Masukkan nilai X2 : 76
Masukkan nilai X3 : 29.30
20
72.40 76.30 29.18 0.90
41.60 70.30 29.35 0.91
34.30 77.10 29.24 0.96
35.10 68.00 29.27 0.89
10.70 79.00 29.78 1.00
12.90 67.40 29.39 1.10
8.30 66.80 29.69 1.15
20.10 76.90 29.48 1.03
72.20 77.70 29.09 0.77
24.00 67.70 29.60 1.07
23.20 76.80 29.38 1.07
47.40 86.60 29.35 0.94
31.50 76.90 29.63 1.10
10.60 86.30 29.56 1.10
11.20 86.00 29.48 1.10
73.30 76.30 29.40 0.91
75.40 77.90 29.28 0.87
96.60 78.70 29.29 0.78
107.40 86.80 29.03 0.82
54.90 70.90 29.37 0.95
Diperoleh hasil RLB Ganda
1.00 0.00 0.00 0.00 -3.50
0.00 1.00 0.00 0.00 -0.00
0.00 0.00 1.00 0.00 0.00
0.00 0.00 0.00 1.00 0.15
Y = -3.505 - 0.003*X1 + 0.001*X2 + 0.154*X3
Hasil taksiran nilai y dari regresi linear adalah : 0.938
```
### Perbesar Gambar
Mula-mula akan ditanya masukan input file ```Masukkan nama file (gambar.png):``` pastikan format file dalam png
```
Perbesar Gambar
Masukkan nama file (gambar.png): nyan.png
loading...
done
```
Setelah selesai file akan tersimpan dalam folder hasil dengan format ```output.png```
