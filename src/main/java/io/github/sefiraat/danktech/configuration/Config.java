package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;

public class Config {

    private final ConfigStrings strings;

    public ConfigStrings getStrings() {
        return strings;
    }

    public Config(DankTech parent) {
        strings = new ConfigStrings(parent);
    }
}
