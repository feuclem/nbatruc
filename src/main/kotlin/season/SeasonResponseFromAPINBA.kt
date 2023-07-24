package season

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SeasonResponseFromAPINBA(
    val response: List<Int>,
)
