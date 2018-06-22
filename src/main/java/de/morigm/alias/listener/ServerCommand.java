package de.morigm.alias.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

import de.morigm.alias.Main;
import de.morigm.alias.api.Alias;

public class ServerCommand implements Listener
{
	@EventHandler
	public void on(ServerCommandEvent e)
	{
		String command = e.getCommand().split(" ")[0];
		if(Main.getInstance().getAliasManger().containsAlias(command))
		{
			Alias a = Main.getInstance().getAliasManger().getAliasByString(command);
			if(a.isClient() && (e.getSender().hasPermission(a.getPermission()) || a.getPermission().isEmpty()))
			{
				String text = " ";
				
				for(int i = 1;i < e.getCommand().split(" ").length;i++)
					if(!e.getCommand().split(" ")[i].isEmpty())
						text += e.getCommand().split(" ")[i] + " ";
				
				Bukkit.dispatchCommand(e.getSender(), a.getCommand() + text);
				e.setCancelled(true);
			}
		}
	}
}
