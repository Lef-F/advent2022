import java.io.FileNotFoundException

@main def happyAdvent(day: Int): Unit =
  val filename = s"data/day${day.toString()}.txt"
  var data: Iterator[String] = null
  try data = readFile(filename)
  catch
    case fnf: FileNotFoundException =>
      println(s"No data file found at ${filename} for choice of day: ${day}")
      sys.exit()

  val challenge = day match
    case 1 =>
      // https://adventofcode.com/2022/day/1
      val list = day1(data)
      println(s"Top 3 elves with the most calories: ${list.takeRight(3)}")
      var topSum = 0
      for (k, v) <- list.takeRight(3)
      do topSum += v
      println(s"Total calories of top 3 elves: ${topSum}")

    case _ =>
      println(
        s"No matching Advent of Code solution for choice of day: ${day}"
      )
      sys.exit()
