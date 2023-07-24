package season

object SeasonsMapper {
    fun handle(nbaSeasonsFromApi: SeasonResponseFromAPINBA) =
        nbaSeasonsFromApi.response.map(::Season)
}