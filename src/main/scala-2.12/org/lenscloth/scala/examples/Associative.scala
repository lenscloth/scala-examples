package org.lenscloth.scala.examples

object Associative {
  // Left Associative
  // caller method argument
  case class NumberLeft(x: Int) {
    def /(v: Int) = NumberLeft(x / v)
    override def toString = x.toString
  }

  // Right Associative
  // argument method caller
  case class NumberRight(x: Int) {
    def /:(v: Int) = NumberRight(v / x)
    override def toString = x.toString
  }

  def main(args: Array[String]) = {
    println(s"50 / (25 / 5) == ${50 /: 25 /: NumberRight(5)}")
    println(s"(50 / 25) / 5 == ${NumberLeft(50) / 25 / 5}")
  }
}