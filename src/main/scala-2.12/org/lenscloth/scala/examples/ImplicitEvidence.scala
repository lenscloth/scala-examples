package org.lenscloth.scala.examples

object ImplicitEvidence {

  // Create own implicit evidence
  sealed abstract class Transformable[-From, +To] extends (From => To)

  // Implicit Evidence Example
  trait TraversableExample[+A] {
    def toMap[T, U](implicit ev: <:<[A, (T,U)]): scala.collection.immutable.Map[T,U]
  }

  class ListExample[A](h: A, t: ListExample[A]) extends TraversableExample[A] {
    def this(head: A) = this(head, null)

    def head: A =
      if(this.h == null)
        throw new java.util.NoSuchElementException("head of empty list")
      else
        this.h

    def tail: ListExample[A] =
      if(this.t == null)
        throw new java.lang.UnsupportedOperationException("tail of empty list")
      else
        this.t

    def toMap[T,U](implicit ev: <:<[A, (T,U)]): scala.collection.immutable.Map[T,U] = {
      if(this.t == null)
        scala.collection.immutable.Map(ev.apply(head))
      else
        scala.collection.immutable.Map(ev.apply(head)) ++ tail.toMap
    }
  }



  def main(args: Array[String]): Unit = {
    val l = new ListExample(1, new ListExample(2, new ListExample(3)))
    // l.toMap !compile Err!
    val l2 = new ListExample((1,"Hello"), new ListExample((2,"World")))
    l2.toMap // OK

    println("Compiler found required implicit variable")
    
  }
}

