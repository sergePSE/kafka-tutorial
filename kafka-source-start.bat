set kafka_dir=C:\tmp\kafka

start cmd /c call %kafka_dir%\bin\windows\zookeeper-server-start.bat %kafka_dir%\config\zookeeper.properties
timeout /t 10 /nobreak >nul
start cmd /c call %kafka_dir%\bin\windows\kafka-server-start.bat %kafka_dir%\config\server.properties
timeout /t 15 /nobreak >nul

echo Started. Press any key...
pause >nul
exit /b