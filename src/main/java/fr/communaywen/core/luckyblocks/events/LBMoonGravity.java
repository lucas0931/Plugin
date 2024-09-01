package fr.communaywen.core.luckyblocks.events;

import fr.communaywen.core.AywenCraftPlugin;
import fr.communaywen.core.credit.Credit;
import fr.communaywen.core.credit.Feature;
import fr.communaywen.core.luckyblocks.enums.EventType;
import fr.communaywen.core.luckyblocks.objects.LuckyBlockEvent;
import fr.communaywen.core.luckyblocks.objects.LuckyBlockListeners;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

@Feature("Lucky Blocks")
@Credit("Fnafgameur")
public class LBMoonGravity extends LuckyBlockEvent implements LuckyBlockListeners {

    public LBMoonGravity() {
        super("Gravité Lunaire!",
                "Gravité Lunaire pendant 1 minute !",
                0.5f,
                EventType.BONUS,
                new ItemStack(Material.WHITE_WOOL)
        );
    }

    public void onOpen(Player player, Block block) {
        player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.04);

        new BukkitRunnable() {
            public void run() {
                player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.08);
            }
        }.runTaskLater(AywenCraftPlugin.getInstance(), 20 * 60);
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.getPlayer().getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.08);
    }
}
