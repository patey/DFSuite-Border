package com.ntcreations.DwarfBorder;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		configHandler cfg = new configHandler();
		Config customConfig;
		
		if (cmd.getName().equalsIgnoreCase("DB")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				if (args.length == 1){
					if (args[0].equals("reload")){
						DwarfBorder.getInstance().reloadConfig();
						sender.sendMessage("DwarfBorder reloaded");
						return true;
					}
				}
				if (args.length == 0){
					sender.sendMessage("DwarfBorder v0.1.0");
					sender.sendMessage("Designed by Patey for the DFRP community");
					return true;
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("border")) {
			
			if (args.length == 0){
				sender.sendMessage("Change border settings,see command help");
				return true;
			}
			
			if (args.length == 1){
				sender.sendMessage("Not enough command arguments!");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("delete")){
				if (args.length == 1){
					sender.sendMessage("delete which border?");
					return true;
				}
				if (args.length == 2){
					customConfig = new Config("borders");
					for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
						if (args[1].equalsIgnoreCase(key)){
							cfg.getCustomConfig(customConfig).set(args[1], null);
							
							cfg.saveCustomConfig(customConfig);
							cfg.reloadCustomConfig(customConfig);
							sender.sendMessage("Border "+args[1]+" has been deleted.");
							return true;
						}else{
							sender.sendMessage("Border "+args[1]+" does not exist.");
							return true;
						}
					}
				}
			}
			
			if (args[0].equalsIgnoreCase("edit")){
				String name = args[1];
				
				if (args.length == 1){
					sender.sendMessage("Edit which border?");
					return true;
				}
				
				if (args.length == 2){
					sender.sendMessage("Do what with this border?");
					return true;
				}
				
				if(args.length == 3){
					if (args[2].equalsIgnoreCase("center")){
						customConfig = new Config("borders");
						for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
							if (name.equalsIgnoreCase(key)){
								Player player = (Player) sender;
								Location loc = player.getLocation();
								int nx = loc.getBlockX();
								int nz = loc.getBlockZ();
								
								cfg.getCustomConfig(customConfig).set(name+".Centerx", nx);
								cfg.getCustomConfig(customConfig).set(name+".Centerz", nz);
								cfg.saveCustomConfig(customConfig);
								cfg.reloadCustomConfig(customConfig);
								sender.sendMessage("Border "+name+" is now centered at your location.");
								return true;
							}else{
								sender.sendMessage("Border "+name+" does not exist.");
								return true;
							}
						}
					}
				}
				
				if (args.length == 4){
					if (args[2].equalsIgnoreCase("name")){
						customConfig = new Config("borders");
						for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
							if (name.equalsIgnoreCase(key)){
								String nName = args[3];
								int nCenterx = cfg.getCustomConfig(customConfig).getInt(name+".Centerx");
								int nCenterz = cfg.getCustomConfig(customConfig).getInt(name+".Centerz");
								int nRadius = cfg.getCustomConfig(customConfig).getInt(name+".Radius");
								boolean leave = cfg.getCustomConfig(customConfig).getBoolean(name+".Leavable");
								boolean enter = cfg.getCustomConfig(customConfig).getBoolean(name+".Enterable");
								String nMsg = cfg.getCustomConfig(customConfig).getString(name+".Message");
								
								cfg.getCustomConfig(customConfig).set(nName+".Radius", nRadius);
								cfg.getCustomConfig(customConfig).set(nName+".Centerx", nCenterx);
								cfg.getCustomConfig(customConfig).set(nName+".Centerz", nCenterz);
								cfg.getCustomConfig(customConfig).set(nName+".Message", nMsg);
								cfg.getCustomConfig(customConfig).set(nName+".Enterable", enter);
								cfg.getCustomConfig(customConfig).set(nName+".Leavable", leave);
								
								cfg.getCustomConfig(customConfig).set(name, null);
								
								cfg.saveCustomConfig(customConfig);
								cfg.reloadCustomConfig(customConfig);
								sender.sendMessage("Border "+name+" has been renamed "+nName+".");
								return true;
							}else{
								sender.sendMessage("Border "+name+" does not exist.");
								return true;
							}
						}
					}
					
					if (args[2].equalsIgnoreCase("radius")){
						customConfig = new Config("borders");
						for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
							if (name.equalsIgnoreCase(key)){
								int nRadius = Integer.parseInt(args[3]);
								cfg.getCustomConfig(customConfig).set(name+".Radius", nRadius);
								cfg.saveCustomConfig(customConfig);
								cfg.reloadCustomConfig(customConfig);
								sender.sendMessage("Border "+name+" now has a radius of "+args[3]+".");
								return true;
							}else{
								sender.sendMessage("Border "+name+" does not exist.");
								return true;
							}
						}
					}
					
					if (args[2].equalsIgnoreCase("leave")){
						customConfig = new Config("borders");
						for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
							if (name.equalsIgnoreCase(key)){
								if (args[3].equalsIgnoreCase("true")){
									cfg.getCustomConfig(customConfig).set(name+".Leavable", true);
									cfg.saveCustomConfig(customConfig);
									cfg.reloadCustomConfig(customConfig);
									sender.sendMessage("Players can now leave Border "+name+".");
									return true;
								}
								if (args[3].equalsIgnoreCase("false")){
									cfg.getCustomConfig(customConfig).set(name+".Leavable", false);
									cfg.saveCustomConfig(customConfig);
									cfg.reloadCustomConfig(customConfig);
									sender.sendMessage("Players can no longer leave Border "+name+".");
									return true;
								}
							}else{
								sender.sendMessage("Border "+name+" does not exist.");
								return true;
							}
						}
					}
					
					if (args[2].equalsIgnoreCase("enter")){
						customConfig = new Config("borders");
						for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
							if (name.equalsIgnoreCase(key)){
								if (args[3].equalsIgnoreCase("true")){
									cfg.getCustomConfig(customConfig).set(name+".Enterable", true);
									cfg.saveCustomConfig(customConfig);
									cfg.reloadCustomConfig(customConfig);
									sender.sendMessage("Players can now enter Border "+name+".");
									return true;
								}
								if (args[3].equalsIgnoreCase("false")){
									cfg.getCustomConfig(customConfig).set(name+".Enterable", false);
									cfg.saveCustomConfig(customConfig);
									cfg.reloadCustomConfig(customConfig);
									sender.sendMessage("Players can no longer enter Border "+name+".");
									return true;
								}
							}else{
								sender.sendMessage("Border "+name+" does not exist.");
								return true;
							}
						}
					}
				}
				
				if (args[2].equalsIgnoreCase("message")){
			        StringBuilder sb = new StringBuilder();
			        for(int i = 3; i < args.length; i++) {
			            sb.append(args[i]);
			            if (i < args.length-1) sb.append(" ");
			        }
			        String message = sb.toString();
					customConfig = new Config("borders");
					for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
						if (name.equalsIgnoreCase(key)){
							cfg.getCustomConfig(customConfig).set(name+".Message", message);
							cfg.saveCustomConfig(customConfig);
							cfg.reloadCustomConfig(customConfig);
							sender.sendMessage("Border barrier message for "+name+" has been changed.");
							return true;
						}else{
							sender.sendMessage("Border "+name+" does not exist.");
							return true;
						}
					}
				}
			}
			
			if (args.length == 3){
				if (args[0].equalsIgnoreCase("new")){
				    
					String name = args[1];
					int radius = Integer.parseInt(args[2]);
					Player player = (Player) sender;
					Location loc = player.getLocation();
					int x = loc.getBlockX();
					int z = loc.getBlockZ();
					
					
					customConfig = new Config("borders");
					cfg.getCustomConfig(customConfig).set(name+".Radius", radius);
					cfg.getCustomConfig(customConfig).set(name+".Centerx", x);
					cfg.getCustomConfig(customConfig).set(name+".Centerz", z);
					cfg.getCustomConfig(customConfig).set(name+".Message", "You can't go there!");
					cfg.getCustomConfig(customConfig).set(name+".Enterable", true);
					cfg.getCustomConfig(customConfig).set(name+".Leavable", false);
					
					cfg.saveCustomConfig(customConfig);
					cfg.reloadCustomConfig(customConfig);
					sender.sendMessage("Border named "+name+" has been created here.");
					return true;
				}
				
			}
			
		}
		
		return false;
	}
}
