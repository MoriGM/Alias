package de.morigm.alias;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.alias.chat.Chat;
import de.morigm.alias.command.CMD_Alias;
import de.morigm.alias.command.CMD_unAlias;
import de.morigm.alias.data.PluginData;
import de.morigm.alias.listener.ClientCommand;
import de.morigm.alias.listener.ServerCommand;
import de.morigm.alias.loader.AliasLoader;
import de.morigm.alias.manager.AliasManager;
import lombok.Getter;

public class Main extends JavaPlugin
{
	
	@Getter private static Main instance;
	@Getter private AliasLoader AliasLoader;
	@Getter private AliasManager AliasManger;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		PluginData.load();
		this.AliasLoader = new AliasLoader();
		this.AliasLoader.load();
		this.AliasManger = new AliasManager();
		loadCommands();
		loadListener();
		Chat.writeMessage("Plugin is started");
	}
	
	@Override
	public void onDisable() 
	{
		this.AliasLoader.save();
		Chat.writeMessage("Plugin is stopped");
	}
	
	public void loadListener()
	{
		Bukkit.getPluginManager().registerEvents(new ClientCommand(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new ServerCommand(), Main.getInstance());
	}
	
	public void loadCommands()
	{
		getCommand("alias").setExecutor(new CMD_Alias());
		getCommand("unalias").setExecutor(new CMD_unAlias());
	}
	
}
