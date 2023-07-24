package statisticbyplayerandseason

import java.math.BigDecimal

data class Player(
    val id: Int,
    val pointsPerMatch: BigDecimal,
    val reboundsPerMatch: BigDecimal,
    val assistsPerMatch: BigDecimal,
)
