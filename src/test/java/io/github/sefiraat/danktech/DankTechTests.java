package io.github.sefiraat.danktech;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DankTechTests {

    private ServerMock server;
    private DankTech plugin;

    @Before
    public void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
    }

    @After
    public void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    @DisplayName("Config files loaded")
    public void testConfigurations() {
        Assertions.assertNotNull(plugin.getDankStorageConfig());
    }


}
