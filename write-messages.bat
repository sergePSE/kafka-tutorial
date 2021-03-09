set kafka_dir=C:\tmp\kafka
call %kafka_dir%\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic user --property "parse.key=true" --property "key.separator=:" < kafka_users.txt
@REM call %kafka_dir%\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic message --property "parse.key=true" --property "key.separator=:" < kafka_messages.txt >nul

echo     Press any key to continue...
pause >nul