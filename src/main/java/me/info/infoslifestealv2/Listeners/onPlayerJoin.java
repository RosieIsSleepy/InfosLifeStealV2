package me.info.infoslifestealv2.Listeners;

import dev.selena.luacore.exceptions.data.NoUserJsonFoundException;
import me.info.infoslifestealv2.Data.LifeStealData;
import me.info.infoslifestealv2.Data.PlayerData;
import me.info.infoslifestealv2.InfosLifeStealV2;
import me.info.infoslifestealv2.Managers.PlayerMemory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class onPlayerJoin implements Listener {
    private final InfosLifeStealV2 plugin;
    public onPlayerJoin(InfosLifeStealV2 plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoUserJsonFoundException {
        PlayerData data = plugin.getDataManager().getUserDataFolder(PlayerData.class, event.getPlayer().getUniqueId());
        event.getPlayer().setMaxHealth(data.getLifeStealData().getHealth());

    }

    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        if(event.getEntity() == null){return;}
        PlayerData data = plugin.getDataManager().getUserDataFolder(PlayerData.class, event.getEntity().getPlayer().getUniqueId());
        if(event.getEntity().getMaxHealth() <= 2){
            return;
        }

        //If MaxHealth is > 2 on death then it is to take two away and save it to playerdata file
        data.getLifeStealData().setHealth(event.getEntity().getMaxHealth() - 2);
        event.getEntity().getPlayer().setMaxHealth(data.getLifeStealData().getHealth());
        plugin.getDataManager().saveUserData(plugin.getDataManager().getUserDataFolder(PlayerData.class, event.getEntity().getPlayer().getUniqueId()));

        //if Player is killed by another player add 2 max hp to the killers health
        if(event.getEntity().getKiller() != null){
            PlayerData kdata = plugin.getDataManager().getUserDataFolder(PlayerData.class, event.getEntity().getKiller().getUniqueId());
            if(event.getEntity().getPlayer().getKiller().getMaxHealth() >= 40)
                return;
            kdata.getLifeStealData().setHealth(event.getEntity().getPlayer().getKiller().getMaxHealth() + 2);
            event.getEntity().getPlayer().getKiller().setMaxHealth(kdata.getLifeStealData().getHealth());
            plugin.getDataManager().saveUserData(plugin.getDataManager().getUserDataFolder(PlayerData.class, event.getEntity().getPlayer().getKiller().getUniqueId()));
        }

    }

}
