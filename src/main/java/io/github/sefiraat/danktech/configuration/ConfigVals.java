package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigVals {

    private Integer valuePerSlotT1;
    private Integer valuePerSlotT2;
    private Integer valuePerSlotT3;
    private Integer valuePerSlotT4;
    private Integer valuePerSlotT5;
    private Integer valuePerSlotT6;
    private Integer valuePerSlotT7;
    private Integer valuePerSlotT8;
    private Integer valuePerSlotT9;

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

    public ConfigVals(DankTech parent) {

        FileConfiguration c = parent.getConfig();

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
