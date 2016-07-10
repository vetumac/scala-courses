package klikatech._3_week.homework

class Point(x: Double, y: Double) {
  override def toString = "(" + x + ";" + y + ")"

  override def equals(that: Any): Boolean = {
    that match {
      case point: Point => this.x == point.x && this.y == point.y
      case _ => false
    }
  }

  override def hashCode: Int = x.hashCode() + 31 * y.hashCode()


}

