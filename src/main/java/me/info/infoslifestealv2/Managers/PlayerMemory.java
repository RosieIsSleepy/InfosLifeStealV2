package me.info.infoslifestealv2.Managers;

import me.info.infoslifestealv2.InfosLifeStealV2;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerMemory {
    private final Map<UUID, Integer> integerMap;
    private InfosLifeStealV2 plugin;

    public PlayerMemory(Map<UUID, Integer> integerMap) {
        this.integerMap = integerMap;
    }
    public PlayerMemory(){
        integerMap = new HashMap<>();
    }
    public Map<UUID, Integer> getIntegerMap() {
        return integerMap;
    }
    public void add(UUID uuid, int MaxHealth){
        integerMap.put(uuid, MaxHealth);
    }
}

