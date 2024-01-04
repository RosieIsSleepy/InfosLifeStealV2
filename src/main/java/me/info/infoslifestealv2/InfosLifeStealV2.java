package me.info.infoslifestealv2;

import co.aikar.commands.BukkitCommandManager;
import dev.selena.luacore.LuaCore;
import dev.selena.luacore.utils.data.UserDataManager;
import lombok.Getter;
import me.info.infoslifestealv2.Listeners.onPlayerJoin;
import me.info.infoslifestealv2.Managers.PlayerMemory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;


public final class InfosLifeStealV2 extends JavaPlugin {
    @Getter
    public BukkitCommandManager bukkitCommandManager;
    @Getter
    public PlayerMemory playerMemory;
    @Getter
    private UserDataManager dataManager;

    @Override
    public void onEnable() {
        bukkitCommandManager = new BukkitCommandManager(this);

        playerMemory = new PlayerMemory();
        getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);
        LuaCore.setPlugin(this);
        dataManager = new UserDataManager("data");
        LuaCore.setUserDataManager(dataManager);
    }

    @Override
    public void onDisable() {
        LuaCore.save();
    }
}
