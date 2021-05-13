create database Students;
CREATE DATABASE IF NOT EXISTS Students  CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci';
use Students;
create table class(
id int auto_increment,
`name` char(255) null);
create table teacher(
id int auto_increment,
`name` char(255) null,
country char(255) null);


