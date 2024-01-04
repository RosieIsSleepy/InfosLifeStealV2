package me.info.infoslifestealv2.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.Builder;
import lombok.Getter;
import me.info.infoslifestealv2.InfosLifeStealV2;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("resetHeart")
@CommandPermission("info.Lifesteal.ResetHeart")
public class ResetHeartCommand extends BaseCommand {
    private InfosLifeStealV2 plugin;

    public ResetHeartCommand(InfosLifeStealV2 plugin) {
        this.plugin = plugin;
        plugin.bukkitCommandManager.registerCommand(this);
    }
    @Default
    public void onCommand(CommandSender sender){
        if(!(sender instanceof Player)){
            sender.sendMessage("Stop trying to do this robot!");
            return;
        }
        else{

        }
    }

}
