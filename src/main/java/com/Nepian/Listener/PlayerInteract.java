package com.Nepian.Listener;

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

		String blockType = block.getType().toString();
		int blockTypeId = block.getTypeId();
		byte blockData = block.getData();
		
		StringBuilder msg = new StringBuilder("");
		
		msg.append("ID: ").append(blockTypeId).append(":");
		msg.append(blockData).append(", ");
		msg.append(blockType);

		player.sendMessage(msg.toString());
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
		
		String itemType = item.getType().toString();
		int itemTypeId = item.getTypeId();
		byte itemData = item.getData().getData();
		
		StringBuilder msg = new StringBuilder("");
		
		msg.append("ID: ").append(itemTypeId).append(":");
		msg.append(itemData).append(", ");
		msg.append(itemType);
		
		player.sendMessage(msg.toString());
	}
}
