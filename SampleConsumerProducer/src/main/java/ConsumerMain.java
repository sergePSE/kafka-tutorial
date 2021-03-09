import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerMain {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Format: <topic name>");
            return;
        }
        long counter = 0;
        long emptyPollCount = 0;
        // create consumer with properties and consumer group
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(ConfigProvider.provideProperties());
        // subscribe on selected topic
        consumer.subscribe(Collections.singletonList(args[0]));
        do {
            // repeat cycle polling pack of messages every 100 ms
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            if (records.isEmpty()) {
                emptyPollCount++;
            } else {
                emptyPollCount = 0;
            }
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("consumed number: %d, %s:%s", ++counter, record.key(), record.value());

                // try commit later. Then application starts polling since that offset on restart
//                if (counter == 10) {
//                    consumer.commitSync();
//                    return;
//                }

            }
        } while (emptyPollCount < 20);
        System.out.printf("Finished %d", counter);

    }
}
