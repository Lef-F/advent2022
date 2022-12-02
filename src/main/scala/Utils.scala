import scala.io.Source

def readFile(filepath: String): Iterator[String] =
  Source.fromFile(filepath).getLines
