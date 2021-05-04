package io.github.sefiraat.danktech.commands;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.command.CommandResult;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.Messages;
import org.junit.jupiter.api.*;
import scala.Int;

public class CommandsTest {

    private static ServerMock server;
    private static DankTech plugin;
    private static PlayerMock playerOp;
    private static PlayerMock playerNormal;

    @BeforeAll
    public static void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
        server.addSimpleWorld("world");
        playerOp = server.addPlayer();
        playerOp.setOp(true);
        playerOp.setName("op");
        playerNormal = server.addPlayer();
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    public void testGiveDank() {

    }

}
