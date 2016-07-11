package klikatech._3_week.homework

class Point(val x: Double, val y: Double) {

  def move(x: Double, y: Double): Point = new Point(x + this.x, y + this.y)

  def distance(that: Point): Double = Point.distance(this, that)

  def compareTo(that: Any): Int = that match {
    case point: Point => Point.distance(point, new Point(0, 0)) - Point.distance(this, new Point(0, 0)) match {
      case i if i > 0 => 1
      case i if i < 0 => -1
      case _ => 0
    }
    case _ => throw new IllegalArgumentException
  }

  def quadrant: String = this match {
    case p if p.x > 0 && p.y > 0 => "First"
    case p if p.x > 0 && p.y < 0 => "Second"
    case p if p.x < 0 && p.y > 0 => "Third"
    case p if p.x < 0 && p.y < 0 => "Fourth"
    case _ => "Not in any quadrant"
  }

  override def toString = "(" + x + ";" + y + ")"

  override def equals(that: Any): Boolean = that match {
    case point: Point => x == point.x && y == point.y
    case _ => false
  }

  override def hashCode: Int = ("" + x + y).hashCode

}

object Point {
  def distance(p1: Point, p2: Point): Double = math.sqrt(math.pow(p1.x - p2.x, 2) + math.pow(p1.y - p2.y, 2))

  def isSimeteic(p1: Point, p2: Point): Boolean = p1.x == -p2.x && p1.y == -p2.y

  def isCollinear(p1: Point, p2: Point, p3: Point): Boolean = (p3.y - p1.y) * (p2.x - p1.x) == (p2.y - p1.y) * p3.x - (p2.y - p1.y) * p1.x
}

