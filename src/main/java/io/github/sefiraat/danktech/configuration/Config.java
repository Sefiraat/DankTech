package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;

public class Config {

    private final ConfigStrings strings;
    private final ConfigVals vals;

    public ConfigStrings getStrings() {
        return strings;
    }
    public ConfigVals getVals() {
        return vals;
    }

    public Config(DankTech parent) {
        strings = new ConfigStrings(parent);
        vals = new ConfigVals(parent);
    }
}
