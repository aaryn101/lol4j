package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/17/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RealmDto {
    @JsonProperty("cdn")
    private String cdnBaseUrl;
    @JsonProperty("css")
    private String cssVersion;
    @JsonProperty("dd")
    private String dragonMagicVersion;
    @JsonProperty("l")
    private String defaultLanguage;
    @JsonProperty("lg")
    private String legacyScriptMode;
    @JsonProperty("n")
    private Map<String, String> dataTypeVersionMap = new HashMap<>();
    @JsonProperty("profileiconmax")
    private int profileIconMax;
    private String store;
    @JsonProperty("v")
    private String version;

    public Map<String, String> getDataTypeVersionMap() {
        return dataTypeVersionMap;
    }

    public String getCdnBaseUrl() {

        return cdnBaseUrl;
    }

    public void setCdnBaseUrl(String cdnBaseUrl) {
        this.cdnBaseUrl = cdnBaseUrl;
    }

    public String getCssVersion() {
        return cssVersion;
    }

    public void setCssVersion(String cssVersion) {
        this.cssVersion = cssVersion;
    }

    public String getDragonMagicVersion() {
        return dragonMagicVersion;
    }

    public void setDragonMagicVersion(String dragonMagicVersion) {
        this.dragonMagicVersion = dragonMagicVersion;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getLegacyScriptMode() {
        return legacyScriptMode;
    }

    public void setLegacyScriptMode(String legacyScriptMode) {
        this.legacyScriptMode = legacyScriptMode;
    }

    public int getProfileIconMax() {
        return profileIconMax;
    }

    public void setProfileIconMax(int profileIconMax) {
        this.profileIconMax = profileIconMax;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
