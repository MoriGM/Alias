package de.morigm.alias.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.alias.Main;
import de.morigm.alias.api.Alias;
import de.morigm.alias.chat.Chat;

public class CMD_Alias implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission("alias.alias"))
		{
			if(args.length >= 2)
			{
				Map<String,String> map = new HashMap<>();
				List<String> list = new ArrayList<>();
				List<String> arg = new ArrayList<>();
				for(int i = 0;i < args.length;i++)
				{
					if(args[i].equals("-s") || args[i].equals("-server"))
					{
						list.add("-s");
						continue;
					}
					if(args[i].equals("-c") || args[i].equals("-client"))
					{
						list.add("-c");
						continue;
					}
					if(args[i].equals("-p") || args[i].equals("-permission"))
					{
						map.put("-p",args[++i]);
						continue;
					}
					if(args[i].startsWith("\""))
					{	
						String text = args[i] + " ";
						for(int u = (i + 1);u < args.length;u++)
						{
							String t = args[u];
							
							if(t.startsWith("\""))
								t = t.substring(1,t.length());
							
							if(t.endsWith("\""))
								t = t.substring(0,t.length() - 1);
							
							
							text += t + " ";
							
							if(args[u].endsWith("\""))
							{

								i = (u - 1);
								break;
							}
						}
						text = text.trim();
						arg.add(text);
					}
					arg.add(args[i]);
				}
				exec(com,map,list,arg.toArray(new String[arg.size()]));
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + "alias [-permission Permission] [-client] [-server] <Alias> <Command>");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		
		return false;
	}
	
	
	public void exec(CommandSender com,Map<String,String> map,List<String> list,String[] args)
	{
		if(args.length >= 2)
		{
			String alias = args[0];
			String command = args[1];
			String permission = (map.containsKey("-p") ? map.get("-p") : "");
			boolean server = list.contains("-s");
			boolean client = list.contains("-c");
			
			if(!server && !client)
			{
				server = true;
				client = true;
			}
			
			if(!Main.getInstance().getAliasManger().containsAlias(alias))
			{
				Alias a = new Alias(command, permission, alias, client, server);
				Main.getInstance().getAliasManger().addAlias(a);
				com.sendMessage("Alias was added");
			}
			else
				com.sendMessage(Chat.prefix + "Alias already exists");
		}
		else
			com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + "alias [-permission Permission] [-client] [-server] <Alias> <Command>");
	}

}
