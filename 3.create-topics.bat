set kafka_dir=C:\tmp\kafka
call %kafka_dir%\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 10 --topic user >nul && echo.
call %kafka_dir%\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 10 --topic message >nul && echo.

echo     Press any key to continue...
pause >nul