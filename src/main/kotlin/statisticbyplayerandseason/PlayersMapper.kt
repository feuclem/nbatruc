package statisticbyplayerandseason

object PlayersMapper {
    fun handle(statisticByPlayerAndSeasonFromAPINBA: StatisticByPlayerAndSeasonFromAPINBA): Player {
        val totalGames = statisticByPlayerAndSeasonFromAPINBA.response.size.toBigDecimal()
        val totalPointsInSeason = statisticByPlayerAndSeasonFromAPINBA.response.sumOf { it.points }.toBigDecimal()
        val totalReboundsInSeason = statisticByPlayerAndSeasonFromAPINBA.response.sumOf { it.totReb }.toBigDecimal()
        val totalAssistsInSeason = statisticByPlayerAndSeasonFromAPINBA.response.sumOf { it.assists }.toBigDecimal()

        return Player(
            id = statisticByPlayerAndSeasonFromAPINBA.response.first().player.id,
            pointsPerMatch = totalPointsInSeason.divide(totalGames),
            reboundsPerMatch = totalReboundsInSeason.divide(totalGames),
            assistsPerMatch = totalAssistsInSeason.divide(totalGames),
        )
    }

}