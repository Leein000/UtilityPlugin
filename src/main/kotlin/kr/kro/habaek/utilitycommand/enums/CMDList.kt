package kr.kro.habaek.utilitycommand.enums

enum class CMDList(description: String) {
    HELP("show this"),
    SPAWN("teleport to spawn point"),
    TP("teleport to player"),
    TPA("ask the player to teleport"),
    WARP("teleport to warp point"),
    WARPS("show warp points list"),
    HEAL("player's health set full"),
    ;
    val description = description

    enum class CommandsType {

    }
}