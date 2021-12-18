
sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

/** Напишите свои решения в виде функций. */
object RecursiveData {

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def a(list: List[Int]): Boolean = list match {
    case Nil() => true
    case _ => false
  }

  //используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = a(list)

  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def b(list: List[Int]): Int = list match {
    case Cons(head, tail) => head
    case Nil() => -1
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  //   def testListIntHead(list: List[Int]): Int = 0
  def testListIntHead(list: List[Int]): Int = b(list)

  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  // Добавить head в класс Nil
  //  case class Nil[A](head: A) extends List[A]

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]


}


