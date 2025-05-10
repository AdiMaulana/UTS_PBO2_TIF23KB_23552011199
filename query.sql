CREATE DATABASE kasir_asuransi;

USE kasir_asuransi;

CREATE TABLE nasabah (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100) NOT NULL,
    umur INT NOT NULL
);

CREATE TABLE polis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nasabah_id INT,
    jenis VARCHAR(50),
    premi DOUBLE,
    FOREIGN KEY (nasabah_id) REFERENCES nasabah(id)
);

CREATE TABLE klaim (
    id INT PRIMARY KEY AUTO_INCREMENT,
    polis_id INT,
    tanggal DATE,
    status VARCHAR(20),
    FOREIGN KEY (polis_id) REFERENCES polis(id)
);
