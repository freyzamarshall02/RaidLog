package dev.raidlog;

import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RaidLog extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void log(String tag, Raid raid, World world, String extra) {
        getLogger().info("[" + tag + "] world=" + world.getName()
                + " difficulty=" + world.getDifficulty()
                + " totalWaves=" + raid.getTotalWaves()
                + " spawnedGroups=" + raid.getSpawnedGroups()
                + " badOmen=" + raid.getBadOmenLevel()
                + " status=" + raid.getStatus()
                + " raidersAlive=" + raid.getRaiders().size()
                + (extra.isEmpty() ? "" : " " + extra));
    }

    @EventHandler
    public void onTrigger(RaidTriggerEvent e) {
        log("TRIGGER", e.getRaid(), e.getWorld(), "");
    }

    @EventHandler
    public void onWave(RaidSpawnWaveEvent e) {
        log("WAVE", e.getRaid(), e.getWorld(), "newRaiders=" + e.getRaiders().size());
    }

    @EventHandler
    public void onStop(RaidStopEvent e) {
        log("STOP", e.getRaid(), e.getWorld(), "reason=" + e.getReason());
    }

    @EventHandler
    public void onFinish(RaidFinishEvent e) {
        log("FINISH", e.getRaid(), e.getWorld(), "winners=" + e.getWinners().size());
    }
}
