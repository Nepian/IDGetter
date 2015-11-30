package com.Nepian.Listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerInteract(PlayerInteractEvent event) {

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
}
