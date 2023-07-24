package team

object TeamsMapper {
    fun handle(teamResponseFromAPINBA: TeamResponseFromAPINBA) =
        teamResponseFromAPINBA.response.map { with(it) { Team(id = id, name = name) } }
}