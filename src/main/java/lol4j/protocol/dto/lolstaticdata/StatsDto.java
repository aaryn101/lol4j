package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatsDto {
    private double armor;
    @JsonProperty(value = "armorperlevel")
    private double armorPerLevel;
    @JsonProperty(value = "attackdamage")
    private double attackDamage;
    @JsonProperty(value = "attackdamageperlevel")
    private double attackDamagePerLevel;
    @JsonProperty(value = "attackrange")
    private double attackRange;
    @JsonProperty(value = "attackspeedoffset")
    private double attackSpeedOffset;
    @JsonProperty(value = "attackspeedperlevel")
    private double attackSpeedPerLevel;
    private double crit;
    @JsonProperty(value = "critperlevel")
    private double critPerLevel;
    private double hp;
    @JsonProperty(value = "hpperlevel")
    private double hpPerLevel;
    @JsonProperty(value = "hpregen")
    private double hpRegen;
    @JsonProperty(value = "hpregenperlevel")
    private double hpRegenPerLevel;
    @JsonProperty(value = "movespeed")
    private double moveSpeed;
    private double mp;
    @JsonProperty(value = "mpperlevel")
    private double mpPerLevel;
    @JsonProperty(value = "mpregen")
    private double mpRegen;
    @JsonProperty(value = "mpregenperlevel")
    private double mpRegenPerLevel;
    @JsonProperty(value = "spellblock")
    private double spellBlock;
    @JsonProperty(value = "spellblockperlevel")
    private double spellBlockPerLevel;

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getArmorPerLevel() {
        return armorPerLevel;
    }

    public void setArmorPerLevel(double armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackDamagePerLevel() {
        return attackDamagePerLevel;
    }

    public void setAttackDamagePerLevel(double attackDamagePerLevel) {
        this.attackDamagePerLevel = attackDamagePerLevel;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    public double getAttackSpeedOffset() {
        return attackSpeedOffset;
    }

    public void setAttackSpeedOffset(double attackSpeedOffset) {
        this.attackSpeedOffset = attackSpeedOffset;
    }

    public double getAttackSpeedPerLevel() {
        return attackSpeedPerLevel;
    }

    public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
        this.attackSpeedPerLevel = attackSpeedPerLevel;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getCritPerLevel() {
        return critPerLevel;
    }

    public void setCritPerLevel(double critPerLevel) {
        this.critPerLevel = critPerLevel;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHpPerLevel() {
        return hpPerLevel;
    }

    public void setHpPerLevel(double hpPerLevel) {
        this.hpPerLevel = hpPerLevel;
    }

    public double getHpRegen() {
        return hpRegen;
    }

    public void setHpRegen(double hpRegen) {
        this.hpRegen = hpRegen;
    }

    public double getHpRegenPerLevel() {
        return hpRegenPerLevel;
    }

    public void setHpRegenPerLevel(double hpRegenPerLevel) {
        this.hpRegenPerLevel = hpRegenPerLevel;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public double getMpPerLevel() {
        return mpPerLevel;
    }

    public void setMpPerLevel(double mpPerLevel) {
        this.mpPerLevel = mpPerLevel;
    }

    public double getMpRegen() {
        return mpRegen;
    }

    public void setMpRegen(double mpRegen) {
        this.mpRegen = mpRegen;
    }

    public double getMpRegenPerLevel() {
        return mpRegenPerLevel;
    }

    public void setMpRegenPerLevel(double mpRegenPerLevel) {
        this.mpRegenPerLevel = mpRegenPerLevel;
    }

    public double getSpellBlock() {
        return spellBlock;
    }

    public void setSpellBlock(double spellBlock) {
        this.spellBlock = spellBlock;
    }

    public double getSpellBlockPerLevel() {
        return spellBlockPerLevel;
    }

    public void setSpellBlockPerLevel(double spellBlockPerLevel) {
        this.spellBlockPerLevel = spellBlockPerLevel;
    }
}
