package de.morigm.alias.manager;

import java.util.List;

import de.morigm.alias.Main;
import de.morigm.alias.api.Alias;

public class AliasManager 
{
	
	public List<Alias> getAlias()
	{
		return Main.getInstance().getAliasLoader().alias;
	}
	
	public boolean containsAlias(String alias)
	{
		return getAliasByString(alias) != null;
	}
	
	public boolean containsAlias(Alias alias)
	{
		return getAlias().contains(alias);
	}
	
	public void addAlias(Alias alias)
	{
		if(!this.containsAlias(alias))
			getAlias().add(alias);
	}
	
	public void removeAlias(Alias alias)
	{
		if(getAlias().contains(alias))
			getAlias().remove(alias);
	}
	
	
	
	public Alias getAliasByString(String alias)
	{
		for(Alias a : getAlias())
			if(a.getAlias().equals(alias))
				return a;
		return null;
	}
	
	
}
