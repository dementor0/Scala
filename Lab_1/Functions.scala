import scala.io.StdIn.{readDouble, readInt}

/** Напишите отдельные функции, решающие поставленную задачу.
 *
 * Синтаксис:
 *   // метод
 *   def myFunction(param0: Int, param1: String): Double = // тело
 *
 *   // значение
 *   val myFunction: (Int, String) => Double (param0, param1) => // тело
 */
object Functions {
  def main(args: Array[String]): Unit = {
    println("Введите радиус:")
    val r = readDouble();
    println("Ответ а): " + testCircle(r))
    println("Введите a:")
    val a = readDouble();
    println("Введите b:")
    val b = readDouble();
    println("Ответ b): " + testRectangleCurried(a,b))
    println("Введите a:")
    val a1 = readDouble();
    println("Введите b:")
    val b1 = readDouble();
    println("Ответ c: " + testRectangleUc(a,b))
  }

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def f(r:Double):Double={
    r*r*Math.PI;
  }



  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = f(r)



  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def f1(a:Double) = (b:Double) => a*b;



  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = f1(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def f2(a:Double,b:Double) =a*b;

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = f2(a,b)
}