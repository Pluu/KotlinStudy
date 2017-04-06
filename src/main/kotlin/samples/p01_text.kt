package samples

/**
 * kotlin.text
 * Created by pluu on 2017-04-06.
 */
fun main(args: Array<String>) {

    println("===Regex==========")
    sample_regex()

    println("===Charsets==========")
    sample_charsets()

    println("===Builder==========")
    builder()

    println("===String==========")
    string()
}

private fun sample_regex() {
    val text = "KotlinPluuKotlin"
    val regex = Regex("Kotlin")

    // match ==> match
    println(regex.matches(text))

    // one over math ==> find
    println(regex.containsMatchIn(text))

    // while ==> find ==> group()
    regex.findAll(text)
            .map { it.value }
            .forEach { println("match: $it") }


    // # String.toRegex(): Regex
//    println("Kotlin".toRegex().matches(text))
//
//    println("Kotlin".toRegex().containsMatchIn(text))
//
//    "Kotlin".toRegex().findAll(text)
//            .map { it.value }
//            .forEach { println("match: $it") }
}

private fun sample_charsets() {
    val text = "Kotlin 프루"

    arrayOf(
            Charsets.UTF_8,
            Charsets.UTF_16,
            Charsets.UTF_16BE,
            Charsets.UTF_16LE,
            Charsets.US_ASCII,
            Charsets.ISO_8859_1
    ).forEach {
        println("${it.displayName()} : ${it.encode(text)} ==> ${it.decode(it.encode(text))}")
    }
}

private fun builder() {
    // # buildString(StringBuilder.() -> Unit): String
    val string = buildString {
        append("Kotlin")
        append("Pluu")
        append("Kotlin")
    }
    println("build main.string: $string")

    // # StringBuilder.append(vararg String?): StringBuilder
    val string2 = buildString {
        append("Kotlin", "Pluu", "Kotlin")
    }
    println("build String: $string2")

    // # StringBuilder.appendln(String?): StringBuilder
    val string3 = buildString {
        appendln("Kotlin")
        appendln("Pluu")
        appendln("Kotlin")
    }
    println(string3)
}

private fun string() {
    // # CharSequence?.isNullOrEmpty(): Boolean
    val nullableText: String? = null

    if (nullableText.isNullOrEmpty()) {
        println("Text is null")
    }

    if ("".isNullOrEmpty()) {
        println("Text is empty")
    }

    if ("".isNullOrBlank()) {
        println("Text is blank")
    }

    // # CharSequence?.isNullOrBlank(): Boolean
    if ("          ".isNullOrEmpty()) {
        println("> Text is empty")
    }

    if ("          ".isNullOrBlank()) {
        println("> Text is blank")
    }

    // # String.substringBefore(String, String): String
    println("P,l,u,u".substringBefore(","))
    // # String.substringAfter(String, String): String
    println("P,l,u,u".substringAfter(","))

}