package samples

import org.assertj.core.api.Assertions.*
import org.junit.Test

/**
 * Test Code
 * Created by pluu on 2017-04-06.
 */
class p03_util_preconditions_test {

    @Test
    fun Empty_아닐때_에러아님() {
        // require(Boolean, () -> Any): Unit
        val check = require("ABS".isNotEmpty()) { "empty!!!" }
        assertThat(check).isNotNull()
    }

    @Test
    fun Empty_일때_에러() {
        // false ==> throw IllegalArgumentException
        // requireNotNull(T?, () -> Any): T
        val msg : String? = null
        assertThatThrownBy { requireNotNull(msg) { "empty!!!" } }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("empty!!!")
    }

    @Test
    fun 체크결과_false_일때_에러() {
        // check(Boolean, () -> Any): Unit
        // false ==> IllegalStateException
        assertThatThrownBy { check("".isNotBlank()) { "Blank!!!" } }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("Blank!!!")
    }

    @Test
    fun checkNotNull_결과_false_일때_에러() {
        // checkNotNull(T?, () -> Any): T
        // false ==> IllegalStateException
        assertThatThrownBy { checkNotNull(null) { "Null!!!" } }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("Null!!!")
    }
}