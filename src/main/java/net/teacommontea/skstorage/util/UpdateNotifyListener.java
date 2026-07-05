package net.teacommontea.skstorage.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.teacommontea.skstorage.SkStoragePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class UpdateNotifyListener implements Listener {

    private static final MiniMessage MM = MiniMessage.miniMessage();

    private static final String PERMISSION = "SkStorage.AdminCommands";

    private final SkStoragePlugin plugin;

    public UpdateNotifyListener(SkStoragePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        String version = plugin.getAvailableUpdateVersion();
        if (version == null) {
            return;
        }
        Player p = event.getPlayer();
        if (!p.hasPermission(PERMISSION) && !p.isOp()) {
            return;
        }

        String url = UpdateChecker.spigotUrl();
        String raw = "<gray>[<yellow>SkStorage<gray>] <#ffa500>A new version of SkStorage is available: "
            + "<aqua>" + version + ". <gray>Download at "
            + "<click:open_url:'" + url + "'><hover:show_text:'<yellow>Download the most recent version of SkStorage.'>"
            + "<aqua><u>" + url + "</u></hover></click>"
            + "<gray>.";
        Component message = MM.deserialize(raw);
        p.sendMessage(message);
    }
}
