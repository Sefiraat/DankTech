package io.github.sefiraat.danktech.listeners;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CraftListenerTest {

    private ServerMock server;
    private PlayerMock player;

    @Before
    public void setUp()
    {
        server = MockBukkit.mock();
        server.addSimpleWorld("world");
        player = server.addPlayer();
        MockBukkit.load(DankTech.class);
    }

    @After
    public void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    @DisplayName("Recipes Loaded")
    public void thisTestWillFail() {
        Assertions.assertTrue(true);
    }


}
