set script_dir=%CD%
curl.exe --output C:\tmp\kafka.tgz https://ftp-stud.hs-esslingen.de/pub/Mirrors/ftp.apache.org/dist/kafka/2.7.0/kafka_2.13-2.7.0.tgz
cd C:\tmp
tar -xf C:\tmp\kafka.tgz
move C:\tmp\kafka_2.13-2.7.0 C:\tmp\kafka

echo     Press any key to continue...
pause >nul
exit /b