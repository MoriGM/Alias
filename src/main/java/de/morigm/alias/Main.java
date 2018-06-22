package de.morigm.alias;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.alias.chat.Chat;
import de.morigm.alias.data.PluginData;
import de.morigm.alias.loader.AliasLoader;
import lombok.Getter;

public class Main extends JavaPlugin
{
	
	@Getter private static Main instance;
	@Getter private AliasLoader AliasLoader;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		PluginData.load();
		this.AliasLoader = new AliasLoader();
		this.AliasLoader.load();
		Chat.writeMessage("Plugin is started");
	}
	
	@Override
	public void onDisable() 
	{
		this.AliasLoader.save();
		Chat.writeMessage("Plugin is stopped");
	}
	
}
