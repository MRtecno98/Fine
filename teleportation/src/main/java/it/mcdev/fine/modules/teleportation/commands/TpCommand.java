package it.mcdev.fine.modules.teleportation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("fine")
public class TpCommand extends BaseCommand {

	@Subcommand("tp")
	@CommandAlias("tp")
	@CommandPermission("fine.command.tp")
	public void onTp(Player sender, Double x, Double y, Double z, Float yaw, Float pitch) {
		sender.teleport(new Location(sender.getWorld(), x, y, z, yaw, pitch));
	}

	@Subcommand("tp")
	@CommandAlias("tp")
	@CommandPermission("fine.command.tp")
	public void onTp(Player sender, Player target) {
		sender.teleport(target.getLocation());
	}

	@Subcommand("tp")
	@CommandAlias("tp")
	@CommandPermission("fine.command.tp.other")
	public void onTp(CommandSender sender, Player player, Double x, Double y, Double z, Float yaw, Float pitch) {
		player.teleport(new Location(player.getWorld(), x, y, z, yaw, pitch));
	}

	@Subcommand("tp")
	@CommandAlias("tp")
	@CommandPermission("fine.command.tp.other")
	public void onTp(CommandSender sender, Player player, Player target) {
		player.teleport(player.getLocation());
	}
}
