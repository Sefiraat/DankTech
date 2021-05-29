package io.github.sefiraat.danktech.items;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.*;

import static io.github.sefiraat.danktech.misc.ContainerStorage.*;
import static io.github.sefiraat.danktech.misc.Utils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemsTest {

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

    public Integer testDankLevel(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (isDank(item,plugin)) {
                return getDankLevel(item, plugin);
            }
        }
        return 0;
    }

    public Integer testTrashLevel(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (isTrash(item,plugin)) {
                return getTrashLevel(item, plugin);
            }
        }
        return 0;
    }

    public Integer testCellLevel(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (isDankMaterial(item,plugin)) {
                plugin.getInstance().getServer().getLogger().info("Cell Dank");
                plugin.getInstance().getServer().getLogger().info("" + getCellLevel(item, plugin));
                return getCellLevel(item, plugin);
            }
        }
        return 0;
    }

    @Test
    @DisplayName("Give Cell")
    @Order(1)
    public void testGiveCell() {
        boolean b = true;
        for (int i = 1; i < 10; i++) {
            playerOp.getInventory().clear();
            givePlayerCell(playerOp.getPlayer(), i, 1, plugin);
            boolean cellValid = testCellLevel(playerOp).equals(i);
            plugin.getInstance().getServer().getLogger().info("Testing cell " + i + ": " + cellValid);
            if (!cellValid) { b = false; }
        }
        Assertions.assertTrue(b);
    }

    @Test
    @Order(2)
    @DisplayName("Give Danks")
    public void testGiveDank() {
        boolean b = true;
        for (int i = 1; i < 10; i++) {
            playerOp.getInventory().clear();
            givePlayerDank(playerOp.getPlayer(), i, plugin);
            boolean dankValid = testDankLevel(playerOp).equals(i);
            plugin.getInstance().getServer().getLogger().info("Testing dank pack " + i + ": " + dankValid);
            if (!dankValid) { b = false; }
        }
        Assertions.assertTrue(b);
    }

    @Test
    @Order(3)
    @DisplayName("Recover Danks")
    public void testRecoverDank() {
        boolean b = true;
        for (int i = 1; i < 10; i++) {
            playerOp.getInventory().clear();
            recoverDankByID(playerOp.getPlayer(), plugin, i);
            boolean dankValid = testDankLevel(playerOp).equals(i);
            plugin.getInstance().getServer().getLogger().info("Testing recovered dank pack " + i + ": " + dankValid);
            if (!dankValid) { b = false; }
        }
        Assertions.assertTrue(b);
    }


    @Test
    @Order(4)
    @DisplayName("Give Trash")
    public void testGiveTrash() {
        boolean b = true;
        for (int i = 1; i < 10; i++) {
            playerOp.getInventory().clear();
            givePlayerTrash(playerOp.getPlayer(), i, plugin);
            boolean trashValid = testTrashLevel(playerOp).equals(i);
            plugin.getInstance().getServer().getLogger().info("Testing trash pack " + i + ": " + trashValid);
            if (!trashValid) { b = false; }
        }
        Assertions.assertTrue(b);
    }

}
