import lol4j.client.Lol4JClient;
import lol4j.client.impl.Lol4JClientImpl;
import lol4j.util.Region;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public abstract class AbstractResourceImplTest {
    private static String apiKey = null;
    private static String summonerName = null;
    private static Long summonerId = null;
    private static Region region = null;
    private static Lol4JClient client = null;

    @BeforeClass
    public static void init() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(new File("junit.properties")));
            apiKey = p.getProperty("api.key");
            summonerName = p.getProperty("summoner.name");
            summonerId = Long.parseLong(p.getProperty("summoner.id"));
            region = Region.valueOf(p.getProperty("region").toUpperCase());
            client = new Lol4JClientImpl(apiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Lol4JClient getClient() {
        return client;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getSummonerName() {
        return summonerName;
    }

    public static Long getSummonerId() {
        return summonerId;
    }

    public static Region getRegion() {
        return region;
    }
}
