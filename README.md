# ScrapeIt

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Documentation](#Documentation)
* [Endpoints](#endpoints)

## Introduction
ScrapeIt is a file management application. The application stores files in the database. 
It allows you to upload and download them.

#### The application is under development.

## Technologies 
* Java
* Spring Boot version 2.4.5
* Lombok 
* H2
* Swagger 2

## Documentation

Go to http://localhost:8080/swagger-ui.html#/ to see API documentation 

## Endpoints
* POST - upload file "http=//localhost:8080/file/upload"
* GET - get list of files "http=//localhost:8080/file/files"
* GET - get file by id "http=//localhost:8080/file/file/{id}"
* GET - get JSON list of files "http=//localhost:8080/json/list"
* GET - get JSON about current file "http=//localhost:8080/json/{id}"

