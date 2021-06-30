package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigVals {

    private final Integer valuePerSlotT1;
    private final Integer valuePerSlotT2;
    private final Integer valuePerSlotT3;
    private final Integer valuePerSlotT4;
    private final Integer valuePerSlotT5;
    private final Integer valuePerSlotT6;
    private final Integer valuePerSlotT7;
    private final Integer valuePerSlotT8;
    private final Integer valuePerSlotT9;

    public Integer getValuePerSlotT1() {
        return valuePerSlotT1;
    }
    public Integer getValuePerSlotT2() {
        return valuePerSlotT2;
    }
    public Integer getValuePerSlotT3() {
        return valuePerSlotT3;
    }
    public Integer getValuePerSlotT4() {
        return valuePerSlotT4;
    }
    public Integer getValuePerSlotT5() {
        return valuePerSlotT5;
    }
    public Integer getValuePerSlotT6() {
        return valuePerSlotT6;
    }
    public Integer getValuePerSlotT7() {
        return valuePerSlotT7;
    }
    public Integer getValuePerSlotT8() {
        return valuePerSlotT8;
    }
    public Integer getValuePerSlotT9() {
        return valuePerSlotT9;
    }

    public ConfigVals() {

        FileConfiguration c = DankTech.getInstance().getConfig();

        valuePerSlotT1 = c.getInt("VALUES.AMOUNT_PER_SLOT_T1");
        valuePerSlotT2 = c.getInt("VALUES.AMOUNT_PER_SLOT_T2");
        valuePerSlotT3 = c.getInt("VALUES.AMOUNT_PER_SLOT_T3");
        valuePerSlotT4 = c.getInt("VALUES.AMOUNT_PER_SLOT_T4");
        valuePerSlotT5 = c.getInt("VALUES.AMOUNT_PER_SLOT_T5");
        valuePerSlotT6 = c.getInt("VALUES.AMOUNT_PER_SLOT_T6");
        valuePerSlotT7 = c.getInt("VALUES.AMOUNT_PER_SLOT_T7");
        valuePerSlotT8 = c.getInt("VALUES.AMOUNT_PER_SLOT_T8");
        valuePerSlotT9 = c.getInt("VALUES.AMOUNT_PER_SLOT_T9");

    }

}
