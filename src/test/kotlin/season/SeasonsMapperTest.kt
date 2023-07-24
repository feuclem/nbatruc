package season

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SeasonsMapperTest {

    @Test
    fun `verify nba seasons from api mapping into nba seasons`() {
        @Language("JSON")
        val json = """
            {
              "get": "seasons/",
              "parameters": [],
              "errors": [],
              "results": 7,
              "response": [
                2015,
                2016,
                2017,
                2018,
                2019,
                2020,
                2021,
                2022
              ]
            }
        """.trimIndent()

        val convertedJson = jacksonObjectMapper().readValue(json, SeasonResponseFromAPINBA::class.java)
        val result = SeasonsMapper.handle(convertedJson)

        assertEquals(8, result.size)
    }
}