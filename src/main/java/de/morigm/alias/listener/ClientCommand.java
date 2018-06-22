package de.morigm.alias.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.morigm.alias.Main;
import de.morigm.alias.api.Alias;

public class ClientCommand implements Listener
{
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e)
	{
		String command = e.getMessage().split(" ")[0];
		if(Main.getInstance().getAliasManger().containsAlias(command.substring(1,command.length())))
		{
			Alias a = Main.getInstance().getAliasManger().getAliasByString(command.substring(1,command.length()));
			if(a.isClient() && (a.getPermission().isEmpty() || e.getPlayer().hasPermission(a.getPermission())))
			{
				String text = " ";
				
				for(int i = 1;i < e.getMessage().split(" ").length;i++)
					if(!e.getMessage().split(" ")[i].isEmpty())
						text += e.getMessage().split(" ")[i] + " ";
				
				Bukkit.dispatchCommand(e.getPlayer(), a.getCommand() + text);
				e.setCancelled(true);
			}
		}
	}
}
