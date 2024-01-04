package me.info.infoslifestealv2.Data;

import dev.selena.luacore.utils.data.UserFolder;
import lombok.Getter;

import java.util.UUID;

public class PlayerData extends UserFolder {
    @Getter
    private final LifeStealData lifeStealData;
    public PlayerData(UUID uuid) {
        super(uuid);
        lifeStealData = loadData(LifeStealData.class, "LifeStealData.json");


    }

}
