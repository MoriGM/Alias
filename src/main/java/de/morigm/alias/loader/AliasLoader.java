package de.morigm.alias.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.alias.api.Alias;
import de.morigm.alias.data.PluginData;

public class AliasLoader 
{
	
		public List<Alias> alias = new ArrayList<>();
	
		public void load()
		{
			if(!PluginData.alias.exists())
				PluginData.alias.mkdirs();
			for(File yml : PluginData.alias.listFiles())
				if(yml.getName().toLowerCase().endsWith(".yml"))
				{
					FileConfiguration config = YamlConfiguration.loadConfiguration(yml);
					Alias alias = new Alias(config.getString("command"), config.getString("permission"), config.getString("alias"), config.getBoolean("client"), config.getBoolean("server"));
					this.alias.add(alias);
				}
		}
		
		public void save()
		{
			for(File f : PluginData.alias.listFiles())
				if(f.exists())
					f.delete();
			for(Alias a : alias)
			{
				FileConfiguration config = YamlConfiguration.loadConfiguration(new File(PluginData.alias,a.getAlias() + ".yml"));
				config.set("command", a.getCommand());
				config.set("permission", a.getPermission());
				config.set("alias", a.getAlias());
				config.set("server", a.isServer());
				config.set("client", a.isClient());
				try 
				{
					config.save(new File(PluginData.alias,a.getAlias() + ".yml"));
				}
				catch (IOException e)
				{e.printStackTrace();}
			}
		}
}
