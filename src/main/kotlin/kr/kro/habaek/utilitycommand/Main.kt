package kr.kro.habaek.utilitycommand

import org.bukkit.plugin.java.JavaPlugin
import kr.kro.habaek.utilitycommand.cmd.CMD

class Main : JavaPlugin() {
    companion object {
        const val prefix = "§f§7[§9UtilCMDS§7]§f"
    }
    override fun onEnable() {
        logger.info("$prefix §aEnable")

        getCommand("ms")?.setExecutor(CMD())
    }

    override fun onDisable() {

    }
}