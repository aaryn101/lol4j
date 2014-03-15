package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicDataStatsDto {
    @JsonProperty("FlatArmorMod")
    private double flatArmorMod;
    @JsonProperty("FlatAttackSpeedMod")
    private double flatAttackSpeedMod;
    @JsonProperty("FlatBlockMod")
    private double flatBlockMod;
    @JsonProperty("FlatCritChanceMod")
    private double flatCritChanceMod;
    @JsonProperty("FlatCritDamageMod")
    private double flatCritDamageMod;
    @JsonProperty("FlatEXPBonus")
    private double flatExpBonus;
    @JsonProperty("FlatEnergyPoolMod")
    private double flatEnergyPoolMod;
    @JsonProperty("FlatEnergyRegenMod")
    private double flatEnergyRegenMod;
    @JsonProperty("FlatHPPoolMod")
    private double flatHpPoolMod;
    @JsonProperty("FlatHPRegenMod")
    private double flatHpRegenMod;
    @JsonProperty("FlatMPPoolMod")
    private double flatMpPoolMod;
    @JsonProperty("FlatMPRegenMod")
    private double flatMpRegenMod;
    @JsonProperty("FlatMagicDamageMod")
    private double flatMagicDamageMod;
    @JsonProperty("FlatMovementSpeedMod")
    private double flatMovementSpeedMod;
    @JsonProperty("FlatPhysicalDamageMod")
    private double flatPhysicalDamageMod;
    @JsonProperty("FlatSpellBlockMod")
    private double flatSpellBlockMod;
    @JsonProperty("PercentArmorMod")
    private double percentArmorMod;
    @JsonProperty("PercentAttackSpeedMod")
    private double percentAttackSpeedMod;
    @JsonProperty("PercentBlockMod")
    private double percentBlockMod;
    @JsonProperty("PercentCritChanceMod")
    private double percentCritChanceMod;
    @JsonProperty("PercentCritDamageMod")
    private double percentCritDamageMod;
    @JsonProperty("PercentDodgeMod")
    private double percentDodgeMod;
    @JsonProperty("PercentEXPBonus")
    private double percentExpBonus;
    @JsonProperty("PercentHPPoolMod")
    private double percentHpPoolMod;
    @JsonProperty("PercentHPRegenMod")
    private double percentHpRegenMod;
    @JsonProperty("PercentLifeStealMod")
    private double percentLifeStealMod;
    @JsonProperty("PercentMPPoolMod")
    private double percentMpPoolMod;
    @JsonProperty("PercentMPRegenMod")
    private double percentMpRegenMod;
    @JsonProperty("PercentMagicDamageMod")
    private double percentMagicDamageMod;
    @JsonProperty("PercentMovementSpeedMod")
    private double percentMovementSpeedMod;
    @JsonProperty("PercentPhysicalDamageMod")
    private double percentPhysicalDamageMod;
    @JsonProperty("PercentSpellBlockMod")
    private double percentSpellBlockMod;
    @JsonProperty("PercentSpellVampMod")
    private double percentSpellVampMod;
    private double rFlatArmorModPerLevel;
    private double rFlatArmorPenetrationMod;
    private double rFlatArmorPenetrationModPerLevel;
    private double rFlatCritChanceModPerLevel;
    private double rFlatCritDamageModPerLevel;
    private double rFlatDodgeMod;
    private double rFlatDodgeModPerLevel;
    private double rFlatEnergyModPerLevel;
    private double rFlatEnergyRegenModPerLevel;
    private double rFlatGoldPer10Mod;
    @JsonProperty("rFlatHPModPerLevel")
    private double rFlatHpModPerLevel;
    @JsonProperty("rFlatHPRegenModPerLevel")
    private double rFlatHpRegenModPerLevel;
    @JsonProperty("rFlatMPModPerLevel")
    private double rFlatMpModPerLevel;
    @JsonProperty("rFlatMPRegenModPerLevel")
    private double rFlatMpRegenModPerLevel;
    private double rFlatMagicDamageModPerLevel;
    private double rFlatMagicPenetrationMod;
    private double rFlatMagicPenetrationModPerLevel;
    private double rFlatMovementSpeedModPerLevel;
    private double rFlatPhysicalDamageModPerLevel;
    private double rFlatSpellBlockModPerLevel;
    private double rFlatTimeDeadMod;
    private double rFlatTimeDeadModPerLevel;
    private double rPercentArmorPenetrationMod;
    private double rPercentArmorPenetrationModPerLevel;
    private double rPercentAttackSpeedModPerLevel;
    private double rPercentCooldownMod;
    private double rPercentCooldownModPerLevel;
    private double rPercentMagicPenetrationMod;
    private double rPercentMagicPenetrationModPerLevel;
    private double rPercentMovementSpeedModPerLevel;
    private double rPercentTimeDead;
    private double rPercentTimeDeadModPerLevel;

    public double getFlatArmorMod() {
        return flatArmorMod;
    }

    public void setFlatArmorMod(double flatArmorMod) {
        this.flatArmorMod = flatArmorMod;
    }

    public double getFlatAttackSpeedMod() {
        return flatAttackSpeedMod;
    }

    public void setFlatAttackSpeedMod(double flatAttackSpeedMod) {
        this.flatAttackSpeedMod = flatAttackSpeedMod;
    }

    public double getFlatBlockMod() {
        return flatBlockMod;
    }

    public void setFlatBlockMod(double flatBlockMod) {
        this.flatBlockMod = flatBlockMod;
    }

    public double getFlatCritChanceMod() {
        return flatCritChanceMod;
    }

    public void setFlatCritChanceMod(double flatCritChanceMod) {
        this.flatCritChanceMod = flatCritChanceMod;
    }

    public double getFlatCritDamageMod() {
        return flatCritDamageMod;
    }

    public void setFlatCritDamageMod(double flatCritDamageMod) {
        this.flatCritDamageMod = flatCritDamageMod;
    }

    public double getFlatExpBonus() {
        return flatExpBonus;
    }

    public void setFlatExpBonus(double flatExpBonus) {
        this.flatExpBonus = flatExpBonus;
    }

    public double getFlatEnergyPoolMod() {
        return flatEnergyPoolMod;
    }

    public void setFlatEnergyPoolMod(double flatEnergyPoolMod) {
        this.flatEnergyPoolMod = flatEnergyPoolMod;
    }

    public double getFlatEnergyRegenMod() {
        return flatEnergyRegenMod;
    }

    public void setFlatEnergyRegenMod(double flatEnergyRegenMod) {
        this.flatEnergyRegenMod = flatEnergyRegenMod;
    }

    public double getFlatHpPoolMod() {
        return flatHpPoolMod;
    }

    public void setFlatHpPoolMod(double flatHpPoolMod) {
        this.flatHpPoolMod = flatHpPoolMod;
    }

    public double getFlatHpRegenMod() {
        return flatHpRegenMod;
    }

    public void setFlatHpRegenMod(double flatHpRegenMod) {
        this.flatHpRegenMod = flatHpRegenMod;
    }

    public double getFlatMpPoolMod() {
        return flatMpPoolMod;
    }

    public void setFlatMpPoolMod(double flatMpPoolMod) {
        this.flatMpPoolMod = flatMpPoolMod;
    }

    public double getFlatMpRegenMod() {
        return flatMpRegenMod;
    }

    public void setFlatMpRegenMod(double flatMpRegenMod) {
        this.flatMpRegenMod = flatMpRegenMod;
    }

    public double getFlatMagicDamageMod() {
        return flatMagicDamageMod;
    }

    public void setFlatMagicDamageMod(double flatMagicDamageMod) {
        this.flatMagicDamageMod = flatMagicDamageMod;
    }

    public double getFlatMovementSpeedMod() {
        return flatMovementSpeedMod;
    }

    public void setFlatMovementSpeedMod(double flatMovementSpeedMod) {
        this.flatMovementSpeedMod = flatMovementSpeedMod;
    }

    public double getFlatPhysicalDamageMod() {
        return flatPhysicalDamageMod;
    }

    public void setFlatPhysicalDamageMod(double flatPhysicalDamageMod) {
        this.flatPhysicalDamageMod = flatPhysicalDamageMod;
    }

    public double getFlatSpellBlockMod() {
        return flatSpellBlockMod;
    }

    public void setFlatSpellBlockMod(double flatSpellBlockMod) {
        this.flatSpellBlockMod = flatSpellBlockMod;
    }

    public double getPercentArmorMod() {
        return percentArmorMod;
    }

    public void setPercentArmorMod(double percentArmorMod) {
        this.percentArmorMod = percentArmorMod;
    }

    public double getPercentAttackSpeedMod() {
        return percentAttackSpeedMod;
    }

    public void setPercentAttackSpeedMod(double percentAttackSpeedMod) {
        this.percentAttackSpeedMod = percentAttackSpeedMod;
    }

    public double getPercentBlockMod() {
        return percentBlockMod;
    }

    public void setPercentBlockMod(double percentBlockMod) {
        this.percentBlockMod = percentBlockMod;
    }

    public double getPercentCritChanceMod() {
        return percentCritChanceMod;
    }

    public void setPercentCritChanceMod(double percentCritChanceMod) {
        this.percentCritChanceMod = percentCritChanceMod;
    }

    public double getPercentCritDamageMod() {
        return percentCritDamageMod;
    }

    public void setPercentCritDamageMod(double percentCritDamageMod) {
        this.percentCritDamageMod = percentCritDamageMod;
    }

    public double getPercentDodgeMod() {
        return percentDodgeMod;
    }

    public void setPercentDodgeMod(double percentDodgeMod) {
        this.percentDodgeMod = percentDodgeMod;
    }

    public double getPercentExpBonus() {
        return percentExpBonus;
    }

    public void setPercentExpBonus(double percentExpBonus) {
        this.percentExpBonus = percentExpBonus;
    }

    public double getPercentHpPoolMod() {
        return percentHpPoolMod;
    }

    public void setPercentHpPoolMod(double percentHpPoolMod) {
        this.percentHpPoolMod = percentHpPoolMod;
    }

    public double getPercentHpRegenMod() {
        return percentHpRegenMod;
    }

    public void setPercentHpRegenMod(double percentHpRegenMod) {
        this.percentHpRegenMod = percentHpRegenMod;
    }

    public double getPercentLifeStealMod() {
        return percentLifeStealMod;
    }

    public void setPercentLifeStealMod(double percentLifeStealMod) {
        this.percentLifeStealMod = percentLifeStealMod;
    }

    public double getPercentMpPoolMod() {
        return percentMpPoolMod;
    }

    public void setPercentMpPoolMod(double percentMpPoolMod) {
        this.percentMpPoolMod = percentMpPoolMod;
    }

    public double getPercentMpRegenMod() {
        return percentMpRegenMod;
    }

    public void setPercentMpRegenMod(double percentMpRegenMod) {
        this.percentMpRegenMod = percentMpRegenMod;
    }

    public double getPercentMagicDamageMod() {
        return percentMagicDamageMod;
    }

    public void setPercentMagicDamageMod(double percentMagicDamageMod) {
        this.percentMagicDamageMod = percentMagicDamageMod;
    }

    public double getPercentMovementSpeedMod() {
        return percentMovementSpeedMod;
    }

    public void setPercentMovementSpeedMod(double percentMovementSpeedMod) {
        this.percentMovementSpeedMod = percentMovementSpeedMod;
    }

    public double getPercentPhysicalDamageMod() {
        return percentPhysicalDamageMod;
    }

    public void setPercentPhysicalDamageMod(double percentPhysicalDamageMod) {
        this.percentPhysicalDamageMod = percentPhysicalDamageMod;
    }

    public double getPercentSpellBlockMod() {
        return percentSpellBlockMod;
    }

    public void setPercentSpellBlockMod(double percentSpellBlockMod) {
        this.percentSpellBlockMod = percentSpellBlockMod;
    }

    public double getPercentSpellVampMod() {
        return percentSpellVampMod;
    }

    public void setPercentSpellVampMod(double percentSpellVampMod) {
        this.percentSpellVampMod = percentSpellVampMod;
    }

    public double getrFlatArmorModPerLevel() {
        return rFlatArmorModPerLevel;
    }

    public void setrFlatArmorModPerLevel(double rFlatArmorModPerLevel) {
        this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
    }

    public double getrFlatArmorPenetrationMod() {
        return rFlatArmorPenetrationMod;
    }

    public void setrFlatArmorPenetrationMod(double rFlatArmorPenetrationMod) {
        this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
    }

    public double getrFlatArmorPenetrationModPerLevel() {
        return rFlatArmorPenetrationModPerLevel;
    }

    public void setrFlatArmorPenetrationModPerLevel(double rFlatArmorPenetrationModPerLevel) {
        this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
    }

    public double getrFlatCritChanceModPerLevel() {
        return rFlatCritChanceModPerLevel;
    }

    public void setrFlatCritChanceModPerLevel(double rFlatCritChanceModPerLevel) {
        this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
    }

    public double getrFlatCritDamageModPerLevel() {
        return rFlatCritDamageModPerLevel;
    }

    public void setrFlatCritDamageModPerLevel(double rFlatCritDamageModPerLevel) {
        this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
    }

    public double getrFlatDodgeMod() {
        return rFlatDodgeMod;
    }

    public void setrFlatDodgeMod(double rFlatDodgeMod) {
        this.rFlatDodgeMod = rFlatDodgeMod;
    }

    public double getrFlatDodgeModPerLevel() {
        return rFlatDodgeModPerLevel;
    }

    public void setrFlatDodgeModPerLevel(double rFlatDodgeModPerLevel) {
        this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
    }

    public double getrFlatEnergyModPerLevel() {
        return rFlatEnergyModPerLevel;
    }

    public void setrFlatEnergyModPerLevel(double rFlatEnergyModPerLevel) {
        this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
    }

    public double getrFlatEnergyRegenModPerLevel() {
        return rFlatEnergyRegenModPerLevel;
    }

    public void setrFlatEnergyRegenModPerLevel(double rFlatEnergyRegenModPerLevel) {
        this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
    }

    public double getrFlatGoldPer10Mod() {
        return rFlatGoldPer10Mod;
    }

    public void setrFlatGoldPer10Mod(double rFlatGoldPer10Mod) {
        this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
    }

    public double getrFlatHpModPerLevel() {
        return rFlatHpModPerLevel;
    }

    public void setrFlatHpModPerLevel(double rFlatHpModPerLevel) {
        this.rFlatHpModPerLevel = rFlatHpModPerLevel;
    }

    public double getrFlatHpRegenModPerLevel() {
        return rFlatHpRegenModPerLevel;
    }

    public void setrFlatHpRegenModPerLevel(double rFlatHpRegenModPerLevel) {
        this.rFlatHpRegenModPerLevel = rFlatHpRegenModPerLevel;
    }

    public double getrFlatMpModPerLevel() {
        return rFlatMpModPerLevel;
    }

    public void setrFlatMpModPerLevel(double rFlatMpModPerLevel) {
        this.rFlatMpModPerLevel = rFlatMpModPerLevel;
    }

    public double getrFlatMpRegenModPerLevel() {
        return rFlatMpRegenModPerLevel;
    }

    public void setrFlatMpRegenModPerLevel(double rFlatMpRegenModPerLevel) {
        this.rFlatMpRegenModPerLevel = rFlatMpRegenModPerLevel;
    }

    public double getrFlatMagicDamageModPerLevel() {
        return rFlatMagicDamageModPerLevel;
    }

    public void setrFlatMagicDamageModPerLevel(double rFlatMagicDamageModPerLevel) {
        this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
    }

    public double getrFlatMagicPenetrationMod() {
        return rFlatMagicPenetrationMod;
    }

    public void setrFlatMagicPenetrationMod(double rFlatMagicPenetrationMod) {
        this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
    }

    public double getrFlatMagicPenetrationModPerLevel() {
        return rFlatMagicPenetrationModPerLevel;
    }

    public void setrFlatMagicPenetrationModPerLevel(double rFlatMagicPenetrationModPerLevel) {
        this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
    }

    public double getrFlatMovementSpeedModPerLevel() {
        return rFlatMovementSpeedModPerLevel;
    }

    public void setrFlatMovementSpeedModPerLevel(double rFlatMovementSpeedModPerLevel) {
        this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
    }

    public double getrFlatPhysicalDamageModPerLevel() {
        return rFlatPhysicalDamageModPerLevel;
    }

    public void setrFlatPhysicalDamageModPerLevel(double rFlatPhysicalDamageModPerLevel) {
        this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
    }

    public double getrFlatSpellBlockModPerLevel() {
        return rFlatSpellBlockModPerLevel;
    }

    public void setrFlatSpellBlockModPerLevel(double rFlatSpellBlockModPerLevel) {
        this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
    }

    public double getrFlatTimeDeadMod() {
        return rFlatTimeDeadMod;
    }

    public void setrFlatTimeDeadMod(double rFlatTimeDeadMod) {
        this.rFlatTimeDeadMod = rFlatTimeDeadMod;
    }

    public double getrFlatTimeDeadModPerLevel() {
        return rFlatTimeDeadModPerLevel;
    }

    public void setrFlatTimeDeadModPerLevel(double rFlatTimeDeadModPerLevel) {
        this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
    }

    public double getrPercentArmorPenetrationMod() {
        return rPercentArmorPenetrationMod;
    }

    public void setrPercentArmorPenetrationMod(double rPercentArmorPenetrationMod) {
        this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
    }

    public double getrPercentArmorPenetrationModPerLevel() {
        return rPercentArmorPenetrationModPerLevel;
    }

    public void setrPercentArmorPenetrationModPerLevel(double rPercentArmorPenetrationModPerLevel) {
        this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
    }

    public double getrPercentAttackSpeedModPerLevel() {
        return rPercentAttackSpeedModPerLevel;
    }

    public void setrPercentAttackSpeedModPerLevel(double rPercentAttackSpeedModPerLevel) {
        this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
    }

    public double getrPercentCooldownMod() {
        return rPercentCooldownMod;
    }

    public void setrPercentCooldownMod(double rPercentCooldownMod) {
        this.rPercentCooldownMod = rPercentCooldownMod;
    }

    public double getrPercentCooldownModPerLevel() {
        return rPercentCooldownModPerLevel;
    }

    public void setrPercentCooldownModPerLevel(double rPercentCooldownModPerLevel) {
        this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
    }

    public double getrPercentMagicPenetrationMod() {
        return rPercentMagicPenetrationMod;
    }

    public void setrPercentMagicPenetrationMod(double rPercentMagicPenetrationMod) {
        this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
    }

    public double getrPercentMagicPenetrationModPerLevel() {
        return rPercentMagicPenetrationModPerLevel;
    }

    public void setrPercentMagicPenetrationModPerLevel(double rPercentMagicPenetrationModPerLevel) {
        this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
    }

    public double getrPercentMovementSpeedModPerLevel() {
        return rPercentMovementSpeedModPerLevel;
    }

    public void setrPercentMovementSpeedModPerLevel(double rPercentMovementSpeedModPerLevel) {
        this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
    }

    public double getrPercentTimeDead() {
        return rPercentTimeDead;
    }

    public void setrPercentTimeDead(double rPercentTimeDead) {
        this.rPercentTimeDead = rPercentTimeDead;
    }

    public double getrPercentTimeDeadModPerLevel() {
        return rPercentTimeDeadModPerLevel;
    }

    public void setrPercentTimeDeadModPerLevel(double rPercentTimeDeadModPerLevel) {
        this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
    }
}
