package de.sldk.mc.metrics;

import io.prometheus.client.Gauge;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.plugin.Plugin;

public class Tps extends Metric {

    private static final Gauge TPS = Gauge.build()
            .name(prefix("tps"))
            .help("Server TPS (ticks per second)")
            .create();

    public Tps(Plugin plugin) {
        super(plugin, TPS);
    }

    @Override
    public void enable() {
        super.enable();
    }

    @Override
    public void disable() {
        super.disable();
    }

    @Override
    public void doCollect() {
        TPS.set(MinecraftServer.getServer().recentTps[0]);
    }
}
