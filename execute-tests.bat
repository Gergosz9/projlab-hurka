@echo off
cls

rem Delete the existing "classes" folder if it exists
if exist classes rmdir /s /q classes

rem Create the "classes" folder
mkdir classes

REM Parameters
set LIB_DIR=libs
set MAIN_CLASS=Java.Test

rem Compile source files from "src" folder
javac -d classes/ -cp "%LIB_DIR%\gson-2.8.2.jar;src;classes" src\Java\Characters\*.java src\Java\util\*.java src\Java\*.java

rem Compile test files from "test" folder
javac -d classes/ -cp "%LIB_DIR%\gson-2.8.2.jar;test;classes" test\Java\Commands\*.java test\Java\*.java
rem javac -cp classes -d classes test\*.java

rem Run the main class
java -cp "%LIB_DIR%\gson-2.8.2.jar;classes" %MAIN_CLASS%