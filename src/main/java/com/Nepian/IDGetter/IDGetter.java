package com.Nepian.IDGetter;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.Listener.PlayerInteract;

public class IDGetter extends JavaPlugin {

	@Override
	public void onEnable() {
		this.registerEvent(new PlayerInteract());
	}

	private void registerEvent(Listener listener) {
		this.getServer().getPluginManager().registerEvents(listener, this);
	}
}
