//package io.github.sefiraat.danktech.items;
//
//import be.seeseemelk.mockbukkit.MockBukkit;
//import be.seeseemelk.mockbukkit.ServerMock;
//import be.seeseemelk.mockbukkit.entity.PlayerMock;
//import io.github.sefiraat.danktech.DankTech;
//import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemStack;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import static io.github.sefiraat.danktech.misc.ContainerStorage.getCellLevel;
//import static io.github.sefiraat.danktech.misc.ContainerStorage.getDankLevel;
//import static io.github.sefiraat.danktech.misc.ContainerStorage.getTrashLevel;
//import static io.github.sefiraat.danktech.misc.ContainerStorage.isDank;
//import static io.github.sefiraat.danktech.misc.ContainerStorage.isDankMaterial;
//import static io.github.sefiraat.danktech.misc.ContainerStorage.isTrash;
//import static io.github.sefiraat.danktech.misc.Utils.givePlayerCell;
//import static io.github.sefiraat.danktech.misc.Utils.givePlayerDank;
//import static io.github.sefiraat.danktech.misc.Utils.givePlayerTrash;
//import static io.github.sefiraat.danktech.misc.Utils.recoverDankByID;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class ItemsTest {
//
//    private static ServerMock server;
//    private static DankTech plugin;
//    private static PlayerMock playerOp;
//    private static PlayerMock playerNormal;
//
//    @BeforeAll
//    public static void setUp()
//    {
//        server = MockBukkit.mock();
//        plugin = MockBukkit.load(DankTech.class);
//        server.addSimpleWorld("world");
//        playerOp = server.addPlayer();
//        playerOp.setOp(true);
//        playerOp.setName("op");
//        playerNormal = server.addPlayer();
//    }
//
//    @AfterAll
//    public static void tearDown()
//    {
//        MockBukkit.unmock();
//    }
//
//    public Integer testDankLevel(Player player) {
//        for (ItemStack item : player.getInventory()) {
//            if (isDank(item)) {
//                return getDankLevel(item);
//            }
//        }
//        return 0;
//    }
//
//    public Integer testTrashLevel(Player player) {
//        for (ItemStack item : player.getInventory()) {
//            if (isTrash(item)) {
//                return getTrashLevel(item);
//            }
//        }
//        return 0;
//    }
//
//    public Integer testCellLevel(Player player) {
//        for (ItemStack item : player.getInventory()) {
//            if (isDankMaterial(item)) {
//                DankTech.getInstance().getServer().getLogger().info("Cell Dank");
//                DankTech.getInstance().getServer().getLogger().info("" + getCellLevel(item));
//                return getCellLevel(item);
//            }
//        }
//        return 0;
//    }
//
//    @Test
//    @DisplayName("Give Cell")
//    @Order(1)
//    public void testGiveCell() {
//        boolean b = true;
//        for (int i = 1; i < 10; i++) {
//            playerOp.getInventory().clear();
//            givePlayerCell(playerOp.getPlayer(), i, 1);
//            boolean cellValid = testCellLevel(playerOp).equals(i);
//            DankTech.getInstance().getServer().getLogger().info("Testing cell " + i + ": " + cellValid);
//            if (!cellValid) { b = false; }
//        }
//        Assertions.assertTrue(b);
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Give Danks")
//    public void testGiveDank() {
//        boolean b = true;
//        for (int i = 1; i < 10; i++) {
//            playerOp.getInventory().clear();
//            givePlayerDank(playerOp.getPlayer(), i);
//            boolean dankValid = testDankLevel(playerOp).equals(i);
//            DankTech.getInstance().getServer().getLogger().info("Testing dank pack " + i + ": " + dankValid);
//            if (!dankValid) { b = false; }
//        }
//        Assertions.assertTrue(b);
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("Recover Danks")
//    public void testRecoverDank() {
//        boolean b = true;
//        for (int i = 1; i < 10; i++) {
//            playerOp.getInventory().clear();
//            recoverDankByID(playerOp.getPlayer(), i);
//            boolean dankValid = testDankLevel(playerOp).equals(i);
//            DankTech.getInstance().getServer().getLogger().info("Testing recovered dank pack " + i + ": " + dankValid);
//            if (!dankValid) { b = false; }
//        }
//        Assertions.assertTrue(b);
//    }
//
//
//    @Test
//    @Order(4)
//    @DisplayName("Give Trash")
//    public void testGiveTrash() {
//        boolean b = true;
//        for (int i = 1; i < 10; i++) {
//            playerOp.getInventory().clear();
//            givePlayerTrash(playerOp.getPlayer(), i);
//            boolean trashValid = testTrashLevel(playerOp).equals(i);
//            DankTech.getInstance().getServer().getLogger().info("Testing trash pack " + i + ": " + trashValid);
//            if (!trashValid) { b = false; }
//        }
//        Assertions.assertTrue(b);
//    }
//
//}
