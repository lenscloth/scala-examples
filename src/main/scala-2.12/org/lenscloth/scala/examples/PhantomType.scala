package org.lenscloth.scala.examples

object PhantomType {
  trait Person[T]

  trait Old
  trait Young

  trait Conservative
  trait Progressive

  def onlyOldAndProgressive(p: Person[Old with Progressive]): Unit = {

  }

  def main(args: Array[String]): Unit = {
    val a = new Person[Old with Progressive] {}
    val b = new Person[Old] {}
    onlyOldAndProgressive(a) // copile!
    // onlyOldAndProgressive(b) // not compile!
  }

}
