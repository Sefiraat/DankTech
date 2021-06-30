package io.github.sefiraat.danktech.configuration;

public class Config {

    private final ConfigStrings strings;
    private final ConfigVals vals;
    private final ConfigBools bools;

    public ConfigStrings getStrings() {
        return strings;
    }
    public ConfigVals getVals() {
        return vals;
    }
    public ConfigBools getBools() {
        return bools;
    }

    public Config() {
        strings = new ConfigStrings();
        vals = new ConfigVals();
        bools = new ConfigBools();
    }

}
