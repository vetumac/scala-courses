package klikatech._3_week.homework

object App {
  def main(args: Array[String]): Unit = {

    val point = new Point(100, 100)

    println(point.equals(new Point(1, 4)))
    println(point.move(2.5, 2))
    println(point.distance(new Point(3, 4)))
    println(point.compareTo(new Point(2, 4)))
  }
}
