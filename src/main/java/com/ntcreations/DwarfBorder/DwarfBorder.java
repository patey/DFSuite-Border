package com.ntcreations.DwarfBorder;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class DwarfBorder extends JavaPlugin{
	private static DwarfBorder instance = null;
	Config customConfig;
	configHandler cfg = new configHandler();
	 
	public void onEnable() {
		instance = this;
		registerEvents(this,new playerEvents());
		getCommand("DB").setExecutor(new Commands());
		getCommand("border").setExecutor(new Commands());
		initconfig();
		initCustom();
		getLogger().info("DwarfBorder Initialized");
	}
	
	 public static DwarfBorder getInstance() {
		 return instance;
		 }
	 
	public void onDisable() {
		getLogger().info("DwarfBorder Unloaded");
	}
	
	private void initconfig(){
	    FileConfiguration config = getConfig();
	    
	    config.addDefault("Borders.Border1.Name", "border1");
	    config.addDefault("Borders.Border1.Radius", 20);
	    config.addDefault("Borders.Border1.Center.X", 0);
	    config.addDefault("Borders.Border1.Center.Z", 0);
	    config.addDefault("Borders.Border1.BarrierMessage", "You can't go there!");
	    
	    config.options().copyDefaults(true);
	    saveConfig();
	}
	
	public void initCustom(){
		customConfig = new Config("borders");
		cfg.saveCustomConfig(customConfig);
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
    
}
