package me.christallinqq.killcommand;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class KillCommand extends JavaPlugin implements Listener {
   public void onEnable() {
      this.getServer().getPluginManager().registerEvents(this, this);
   }

   public void onDisable() {
   }

   @EventHandler(
      priority = EventPriority.NORMAL,
      ignoreCancelled = true
   )
   public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent var1) {
      String var2 = var1.getMessage().toLowerCase();
      if (var2.startsWith("/kill ") || var2.equals("/kill")) {
         Player var3 = var1.getPlayer();
         if (var3 != null) {
            if (!var3.hasPermission("minecraft.command.kill")) {
               var3.setHealth(0.0D);
               var1.setCancelled(true);
            }
         }
      }
   }
}
