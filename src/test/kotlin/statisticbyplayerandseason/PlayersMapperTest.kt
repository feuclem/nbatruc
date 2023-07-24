package statisticbyplayerandseason

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayersMapperTest {

    @Test
    fun `verify statistic by player and season from api mapping to players`() {
        @Language("json")
        val json = """
           {
              "get": "players/statistics",
              "parameters": {
                "id": "265",
                "season": "2022"
              },
              "errors": [],
              "results": 71,
              "response": [
                {
                  "player": {
                    "id": 265,
                    "firstname": "LeBron",
                    "lastname": "James"
                  },
                  "team": {
                    "id": 17,
                    "name": "Los Angeles Lakers",
                    "nickname": "Lakers",
                    "code": "LAL",
                    "logo": "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Los_Angeles_Lakers_logo.svg/220px-Los_Angeles_Lakers_logo.svg.png"
                  },
                  "game": {
                    "id": 11814
                  },
                  "points": 28,
                  "pos": "SF",
                  "min": "43",
                  "fgm": 11,
                  "fga": 25,
                  "fgp": "44.0",
                  "ftm": 4,
                  "fta": 7,
                  "ftp": "57.1",
                  "tpm": 2,
                  "tpa": 8,
                  "tpp": "25.0",
                  "offReb": 1,
                  "defReb": 9,
                  "totReb": 10,
                  "assists": 11,
                  "pFouls": 2,
                  "steals": 1,
                  "turnovers": 5,
                  "blocks": 0,
                  "plusMinus": "+22",
                  "comment": null
                },
                {
                  "player": {
                    "id": 265,
                    "firstname": "LeBron",
                    "lastname": "James"
                  },
                  "team": {
                    "id": 17,
                    "name": "Los Angeles Lakers",
                    "nickname": "Lakers",
                    "code": "LAL",
                    "logo": "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Los_Angeles_Lakers_logo.svg/220px-Los_Angeles_Lakers_logo.svg.png"
                  },
                  "game": {
                    "id": 11798
                  },
                  "points": 41,
                  "pos": "SF",
                  "min": "44",
                  "fgm": 15,
                  "fga": 30,
                  "fgp": "50.0",
                  "ftm": 5,
                  "fta": 6,
                  "ftp": "83.3",
                  "tpm": 6,
                  "tpa": 12,
                  "tpp": "50.0",
                  "offReb": 1,
                  "defReb": 8,
                  "totReb": 9,
                  "assists": 8,
                  "pFouls": 2,
                  "steals": 0,
                  "turnovers": 2,
                  "blocks": 0,
                  "plusMinus": "+1",
                  "comment": null
                }
              ]
            } 
        """.trimIndent()

        val convertedJson = jacksonObjectMapper().readValue(json, StatisticByPlayerAndSeasonFromAPINBA::class.java)
        val result = PlayersMapper.handle(convertedJson)

        assertEquals(BigDecimal(34.5), result.pointsPerMatch)
        assertEquals(BigDecimal(9.5), result.reboundsPerMatch)
        assertEquals(BigDecimal(9.5), result.assistsPerMatch)
    }
}