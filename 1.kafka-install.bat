set script_dir=%CD%
@REM curl.exe --output C:\tmp\kafka.tgz https://downloads.apache.org/kafka/2.7.0/kafka_2.13-2.7.0.tgz
cd C:\tmp
IF EXIST C:\tmp\kafka RMDIR /S /Q C:\tmp\kafka
tar -xf C:\tmp\kafka.tgz
@REM move C:\tmp\kafka_2.13-2.7.0 C:\tmp\kafka
@REM cd %script_dir%
@REM echo     Press any key to continue...
@REM pause >nul
@REM exit /b