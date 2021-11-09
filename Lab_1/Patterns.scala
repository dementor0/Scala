
import scala.io.StdIn.{readDouble, readInt, readLine}

/** Напишите решение в виде функции. 
 *
 * Синтаксис:
 *   val a: Int = ???
 *
 *   a match {
 *     case 0 => true
 *     case _ => false
 *   }
 */
object PatternMatching {

  sealed trait Hand

  case object Rock extends Hand

  case object Paper extends Hand

  case object Scissor extends Hand

  sealed trait Result

  case object Win extends Result

  case object Lose extends Result

  case object Draw extends Result

  sealed trait Food

  case object Meat extends Food

  case object Vegetables extends Food

  case object Plants extends Food

  sealed trait Animal {

    val name: String
    val food: Food
  }

  case class Mammal(name: String, food: Food, weight: Int) extends Animal

  case class Fish(name: String, food: Food) extends Animal

  case class Bird(name: String, food: Food) extends Animal

  def main(args: Array[String]): Unit = {
    println("Введите число")
    val r = readInt();
    println("Ответ а): " + testIntToString(r))
    println("Введите строку")
    val s = readLine();
    println("Ответ b): " + testIsMaxAndMoritz(s))
    println("Введите число")
    val n = readInt();
    if (testIsEven(n) == true) println("Ответ с: число четное") else println("Ответ с: число нечетное")
    println(testWinsA(Rock, Rock));
    var cat = new Mammal("cat", Meat, 10);
    println("Задание e: " + testExtractMammalWeight(cat));
    println("Задание f: " + testUpdateFood(Fish("goldfish", Plants)));

  }

  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
  * Если:
  *     1 => "it is one"
  *     2 => "it is two"
  *     3 => "it is three"
  *     иначе => "what's that"
  */
  def a(n: Int): String = {
    n match {
      case 1 => "it is one"
      case 2 => "it is two"
      case 3 => "it is three"
      case _ => "what's that"
    }
  }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = a(value).toString

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
  *     "max" или "Max
  *     "moritz" или "Moritz"
  */
  def b(s: String): Boolean = {
    s match {
      case "max" => true
      case "Max" => true
      case "moritz" => true
      case "Moritz" => true
      case _ => false
    }
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = b(value)

  // c) Напишите функцию проверки является ли `value` четным

  def c(n: Int): Boolean = {
    if (n % 2 == 0) return true else return false;
  }

  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = c(value)


  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага
  *     1. камень побеждает ножницы
  *     2. ножницы побеждают бумагу
  *     3. бумага побеждает камень
  *    Выиграет ли игрок `a`?
  */
  def d(a: Hand, b: Hand): Result = {
    if ((a == Rock) && (b == Rock)) return Draw;
    if ((a == Scissor) && (b == Scissor)) return Draw;
    if ((a == Paper) && (b == Paper)) return Draw;
    if ((a == Paper) && (b == Rock)) return Win;
    if ((a == Paper) && (b == Scissor)) return Lose;
    if ((a == Scissor) && (b == Rock)) return Lose;
    if ((a == Scissor) && (b == Paper)) return Win;
    if ((a == Rock) && (b == Scissor)) return Win;
    if ((a == Rock) && (b == Paper)) return Lose else return Lose;
  }


  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = d(a, b)



  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.


  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = {
    animal match {
      case Mammal(name, food, weight) => weight
      case _ => -1
    }
  }


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = {
    animal match {
      case Mammal(name, food, weight) => Mammal(name, food, weight);
      case Bird(name, food) => Bird(name, Plants);
      case Fish(name, food) => Fish(name, Plants);
    }

  }
}

