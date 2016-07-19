package klikatech._4_week.homework

import scala.annotation.tailrec

class Func {

  def hiOrderFunction(f: Any => Any, g: Any => Any) = (x: Any) => {
    g(f(x))
    f(x)
  }

  def sqrList(elements: List[Int]): List[Int] = {

    def sqr(x: Int): Int = x * x

    @tailrec def sqrAcc(f: Int => Int, acc: List[Int], lst: List[Int]): List[Int] =
      if (lst.isEmpty) acc
      else sqrAcc(sqr, f(lst.head) :: acc, lst.tail)

    sqrAcc(sqr, Nil, elements)
  }

  def printRes(f: Any => Any) = hiOrderFunction(f, (x: Any) => println(x))

  def sqrt(x: Double) = {
    val tolerance = 0.0001
    def isCloseEnough(x: Double, y: Double) = (Math.abs(x - y) / x) / x < tolerance

    def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

    def fixedPoint(f: Double => Double)(firstGuess: Double) = {
      def iterate(guess: Double): Double = {
        val next = f(guess)
        if (isCloseEnough(guess, next)) next
        else iterate(next)
      }
      iterate(firstGuess)
    }
    fixedPoint(averageDamp(y => x / y))(1)
  }
}
