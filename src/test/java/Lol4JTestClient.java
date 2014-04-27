import lol4j.client.Lol4JClient;
import lol4j.client.impl.Lol4JClientImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class Lol4JTestClient {
    private static Lol4JTestClient instance;

    private String apiKey = null;
    private int numPerTenSeconds;
    private int numPerTenMinutes;
    private Lol4JClientImpl client = null;

    private Lol4JTestClient() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(new File("junit.properties")));
            apiKey = p.getProperty("api.key");
            numPerTenMinutes = Integer.parseInt(p.getProperty("rate.per10minutes"));
            numPerTenSeconds = Integer.parseInt(p.getProperty("rate.per10seconds"));
            client = new Lol4JClientImpl(apiKey);
            client.setRateLimit(numPerTenSeconds, numPerTenMinutes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Lol4JTestClient getInstance() {
        if (instance == null) {
            instance = new Lol4JTestClient();
        }
        return instance;
    }

    public static Lol4JClient getClient() {
        return getInstance().client;
    }

    public static int getNumPerTenSeconds() {
        return getInstance().numPerTenSeconds;
    }

    public static int getNumPerTenMinutes() {
        return getInstance().numPerTenMinutes;
    }
}
