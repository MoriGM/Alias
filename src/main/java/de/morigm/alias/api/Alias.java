package de.morigm.alias.api;

import lombok.Getter;
import lombok.Setter;

public class Alias
{
	public Alias(String command,String permission,String alias,boolean client,boolean server) 
	{
		this.permission = permission;
		this.alias = alias;
		this.server = server;
		this.client = client;
		this.command = command;
	}
	
	@Getter @Setter private String permission,alias,command;
	@Getter @Setter private boolean server,client;
}
