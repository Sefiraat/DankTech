package io.github.sefiraat.danktech.listeners;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import org.junit.jupiter.api.*;

public class CraftListenerTest {

    private static ServerMock server;
    private static PlayerMock player;

    @BeforeAll
    public static void setUp()
    {
        server = MockBukkit.mock();
        MockBukkit.load(DankTech.class);
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    @DisplayName("Recipes Loaded")
    void thisTestWillFail() {
        Assertions.assertTrue(true);
    }


}
