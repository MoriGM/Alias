package de.morigm.alias.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import de.morigm.alias.Main;

public class Chat 
{
	
	public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Alias" + ChatColor.DARK_GRAY +  "] " + ChatColor.WHITE;
	public static final String name = Main.getInstance().getDescription().getName();
	public static final String version = Main.getInstance().getDescription().getVersion();
	public static final String no_console = "You must be a Player";
	public static final String no_player = "You must be the Console";
	public static final String no_permission = "You have no Permission to do that";
	public static final String no_online = "Player is not Online";
	public static final String no_group = "No Group are in the List";
	
	public static void writeMessage(String text)
	{
		Bukkit.getConsoleSender().sendMessage(Chat.prefix + text);
	}

}
