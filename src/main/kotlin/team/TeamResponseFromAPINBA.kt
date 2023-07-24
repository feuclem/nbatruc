package team

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TeamResponseFromAPINBA(
    val response: List<Response>,
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Response(
        val id: Int,
        val name: String,
    )
}
