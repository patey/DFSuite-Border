package com.ntcreations.DwarfBorder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class configHandler{
	
	public FileConfiguration getCustomConfig(Config config) {
		if (config.fileConfig == null){
			reloadCustomConfig(config);
		}
		
		return config.fileConfig;
		}
	
	public void reloadCustomConfig(Config config) {
		if (config.fileConfig == null) {
			config.file = new File(DwarfBorder.getInstance().getDataFolder(), config.name + ".yml");
		}
		config.fileConfig = YamlConfiguration.loadConfiguration(config.file);
		 
		InputStream defConfigStream = DwarfBorder.getInstance().getResource(config.name + ".yml");
		if (defConfigStream != null) {
			@SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			config.fileConfig.setDefaults(defConfig);
		}
	}
	
	public void saveCustomConfig(Config config) {
		if (config.fileConfig == null || config.file == null) {
			return;
		}
		try {
			getCustomConfig(config).save(config.file);
		} catch (IOException ex) {
			DwarfBorder.getInstance().getLogger().log(Level.SEVERE, "Could not save config to " + config.file, ex);
		}
	}
	
	public void saveDefaultConfig(Config config) {
		if (config.file == null) {
			config.file = new File(DwarfBorder.getInstance().getDataFolder(), config.name + ".yml");
		}
		if (!config.file.exists()) {
			DwarfBorder.getInstance().saveResource(config.name + ".yml", false);
		}
	}
	

}
