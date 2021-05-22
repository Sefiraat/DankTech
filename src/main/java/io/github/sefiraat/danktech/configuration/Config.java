package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;

public class Config {

    private final DankTech parent;
    private ConfigStrings strings;

    public ConfigStrings getStrings() {
        return strings;
    }





     public Config(DankTech parent) {
         this.parent = parent;
         strings = new ConfigStrings(parent);
     }
}
