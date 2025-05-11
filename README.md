# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Adi Maulana Amin</li>
  <li>NIM: 23552011199</li>
  <li>Studi Kasus: Kasir Asuransi</li>
</ul>

## Judul Studi Kasus
<p>Kasir Asuransi.</p>

## Penjelasan Studi Kasus
<p><strong>Deskripsi: </strong>Kasir untuk pengelolaan premi dan klaim asuransi.</p>

Proyek **Kasir Asuransi** ini merupakan aplikasi berbasis Java yang mengelola premi dan klaim asuransi dengan menerapkan konsep **Konsep OOP** berikut: Inheritance, Encapsulation, Polymorphism, dan Abstraction.

---
## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance (Pewarisan)

Inheritance memungkinkan kelas anak mewarisi atribut dan metode dari kelas induk, sehingga menghindari duplikasi kode dan memudahkan pengelolaan tipe asuransi yang berbeda.

**Implementasi:**

- `Asuransi` sebagai kelas abstrak induk.
- `AsuransiKesehatan` dan `AsuransiJiwa` sebagai subclass yang mewarisi `Asuransi`.

**Implementasi dalam kode :**

```java
// Superclass abstrak
public abstract class Asuransi {
    protected String jenis;
    protected double premi;

    public abstract double hitungPremi();

    public String getJenis() { return jenis; }
    public double getPremi() { return premi;}
}

// Subclass mewarisi Asuransi
public class AsuransiJiwa extends Asuransi {
    private double nilaiPertanggungan;

    public AsuransiJiwa(double nilaiPertanggungan) {
        this.jenis = constant.AS_JIWA;
        this.nilaiPertanggungan = nilaiPertanggungan;
    }

    @Override
    public double hitungPremi() {
        premi = nilaiPertanggungan * 0.05;
        return premi;
    }
}

public class AsuransiKesehatan extends Asuransi {
    private double biayaDasar;

    public AsuransiKesehatan(double biayaDasar) {
        this.jenis = constant.AS_KESEHATAN;
        this.biayaDasar = biayaDasar;
    }

    @Override
    public double hitungPremi() {
        premi = biayaDasar * 1.2;
        return premi;
    }
}
 
```

### 2. Encapsulation (Enkapsulasi)

Encapsulation menyembunyikan data dengan modifier `private` dan menyediakan akses melalui getter dan setter, sehingga data terlindungi dari akses langsung.

**Implementasi:**

- Kelas `Nasabah` dengan atribut private dan method getter/setter.

### 3. Polymorphism (Polimorfisme)

Polymorphism memungkinkan metode yang sama berperilaku berbeda tergantung objek yang memanggilnya. Method `hitungPremi()` di kelas `Asuransi` di-override di subclass `AsuransiKesehatan` dan `AsuransiJiwa`.

**Implementasi:**

### 4. Abstract (Abstraksi)

Abstraksi menyembunyikan detail implementasi dan hanya menampilkan fitur penting. `Asuransi` adalah kelas abstrak yang mendefinisikan kontrak method `hitungPremi()` yang wajib diimplementasikan subclass.

**Implementasi:**

## Kesimpulan

| Konsep OOP   | Penjelasan Singkat                                                                                 | Implementasi Kasus Kasir Asuransi                                    |
|-------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| Inheritance | Kelas anak mewarisi atribut dan metode dari kelas induk, menghindari duplikasi kode               | `Asuransi` → `AsuransiKesehatan`, `AsuransiJiwa`                      |
| Encapsulation | Menyembunyikan data dengan modifier private dan akses melalui getter/setter                      | Kelas `Nasabah` dengan atribut private dan getter/setter            |
| Polymorphism | Metode yang sama dapat berperilaku berbeda tergantung objek yang memanggil                       | Method `hitungPremi()` di kelas `Asuransi` di-override di subclass  |
| Abstract    | Menyembunyikan detail implementasi, menyediakan kontrak method yang harus diimplementasikan       | `Asuransi` sebagai kelas abstrak dengan method abstrak `hitungPremi()` |

---

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/AdiMaulana/UTS_PBO2_TIF23KB_23552011199/blob/main/insurance/src/main/java/com/insurance/MainApp.java">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
