package kr.kro.habaek.utilitycommand.functions

import org.bukkit.Bukkit
import org.bukkit.entity.Player

class Function {

    fun teleportToPlayer(p: Player, targetName: String): Boolean {
        val target = Bukkit.getPlayer(targetName) ?: return false
        p.teleport(target.location)
        return true
    }

    fun healthSetFull(p: Player): Boolean {
        p.health = p.maxHealth
        return true
    }

    fun healthSetFull(targetName: String): Boolean {
        val target = Bukkit.getPlayer(targetName) ?: return false
        target.health = target.maxHealth
        return true
    }
}