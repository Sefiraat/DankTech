package io.github.sefiraat.danktech.main;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;

import io.github.sefiraat.danktech.DankTech;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DankTechTest {

    private static ServerMock server;
    private static DankTech plugin;

    @BeforeAll
    public static void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    @DisplayName("Instance is initialized")
    void testInstance() {
        Assertions.assertNotNull(plugin.getInstance());
    }

    @Test
    @DisplayName("Config files loaded")
    void testConfigurations() {
        Assertions.assertNotNull(plugin.getDankStorageConfig());
    }

    @Test
    @DisplayName("Protections loaded")
    void testProtection() {
        Assertions.assertNotNull(plugin.getProtection());
    }


}
