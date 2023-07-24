package playerbyteamandseason

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayerByTeamAndSeasonResponseFromAPINBA(
    val response: List<Response>,
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Response(
        val id: Int,
        val firstname: String,
        val lastname: String,
        val leagues: Leagues,
    ) {
        data class Leagues(
            val standard: Standard,
        ) {
            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Standard(
                val jersey: String,
                val pos: String,
            )
        }
    }
}