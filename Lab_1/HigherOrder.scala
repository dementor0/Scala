import scala.io.StdIn.readInt


/** Напишите ваши решения в виде функций. */
object HigherOrder {

  val plus: (Int, Int) => Int =  _+_
  val multiply: (Int, Int) => Int =  _*_
  val a = readInt()
  val b = readInt()
  val n = readInt()

  /* a) Напишите функцию, которая принимает f: (Int, Int) => Int, параменты a и b
   *    и коэффициент умножения n и возвращает n * f(a, b). Назовите nTimes.
   */
  def f(a:Int,b:Int):Int ={
     plus(a,b)
  }
  def nTimes(f:Int, n:Int):Int={
     multiply(f,n)
  }
  def main(args: Array[String]): Unit = {
    println("Ответ а) - " + testNTimes(f:(Int,Int)=>Int,a,b,n))
    println("Ответ b) - " + testAnonymousNTimes(a,b))
  }


  // примените вашу функцию (a) здесь, не изменяйте сигнатуру
  def testNTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = nTimes(f(a,b),n)

  /* b) Напишите анонимную функцию, функцию без идентификатора ((a, b) => ???) для nTimes которая
   *    выполняет следующее:
   *          if (a > b) a else b
   */
  var testAnonymousNTimes = (a: Int, b: Int) => if (a > b) a else b
}