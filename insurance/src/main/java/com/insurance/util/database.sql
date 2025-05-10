
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

-- Tambah nasabah baru
INSERT INTO nasabah (nama, umur)
VALUES ('David Silva', 35);

-- Misal id nasabah baru adalah 1, tambah polis untuk nasabah tersebut
INSERT INTO polis (nasabah_id, jenis, premi)
VALUES (1, 'Jiwa', 1000000);

-- Misal id polis baru adalah 1, tambah klaim untuk polis tersebut
INSERT INTO klaim (polis_id, tanggal, status)
VALUES (1, '2025-05-11', 'Pending');
