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

def day1(data: Iterator[String]): Seq[(String, Int)] =
  var elfCount = 1
  var totalCalories = 0
  var bestElf = 0
  var bestCalories = 0
  var elfStats: Map[String, Int] = Map()

  for line <- data
  do
    if line.length() > 0 then
      totalCalories += line.toInt
      if bestCalories < totalCalories then
        println(s"new best by elf ${elfCount} with ${totalCalories} calories")
        bestElf = elfCount
        bestCalories = totalCalories
    else
      elfStats += (elfCount.toString() -> totalCalories)
      elfCount += 1
      totalCalories = 0

  elfStats.toSeq.sortBy(_._2)
