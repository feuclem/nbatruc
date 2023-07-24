package statisticbyplayerandseason

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class StatisticByPlayerAndSeasonFromAPINBA(
    val response: List<Response>
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Response(
        val player: Player,
        val points: Int,
        val totReb: Int,
        val assists: Int,
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Player(val id: Int)
    }
}
