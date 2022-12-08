// DAY 1
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

// DAY 2
// https://adventofcode.com/2022/day/2
def day2(data: Iterator[String]): Unit =
  val RPS = RockPaperScissorsRules()
  var opponent = Player("part1")
  var mePart1 = Player("part1")
  var mePart2 = Player("part2")

  var result: Map[String, String] = Map()

  for game <- data
  do
    opponent.updateMove(game.take(1))
    mePart1.updateMove(game.takeRight(1))
    mePart2.updateMove(game.takeRight(1), opponent.currentMove)

    var resultPart1 =
      RPS.result(playerA = opponent.currentMove, playerB = mePart1.currentMove)

    var resultPart2 =
      RPS.result(playerA = opponent.currentMove, playerB = mePart2.currentMove)

    opponent.updateScore(resultPart1("A"))
    mePart1.updateScore(resultPart1("B"))
    mePart2.updateScore(resultPart2("B"))

    println(
      f"${game.take(1)}%1s | ${game.takeRight(1)}%1s | ${opponent.currentMove}%12s | ${opponent.score}%10d | ${mePart1.currentMove}%12s | ${mePart1.score}%10d | ${resultPart1}%30s | ${mePart2.score}%10d | ${mePart2.currentMove}%12s | ${resultPart2}%30s"
    )

  println(s"My score following the part1 strategy: ${mePart1.score}")
  println(s"My score following the part2 strategy: ${mePart2.score}")
