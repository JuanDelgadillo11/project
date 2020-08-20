# project File Compressor
## @author: Juan Delgadillo
## Table of contents
* [Introduction](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## Introduction

  The Project permits to compress a file sent from Postman to a Java Project that uses the Spring framework and it returns the path where the file was saved.
This Project Will permit extends the functionality to recover the compressed file and also perform CRUD operations.

## Technologies
  Download the file compressors from the following pages and them to a thirdParty folder and mofify the application.properties file: 
https://www.7-zip.org/download.html
  Download any Version 18 and version 19
https://www.winrar.es/descargas
  Download any Version 5.91 and version 4
https://www.winzip.com/win/es/prod_down.html
  Download any Version 23 and version 24

## Setup
  This project needs: 
  1.Postmand configured at the following way:
    POST: localhost:8080/api/compress/compress-zevenzip
      KEY(Type)                   VALUE(description)
      fileCompressor(String)      7z     (7z/winrar/winzip)
      parameter     (String)      a      (Parameter to compress)
      version       (String)      18     (18/19)
      fileName      (String)      test1  (any name)
      fileFormat    (String)      7z     (Archive format, depends of the file compressor)
      file          (file)        (any file)
  2. Download the project
      Create a thirdParty folder and inside copy the folders of each file compressor (7z, WinRAR and WinZip) or just copy the folder of the file compressor that will be used.
  3. Configure the application.properties with the paths that will be used:
  Example.
      execute.zevenzip.project-folder = zevenzipProject/
      execute.zevenzip.version18 = C:/oop_project/thirdParty/compressor/7-Zip/version18/
      execute.zevenzip.version19 = C:/oop_project/thirdParty/compressor/7-Zip/version19/
      execute.zevenzip.compressedfolder = src/test/resources/compressedFiles/zevenzip/
  4. Run the project.
  


      
