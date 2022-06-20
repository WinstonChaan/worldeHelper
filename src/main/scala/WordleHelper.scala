object WordleHelper {

  var potentialWords:List[String] =  List()
  var orderedWords:List[String] =  List()
  val file = scala.io.Source.fromFile("src/words.txt")

  def contains(one: String, two: String, three: String, four: String, five: String): Unit = {
    for (i <- file.getLines()) {
      if (i.contains(one) && i.contains(two) && i.contains(three) && i.contains(four) && i.contains(five)) {
        potentialWords = potentialWords :+ i
      }
    }
  }

  def position(one: String, two: String, three: String, four: String, five: String): Unit = {
    for (i <- potentialWords) {
      if (one == "" && two == "" && three == "" && four == "" && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == "" && three == "" && five == "" && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == "" && three == "" && i(3).toString == four && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == "" && four == "" && five == "" && i(2).toString == three) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == "" && four == ""  && i(2).toString == three && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == "" && five == "" && i(3).toString == four && i(2).toString == three) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && two == ""  && i(2).toString == three && i(3).toString == four && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && three == "" && four == "" && five == "" && i(1).toString == two) {
        orderedWords = orderedWords :+ i
      }
      else  if (one == "" && three == "" && four == "" && i(4).toString == five && i(1).toString == two) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && three == "" && five == "" && i(3).toString == four && i(1).toString == two) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && three == "" && i(1).toString == two && i(4).toString == five && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && four == "" && five == "" && i(1).toString == two && i(2).toString == three) {
        orderedWords = orderedWords :+ i
      }
      else  if (one == "" && four == "" && i(1).toString == two && i(2).toString == three && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && five == "" && i(1).toString == two && i(2).toString == three && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (one == "" && i(4).toString == five && i(1).toString == two && i(2).toString == three && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && two == "" && three == "" && five == "" && i(0).toString == one) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && two == "" && three == "" && i(0).toString == one && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (five == "" && two == "" && three == "" && i(0).toString == one && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (two == "" && three == "" && i(0).toString == one && i(4).toString == five && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && two == "" && five == "" && i(0).toString == one && i(2).toString == three) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && two == "" && i(0).toString == one && i(2).toString == three && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (two == "" && five == "" && i(0).toString == one && i(2).toString == three && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (two == "" && i(0).toString == one && i(2).toString == three && i(3).toString == four && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (five == "" && three == "" && four == "" && i(0).toString == one && i(1).toString == two) {
        orderedWords = orderedWords :+ i
      }
      else if (three == "" && four == "" && i(0).toString == one && i(1).toString == two && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (three == "" && five == "" && i(0).toString == one && i(1).toString == two && i(3).toString == four) {
        orderedWords = orderedWords :+ i
      }
      else if (three == "" && i(0).toString == one && i(1).toString == two && i(3).toString == four && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (five == "" && four == "" && i(0).toString == one && i(1).toString == two && i(2).toString == three) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && i(0).toString == one && i(2).toString == three && i(1).toString == two && i(4).toString == five) {
        orderedWords = orderedWords :+ i
      }
      else if (five == "" && i(0).toString == one && i(2).toString == three && i(3).toString == four && i(1).toString == two) {
        orderedWords = orderedWords :+ i
      }
      else if (four == "" && two == "" && three == "" && five == "" && one == "") {
        orderedWords = potentialWords
      }
    }
  }

  def not(letters:String): Unit ={
    var enemy:List[String] = List()
    for(i <- orderedWords.distinct){
      for(j <- 0 until letters.length) {
        if (i.contains(letters.charAt(j))){
          enemy = enemy :+ i
        }
      }
    }
    print(orderedWords.diff(enemy))
  }

  def main(args: Array[String]): Unit = {
    contains("w", "r", "o", "n", "g")
    position("", "r", "o", "", "")
    not("cateatchfactscactitacitclassscamp")
  }
}