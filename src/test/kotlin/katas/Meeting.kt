package katas

import java.util.*
import kotlin.test.assertEquals
import kotlin.test.Test

// https://www.codewars.com/kata/59df2f8f08c6cec835000012/train/kotlin
class Meeting {
  fun meeting(value: String): String {
    return value
      .split(";")
      .map {
        it
          .split(":")
          .reversed()
      }
      .sortedBy { (it[0] + it[1]).lowercase() }
      .joinToString("") {
        "(${
          it
            .joinToString(", ")
            .uppercase(Locale.ENGLISH)
        })"
      }
  }

  @Test
  fun test() {
    val sample = listOf(
      Pair("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn", "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)"),
      Pair("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell", "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)"),
      Pair("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern", "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)"),
    )

    for ((input, output) in sample) assertEquals(meeting(input), output)
  }

  @Test
  fun dummy() {
    println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"))
  }
}