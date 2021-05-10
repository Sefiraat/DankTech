package io.github.sefiraat.danktech.listeners;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class CraftListenerTest {

    private static ServerMock server;
    private static DankTech plugin;
    private static PlayerMock player;

    @BeforeAll
    public static void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
    }

    @AfterAll
    public static void tearDown() {
        MockBukkit.unmock();
    }


}
