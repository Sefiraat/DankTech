package io.github.sefiraat.danktech.finals;

public final class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CONFIG_GETTER_SECTION_DANK_ID = "PACKS.PACKS_BY_ID";
    public static final String CONFIG_GETTER_SECTION_TRASH_ID = "PACKS.TRASH_BY_ID";

    public static final String CONFIG_GETTER_VAL_VOLUME = "VOLUME";
    public static final String CONFIG_GETTER_VAL_SLOT = "SLOT";
    public static final String CONFIG_GETTER_VAL_STACK = "STACK";
    public static final String CONFIG_GETTER_VAL_LEVEL = "LEVEL";

    public static final String KEY_SELECTED_SLOT = "dank-ss";
    public static final String KEY_LEVEL_DANK = "dank-level";
    public static final String KEY_ID_DANK = "dank-id";

    public static final String KEY_LEVEL_TRASH = "trash-level";
    public static final String KEY_ID_TRASH = "trash-id";

}
