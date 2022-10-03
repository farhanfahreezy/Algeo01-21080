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
2. ```cd Tubes-1-Algeo-SPL/src```
3. Untuk mengcompile program  ```javac -d ../bin main.java```
4. Untuk menjalankan program ```cd ../bin``` setelah itu ```java main```

### Menggunakan File .jar
1. Clone repository ini ```git clone https://github.com/farhanfahrezy/Tubes-1-Algeo-SPL.git``` atau download zip.
2. ```cd Tubes-1-Algeo-SPL/src```
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
### Interpolasi Bicubic
### Regresi Linier Berganda
### Perbesar Gambar
