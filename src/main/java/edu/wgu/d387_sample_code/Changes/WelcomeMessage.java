package edu.wgu.d387_sample_code.Changes;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Component
public class WelcomeMessage implements Runnable{

    public static List<String> message = Collections.synchronizedList(new ArrayList<>());

    Properties properties = new Properties();


    @Override
    public void run() {
        if (message.isEmpty()) {

            Thread thread1 = new Thread(() -> {
                try {
                    InputStream stream = new ClassPathResource("WelcomeMessage_en_US.properties").getInputStream();
                    properties.load(stream);
                    message.add(properties.getProperty("welcome"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    InputStream stream = new ClassPathResource("WelcomeMessage_fr_CA.properties").getInputStream();
                    properties.load(stream);
                    message.add(properties.getProperty("welcome"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
