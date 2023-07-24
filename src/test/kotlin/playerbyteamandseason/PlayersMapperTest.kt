package playerbyteamandseason

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayersMapperTest {

    @Test
    fun `verify players by team and season from api mapping to players`() {
        @Language("json")
        val json = """
           {
              "get": "players/",
              "parameters": {
                "team": "17",
                "season": "2022"
              },
              "errors": [],
              "results": 28,
              "response": [
                {
                  "id": 126,
                  "firstname": "Anthony",
                  "lastname": "Davis",
                  "birth": {
                    "date": "1993-03-11",
                    "country": "USA"
                  },
                  "nba": {
                    "start": 2012,
                    "pro": 9
                  },
                  "height": {
                    "feets": "6",
                    "inches": "10",
                    "meters": "2.08"
                  },
                  "weight": {
                    "pounds": "253",
                    "kilograms": "114.8"
                  },
                  "college": "Kentucky",
                  "affiliation": "Kentucky/USA",
                  "leagues": {
                    "standard": {
                      "jersey": 3,
                      "active": true,
                      "pos": "F-C"
                    }
                  }
                },
                {
                  "id": 265,
                  "firstname": "LeBron",
                  "lastname": "James",
                  "birth": {
                    "date": "1984-12-30",
                    "country": "USA"
                  },
                  "nba": {
                    "start": 2003,
                    "pro": 18
                  },
                  "height": {
                    "feets": "6",
                    "inches": "9",
                    "meters": "2.06"
                  },
                  "weight": {
                    "pounds": "250",
                    "kilograms": "113.4"
                  },
                  "college": "St. Vincent-St. Mary HS (OH)",
                  "affiliation": "St. Vincent-St. Mary HS (OH)/USA",
                  "leagues": {
                    "standard": {
                      "jersey": 6,
                      "active": true,
                      "pos": "F"
                    }
                  }
                }
              ]
            } 
        """.trimIndent()

        val convertedJson = jacksonObjectMapper().readValue(json, PlayerByTeamAndSeasonResponseFromAPINBA::class.java)
        val result = PlayersMapper.handle(convertedJson)

        assertEquals(2, result.size)
        assertEquals("Davis", result.first().lastName)
        assertEquals("3", result.first().numberOnJersey)
        assertEquals("James", result[1].lastName)
        assertEquals("6", result[1].numberOnJersey)
    }
}