import scala.io.Source
import scala.collection.mutable.ListBuffer

def readFile(filepath: String): Iterator[String] =
  Source.fromFile(filepath).getLines

class RockPaperScissorsRules():
  // Rules at https://adventofcode.com/2022/day/2
  val codeMapping = Map(
    "X" -> Map("part1" -> "Rock", "part2" -> "Lose"),
    "Y" -> Map("part1" -> "Paper", "part2" -> "Draw"),
    "Z" -> Map("part1" -> "Scissors", "part2" -> "Win"),
    "A" -> Map("part1" -> "Rock", "part2" -> "Rock"),
    "B" -> Map("part1" -> "Paper", "part2" -> "Paper"),
    "C" -> Map("part1" -> "Scissors", "part2" -> "Scissors")
  )

  val scoring = Map(
    "Win" -> 6,
    "Draw" -> 3,
    "Loss" -> 0,
    "Rock" -> 1,
    "Paper" -> 2,
    "Scissors" -> 3
  )

  // if my opponent played a certain move, which one should i play to get the expected outcome?
  val suggestions = Map(
    "Win" -> Map(
      "Rock" -> "Paper",
      "Paper" -> "Scissors",
      "Scissors" -> "Rock"
    ),
    "Lose" -> Map(
      "Rock" -> "Scissors",
      "Paper" -> "Rock",
      "Scissors" -> "Paper"
    ),
    "Draw" -> Map(
      "Rock" -> "Rock",
      "Paper" -> "Paper",
      "Scissors" -> "Scissors"
    )
  )

  private def outcome(winner: String): Map[String, String] =
    // return the correct outcome map based on who won
    // if winner is empty then it was a draw
    if winner == "A" then Map("A" -> "Win", "B" -> "Loss")
    else if winner == "B" then Map("A" -> "Loss", "B" -> "Win")
    else Map("A" -> "Draw", "B" -> "Draw")

  def result(playerA: String, playerB: String): Map[String, String] =
    playerA match
      case "Rock" =>
        playerB match
          case "Paper"    => outcome(winner = "B")
          case "Scissors" => outcome(winner = "A")
          case _          => outcome(winner = "Draw")
      case "Paper" =>
        playerB match
          case "Rock"     => outcome(winner = "A")
          case "Scissors" => outcome(winner = "B")
          case _          => outcome(winner = "Draw")
      case "Scissors" =>
        playerB match
          case "Rock"  => outcome(winner = "B")
          case "Paper" => outcome(winner = "A")
          case _       => outcome(winner = "Draw")

class Player(part: String):
  var score = 0
  var moves: ListBuffer[String] = ListBuffer()
  var currentMove = ""
  val RPS = RockPaperScissorsRules()

  def updateMove(code: String, opponentMove: String = ""): Unit =
    part match
      case "part1" =>
        currentMove = RPS.codeMapping(code)(part)
      case "part2" =>
        currentMove = RPS.suggestions(RPS.codeMapping(code)(part))(opponentMove)

    moves += currentMove

  def updateScore(outcome: String): Unit =
    score += RPS.scoring(currentMove)
    score += RPS.scoring(outcome)
