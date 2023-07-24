package playerbyteamandseason

object PlayersMapper {
    fun handle(playerByTeamAndSeasonResponseFromAPINBA: PlayerByTeamAndSeasonResponseFromAPINBA): List<Player> {
        return playerByTeamAndSeasonResponseFromAPINBA.response.map {
            with(it) {
                Player(
                    id = id,
                    firstName = firstname,
                    lastName = lastname,
                    position = leagues.standard.pos,
                    numberOnJersey = leagues.standard.jersey,
                )
            }
        }
    }
}