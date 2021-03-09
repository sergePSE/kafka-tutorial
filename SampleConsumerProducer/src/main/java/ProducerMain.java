import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerMain {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Format: <sourceFileName> <topic name>");
            return;
        }
        long counter = 0;
        String topic = args[1];
        try (KafkaProducer<String, String> producer = generateProducer()) {
            try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                for(String line; (line = br.readLine()) != null; ) {
                    // process the line.
                    String[] split = line.split(":", 2);
                    String key  = split[0];
                    String value = split[1];
                    // send message with producer
                    // assign partition automatically
                    producer.send(new ProducerRecord<>(topic, key, value));
                    System.out.printf("message %d sent: %s%n", ++counter, line);
                }
            }
        }
        System.out.printf("Finished %d", counter);
    }

    private static KafkaProducer<String, String> generateProducer() {
        return new KafkaProducer<>(ConfigProvider.provideProperties());
    }
}
