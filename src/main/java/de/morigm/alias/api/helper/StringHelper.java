package de.morigm.alias.api.helper;

public class StringHelper 
{
	public static String StringArrayToString(String[] arr, String split, int count)
	{
		String tmp = "";
		for (int i = count;i < arr.length;i++)
			tmp += arr[i] + split;
		tmp = tmp.substring(0, (tmp.length() - split.length()));
		return tmp;
	}
}
