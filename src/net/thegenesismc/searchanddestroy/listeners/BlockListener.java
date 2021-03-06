package net.thegenesismc.searchanddestroy.listeners;

import net.thegenesismc.searchanddestroy.SND;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (SND.gm.isPlaying(e.getPlayer())||SND.lm.isInLobby(e.getPlayer())||SND.sm.isSpectator(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (SND.gm.isPlaying(e.getPlayer())) {
            if (e.getBlock().getType()!=Material.STONE_PLATE) {
                e.setCancelled(true);
            } else {
                SND.pressurePlateList.add(e.getBlock());
            }
        } else if (SND.sm.isSpectator(e.getPlayer())||SND.lm.isInLobby(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

}
