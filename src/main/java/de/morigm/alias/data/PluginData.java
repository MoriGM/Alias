package de.morigm.alias.data;

import java.io.File;

import de.morigm.alias.chat.Chat;

public class PluginData 
{
		public static File folder,alias;

		public static void load()
		{
			PluginData.folder = new File("./plugins/" + Chat.name + "/");
			PluginData.alias = new File(folder,"alias/");
		}
		
}
