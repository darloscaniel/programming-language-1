create database if not exists pl_1;

use pl_1;


create table bandeira(
pais varchar(20) not null,
cor varchar (50) not null,
descricao varchar (50) not null,
id_bandeira int auto_increment primary key);

create table caderno(
id_caderno int auto_increment primary key,
cor varchar(20) not null,
texto varchar(60) not null,
num_paginas int not null);

create table camisa(
id_camisa int auto_increment primary key,
tamanho varchar (10) not null,
cor varchar (20) not null,
tipo varchar (20) not null);

create table carro(
id_carro int auto_increment primary key,
modelo varchar(20) not null,
marca varchar(20) not null,
cor varchar (20) not null,
placa varchar(7) not null,
CONSTRAINT chk_placa_format CHECK (placa REGEXP '^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$'));

create table flor(
id_flor int auto_increment primary key,
especie varchar(25) not null,
cor varchar(20) not null,
tamanho double not null);

create table fruta(
id_fruta int auto_increment primary key,
tipo varchar(20) not null,
tamanho varchar(20) not null,
nome varchar(20) not null);

create table mamifero(
id_mamifero int auto_increment primary key,
tamanho double not null,
habitat varchar(30) not null,
especie varchar(30) not null);

create table oculos(
id_oculos int auto_increment primary key,
cor varchar(20) not null,
tipo varchar(20) not null,
material varchar(20) not null);

create table passaro(
id_passaro int auto_increment primary key,
especie varchar(20) not null,
nome varchar(20) not null,
tamanho double not null);

create table sapato(
id_sapato int auto_increment primary key,
tamanho double not null,
cor varchar(20) not null,
tipo varchar(20) not null);

CREATE USER 'user_1'@'localhost' IDENTIFIED BY '1234';
GRANT INSERT, SELECT, UPDATE, DELETE ON pl_1.* TO 'user_1'@'localhost';



