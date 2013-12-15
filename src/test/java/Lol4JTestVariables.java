import lol4j.client.Lol4JClient;
import lol4j.client.impl.Lol4JClientImpl;
import lol4j.util.Region;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public class Lol4JTestVariables {
    private static Lol4JTestVariables instance;

    private String apiKey = null;
    private String summonerName = null;
    private Long summonerId = null;
    private Region region = null;
    private int numPerTenSeconds;
    private int numPerTenMinutes;
    private Lol4JClientImpl client = null;

    private Lol4JTestVariables() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(new File("junit.properties")));
            apiKey = p.getProperty("api.key");
            summonerName = p.getProperty("summoner.name");
            summonerId = Long.parseLong(p.getProperty("summoner.id"));
            region = Region.valueOf(p.getProperty("region").toUpperCase());
            numPerTenMinutes = Integer.parseInt(p.getProperty("rate.per10minutes"));
            numPerTenSeconds = Integer.parseInt(p.getProperty("rate.per10seconds"));
            client = new Lol4JClientImpl(apiKey);
            client.setRateLimit(numPerTenSeconds, numPerTenMinutes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Lol4JTestVariables getInstance() {
        if (instance == null) {
            instance = new Lol4JTestVariables();
        }
        return instance;
    }

    public Lol4JClient getClient() {
        return client;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public Region getRegion() {
        return region;
    }

    public int getNumPerTenSeconds() {
        return numPerTenSeconds;
    }

    public int getNumPerTenMinutes() {
        return numPerTenMinutes;
    }
}
