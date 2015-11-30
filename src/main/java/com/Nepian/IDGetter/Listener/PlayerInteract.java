package com.Nepian.IDGetter.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerInteractBlockRightClick(PlayerInteractEvent event) {

		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}

		Player player = event.getPlayer();
		Block block = event.getClickedBlock();

		String type = block.getType().toString();
		int id = block.getTypeId();
		byte data = block.getData();

		player.sendMessage(createIDMsg(id, data, type));
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerInteractItemInHand(PlayerInteractEvent event) {
		
		if (event.getAction() != Action.RIGHT_CLICK_AIR) {
			return;
		}
		
		Player player = event.getPlayer();
		ItemStack item = player.getItemInHand();
		
		if (item.getType() == Material.AIR) {
			return;
		}
		
		String type = item.getType().toString();
		int id = item.getTypeId();
		byte data = item.getData().getData();
		
		player.sendMessage(createIDMsg(id, data, type));
	}
	
	private static String createIDMsg(int id, byte data, String type) {
		StringBuilder msg = new StringBuilder("");
		
		msg.append("ID: ").append(id).append(":");
		msg.append(data).append(", ");
		msg.append(type);
		
		return msg.toString();
	}
}
