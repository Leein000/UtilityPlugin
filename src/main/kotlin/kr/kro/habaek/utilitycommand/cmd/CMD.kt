package kr.kro.habaek.utilitycommand.cmd

import kr.kro.habaek.utilitycommand.Main
import kr.kro.habaek.utilitycommand.enums.CMDList
import kr.kro.habaek.utilitycommand.functions.Function
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import java.util.*

class CMD : CommandExecutor, TabCompleter{
    private val prefix = Main.prefix
    private val cmds = CMDList.values()
    override fun onCommand(p: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (p !is Player) return false
        if (args.isEmpty()) {
            Arrays.sort(cmds)
            p.sendMessage("$prefix commands List")
            p.sendMessage(" ")
            for (cmd in cmds) p.sendMessage("§e${cmd.name.toLowerCase()} §6- §f${cmd.description}.")
        } else {
            val cmd = CMDList.valueOf(args[0])
            if (cmd != null)
                when (cmd) {
                    CMDList.HELP -> {
                        Arrays.sort(cmds)
                        p.sendMessage("$prefix :: commands List")
                        p.sendMessage(" ")
                        for (cmd in cmds) p.sendMessage("§e${cmd.name.toLowerCase()} §6 - §f${cmd.description}.")
                    }
                    CMDList.SPAWN -> {
                        p.teleport(Bukkit.getWorld("world")!!.spawnLocation)
                        p.sendMessage("$prefix Teleport to spawn point.")
                    }
                    CMDList.TP -> {
                        if (args.size != 2) p.sendMessage("$prefix EX: /ms tp <PlayerName>")
                        if (!Function().teleportToPlayer(p, args[1])) p.sendMessage("$prefix player not found")
                    }
                    CMDList.TPA -> TODO()
                    CMDList.WARP -> TODO()
                    CMDList.WARPS -> TODO()
                    CMDList.HEAL -> {
                        when {
                            args.size > 2 -> p.sendMessage("$prefix EX: /ms heal <PlayerName>")
                            args.size == 1 -> Function().healthSetFull(p)
                            else -> Function().healthSetFull(args[1])
                        }
                    }
                }
        }
        return false
    }

    override fun onTabComplete(p: CommandSender, cmd: Command, alias: String, args: Array<out String>): MutableList<String> {
        val list = mutableListOf<String>()
        val players = Bukkit.getOnlinePlayers()
        if (args.size == 1) for (s in cmds) if (s.name.toLowerCase().contains(args[0])) list.add(s.name.toLowerCase())
        if (args.size <= 2) {
            val cmd = CMDList.valueOf(args[0])
            if (cmd != null)
                when (cmd) {
                    CMDList.TP, CMDList.HEAL -> for (p in players) if (p.name.contains(args[1])) list.add(p.name)
                }
        }
        return list
    }
}