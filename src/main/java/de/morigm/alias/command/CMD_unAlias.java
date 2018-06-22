package de.morigm.alias.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.alias.Main;
import de.morigm.alias.chat.Chat;

public class CMD_unAlias implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission("alias.unalias"))
		{
			if(args.length >= 1)
			{
				String alias = args[0];
				if(Main.getInstance().getAliasManger().containsAlias(alias))
				{
					Main.getInstance().getAliasManger().removeAlias(Main.getInstance().getAliasManger().getAliasByString(alias));
					com.sendMessage(Chat.prefix + "Alias was removed");
				}
				else
					com.sendMessage(Chat.prefix + "Alias doesn't exist");
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + "unalias <Alias>");
		}
		else
			Chat.writeMessage(Chat.no_permission);
		return false;
	}

}
