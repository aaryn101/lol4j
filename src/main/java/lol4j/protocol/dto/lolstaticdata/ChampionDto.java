package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionDto {
    @JsonProperty(value = "allytips")
    private List<String> allyTips = new ArrayList<>();
    private String blurb;
    @JsonProperty(value = "enemytips")
    private List<String> enemyTips = new ArrayList<>();
    private String id;
    private ImageDto image;
    private InfoDto info;
    private String key;
    private String lore;
    private String name;
    private String partype;
    private PassiveDto passive;
    private List<RecommendedDto> recommended = new ArrayList<>();
    private List<SkinDto> skins = new ArrayList<>();
    private List<ChampionSpellDto> spells = new ArrayList<>();
    private StatsDto stats;
    private List<String> tags = new ArrayList<>();
    private String title;

    public List<String> getAllyTips() {
        return allyTips;
    }

    public List<String> getEnemyTips() {
        return enemyTips;
    }

    public List<RecommendedDto> getRecommended() {
        return recommended;
    }

    public List<SkinDto> getSkins() {
        return skins;
    }

    public List<ChampionSpellDto> getSpells() {
        return spells;
    }

    public List<String> getTags() {
        return tags;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public PassiveDto getPassive() {
        return passive;
    }

    public void setPassive(PassiveDto passive) {
        this.passive = passive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public StatsDto getStats() {
        return stats;
    }

    public void setStats(StatsDto stats) {
        this.stats = stats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
