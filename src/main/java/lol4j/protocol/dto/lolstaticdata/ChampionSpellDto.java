package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionSpellDto {
    private List<Integer> cooldown = new ArrayList<>();
    private String cooldownBurn;
    private List<Integer> cost = new ArrayList<>();
    private String costBurn;
    private String costType;
    private String description;
    private List<Object> effect = new ArrayList<>();
    private List<String> effectBurn = new ArrayList<>();
    private String id;
    private ImageDto image;
    @JsonProperty(value = "leveltip")
    private LevelTipDto levelTip;
    @JsonProperty(value = "maxrank")
    private int maxRank;
    private String name;
    private Object range;
    private String rangeBurn;
    private String resource;
    private String tooltip;
    private List<SpellVarsDto> vars = new ArrayList<>();

    public List<Integer> getCooldown() {
        return cooldown;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public List<Object> getEffect() {
        return effect;
    }

    public List<String> getEffectBurn() {
        return effectBurn;
    }

    public List<SpellVarsDto> getVars() {
        return vars;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public int getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(int maxRank) {
        this.maxRank = maxRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRange() {
        return range;
    }

    public void setRange(Object range) {
        this.range = range;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public LevelTipDto getLevelTip() {
        return levelTip;
    }

    public void setLevelTip(LevelTipDto levelTip) {
        this.levelTip = levelTip;
    }
}
