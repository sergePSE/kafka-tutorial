import java.util.Properties;

public class ConfigProvider {
    public static Properties provideProperties() {
        Properties props = new Properties();
        // url of any of broker or multiple urls
        props.setProperty("bootstrap.servers", "localhost:9092");
        // consumer group id. Same topic can be consumed and partitioned by multiple applications
        props.setProperty("group.id", "test");
        // producer id. Identify producer (data source)
        props.setProperty("client.id", "test");
        // commit read messages to start application with new one only
        props.setProperty("auto.offset.reset", "earliest");
        // default key and value de/serializers, for simplicity is string here
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }
}
