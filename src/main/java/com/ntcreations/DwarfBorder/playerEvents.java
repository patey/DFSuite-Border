package com.ntcreations.DwarfBorder;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class playerEvents implements Listener{
	
	configHandler cfg = new configHandler();
	Config customConfig = new Config("borders");
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void move(PlayerMoveEvent event){
		 Player p = event.getPlayer();
		 int fromx = event.getFrom().getBlockX();
		 int fromz = event.getFrom().getBlockZ();
		 int tox = event.getTo().getBlockX();
		 int toz = event.getTo().getBlockZ();
		 int counter = 0;
		 
		 for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
			 if (p.hasPermission("DwarfBorder.border."+key)){
				 if (! p.isOp()) {
					 String bmsg = cfg.getCustomConfig(customConfig).getString(key+".Message");
					 int centerx = cfg.getCustomConfig(customConfig).getInt(key+".Centerx");
					 int centerz = cfg.getCustomConfig(customConfig).getInt(key+".Centerz");
					 int fradius = cfg.getCustomConfig(customConfig).getInt(key+".Radius");
					 int radius = fradius/2;
					 int pcenterx = centerx + radius;
					 int ncenterx = centerx - radius;
					 int pcenterz = centerz + radius;
					 int ncenterz = centerz - radius;
					 
					 	if ((fromx <= pcenterx)  && (fromz <= pcenterz) && (fromx >= 0) && (fromz >= 0)){

					 		if (tox >= pcenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(-1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz >= pcenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(0,-1,-1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	
					 	if ((fromx >= ncenterx) && (fromz >= ncenterz) && (fromx <= -1) && (fromz <= -1)){

					 		if (tox <= ncenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz <= ncenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(0,-1,1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	
					 	if ((fromx >= ncenterx) && (fromz <= pcenterz) && (fromx <= -1) && (fromz >= 0)){
					 		
					 		if (tox <= ncenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz >= pcenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(0,-1,-1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	if ((fromx <= pcenterx) && (fromz >= ncenterz) && (fromx >= 0) && (fromz <= -1)){

					 		if (tox >= pcenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(-1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz <= ncenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Leavable") == false){
						 			p.setVelocity(new Vector(0,-1,1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	if ((fromx >= pcenterx)  && (fromz >= pcenterz) && (fromx >= 0) && (fromz >= 0)){

					 		if (tox <= pcenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz <= pcenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(0,-1,1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	
					 	if ((fromx <= ncenterx) && (fromz <= ncenterz) && (fromx <= -1) && (fromz <= -1)){

					 		if (tox >= ncenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(-1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz >= ncenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(0,-1,-1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	
					 	if ((fromx <= ncenterx) && (fromz >= pcenterz) && (fromx <= -1) && (fromz >= 0)){
					 		
					 		if (tox >= ncenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(-1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz <= pcenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(0,-1,1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
					 	if ((fromx >= pcenterx) && (fromz <= ncenterz) && (fromx >= 0) && (fromz <= -1)){

					 		if (tox <= pcenterx){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(1,-1,0));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 		if (toz >= ncenterz){
					 			if (cfg.getCustomConfig(customConfig).getBoolean(key+".Enterable") == false){
						 			p.setVelocity(new Vector(0,-1,-1));
									if (counter == 0){
										p.sendMessage(bmsg);
										counter = 10;
									}else{
										counter--;
									}
					 			}
					 		}
					 	}
				 }
			 }
		 }
	}
}