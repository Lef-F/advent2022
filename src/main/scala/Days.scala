// https://adventofcode.com/2022/day/1
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
