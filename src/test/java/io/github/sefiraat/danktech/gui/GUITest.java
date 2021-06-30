package io.github.sefiraat.danktech.gui;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GUITest {

    private static ServerMock server;
    private static DankTech plugin;
    private static PlayerMock playerNormal;

    @BeforeAll
    public static void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
        server.addSimpleWorld("world");
        playerNormal = server.addPlayer();
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

//    @Test
//    @DisplayName("Dank GUI")
//    @Order(1)
//    public void testDankGUI() {
//        for (int i = 1; i < 10; i++) {
//            playerNormal.getInventory().clear();
//            givePlayerDank(playerNormal.getPlayer(), i, plugin);
//            for (ItemStack item : playerNormal.getInventory()) {
//                if (isDank(item,plugin)) {
//                    int dankLevel = ContainerStorage.getDankLevel(item, DankTech.getInstance());
//                    long dankId = ContainerStorage.getDankId(item, DankTech.getInstance());
//                    playerNormal.sendMessage(Messages.messageEventOpenPack(dankId));
//                    Config.setDankLastOpenedBy(dankId, plugin, playerNormal);
//                    Gui g = getDankGUI(dankId, dankLevel, DankTech.getInstance());
//                    g.open(playerNormal);
//                    server.getLogger().info("GUI Opened");
//                }
//            }
//        }
//    }
//
//    @Test
//    @DisplayName("Trash GUI")
//    @Order(2)
//    public void testTrashGUI() {
//        for (int i = 1; i < 10; i++) {
//            playerNormal.getInventory().clear();
//            givePlayerTrash(playerNormal.getPlayer(), i, plugin);
//            for (ItemStack item : playerNormal.getInventory()) {
//                if (isTrash(item,plugin)) {
//                    int trashLevel = ContainerStorage.getTrashLevel(item, DankTech.getInstance());
//                    long trashId = ContainerStorage.getTrashId(item, DankTech.getInstance());
//                    playerNormal.sendMessage(Messages.messageEventOpenPack(trashId));
//                    Config.setDankLastOpenedBy(trashId, plugin, playerNormal);
//                    Gui g = getTrashGUI(trashId, trashLevel, DankTech.getInstance());
//                    g.open(playerNormal);
//                }
//            }
//        }
//    }
//
//    @Test
//    @DisplayName("Admin GUI")
//    @Order(3)
//    public void testAdminGUI() {
//        PaginatedGui adminGUI = AdminGUI.getDankAdminGUI(plugin);
//        adminGUI.open(playerNormal);
//    }

}
