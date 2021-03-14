package Main;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Interact implements Listener {
	
	private Main plugin;

	public Interact(Main plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PlayerInteractEvent(org.bukkit.event.player.PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
				
				Projectile fb = p.launchProjectile(Fireball.class);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						fb.setVelocity(p.getLocation().getDirection().multiply(1));
						
					}
				}.runTaskTimer((Plugin) this.plugin, 1, 1);
			}
		if(p.getItemInHand().getType().equals(Material.STICK)) {
				
				Projectile sb = p.launchProjectile(Snowball.class);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						sb.setVelocity(p.getLocation().getDirection().multiply(1));
						
					}
				}.runTaskTimer((Plugin) this.plugin, 1, 1);
			}
		if(p.getItemInHand().getType().equals(Material.BONE)) {
			
			Projectile Arrow = p.launchProjectile(Arrow.class);
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Arrow.setVelocity(p.getLocation().getDirection().multiply(1));
					
				}
			}.runTaskTimer((Plugin) this.plugin, 1, 1);
		}
			
		}
	}
}
