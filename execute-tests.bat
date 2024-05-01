@echo off
cls

REM Set the path to your project
set PROJECT_DIR=out\production\projlab-hurka
set TEST_DIR=out\test\projlab-hurka

REM Set the classpath to include all JAR files
set LIB_DIR=libs
set MAIN_CLASS=Java.Test

REM Run the Java test
echo running tests...
java -cp "%LIB_DIR%\json-20140107.jar;%PROJECT_DIR%;%TEST_DIR%" %MAIN_CLASS%
