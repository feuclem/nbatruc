package team

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TeamsMapperTest {

    @Test
    fun `verify nba teams from api mapping into nba teams`() {
        @Language("JSON")
        val json = """
            {
              "get": "teams/",
              "parameters": [],
              "errors": [],
              "results": 62,
              "response": [
                {
                  "id": 1,
                  "name": "Atlanta Hawks",
                  "nickname": "Hawks",
                  "code": "ATL",
                  "city": "Atlanta",
                  "logo": "https://upload.wikimedia.org/wikipedia/fr/e/ee/Hawks_2016.png",
                  "allStar": false,
                  "nbaFranchise": true,
                  "leagues": {
                    "standard": {
                      "conference": "East",
                      "division": "Southeast"
                    },
                    "vegas": {
                      "conference": "East",
                      "division": "Southeast"
                    },
                    "utah": {
                      "conference": "East",
                      "division": "Southeast"
                    },
                    "sacramento": {
                      "conference": "East",
                      "division": "Southeast"
                    }
                  }
                },
                {
                  "id": 2,
                  "name": "Boston Celtics",
                  "nickname": "Celtics",
                  "code": "BOS",
                  "city": "Boston",
                  "logo": "https://upload.wikimedia.org/wikipedia/fr/thumb/6/65/Celtics_de_Boston_logo.svg/1024px-Celtics_de_Boston_logo.svg.png",
                  "allStar": false,
                  "nbaFranchise": true,
                  "leagues": {
                    "standard": {
                      "conference": "East",
                      "division": "Atlantic"
                    },
                    "vegas": {
                      "conference": "East",
                      "division": "Atlantic"
                    },
                    "utah": {
                      "conference": "East",
                      "division": "Atlantic"
                    },
                    "sacramento": {
                      "conference": "East",
                      "division": "Atlantic"
                    }
                  }
                }
              ]
            }
        """.trimIndent()

        val convertedJson = jacksonObjectMapper().readValue(json, TeamResponseFromAPINBA::class.java)
        val result = TeamsMapper.handle(convertedJson)

        assertEquals(2, result.size)
        assertEquals("Atlanta Hawks", result.first().name)
        assertEquals("Boston Celtics", result[1].name)
    }
}