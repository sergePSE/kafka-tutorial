sudo apt-get install openjdk-11-jdk
sudo apt-get install maven
curl --output kafka.tgz https://downloads.apache.org/kafka/2.7.0/kafka_2.13-2.7.0.tgz
tar -xf kafka.tgz
mv kafka_2.13-2.7.0 kafka
cd kafka
./bin/zookeeper-server-start.sh config/zookeeper.properties > /dev/null &
sleep 30
export KAFKA_HEAP_OPTS="-Xmx256M -Xms128M"
./bin/kafka-server-start.sh config/server.properties > /dev/null &
cd ..
wget https://github.com/obsidiandynamics/kafdrop/archive/3.27.0.tar.gz
tar -xzf 3.27.0.tar.gz
cd kafdrop-3.27.0
mvn clean package
java --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -jar target/kafdrop-3.27.0.jar  --kafka.brokerConnect=localhost:9092

 