import Classes.Meat

import scala.io.StdIn.readLine

object Classes {
/* 
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 */
  class Animal( val name:String, val species:String,val food:String)  {
  def eats(food:String):Boolean = {
    if ((food == "meat") && (name == "cat")) true else if ((food == "vegetables") && (name == "parrot")) true else if ((food == "plants") && (name == "goldfish")) true else {
      false
    }
  }
}
  sealed trait Food
  case object Meat      extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal1 {

    val name: String
    val food: String
  }
  case class Mammal(name: String, food: String) extends Animal1
  case class Fish(name: String, food: String)                extends Animal1
  case class Bird(name: String, food: String)                extends Animal1
  sealed trait F

/*
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 */
object Animal{
    def cat() = new Animal("cat", "mammal", "meat");
    def parrot() = new Animal("parrot", "bird", "vegetables");
    def goldfish() = new Animal("goldfish", "fish", "plants");
}
  object Animal1{
    def knownAnimal(name: String): Boolean =
    if ((name == "cat" ) || (name == "parrot") || (name == "goldfish")) true else false
    def apply(name: String): Option[Animal1] = {
      if (name == "cat") Some[Animal1](Mammal("cat", "meat"))
      else if (name == "parrot") Some[Animal1](Bird("parrot", "vegetables"))
      else if (name == "goldfish") Some[Animal1](Fish("goldfish", "plants")) else None[Animal1];
    };
    def apply1(food:String): Option[Food] = {
      if (food == "meat") Some[Food](Meat)
      else if (food == "vegetables") Some[Food](Vegetables)
      else if (food == "plants") Some[Food](Plants) else None[Food];
    };
  }
/*
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 *
 */
/*
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 *
 */
/*
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 *
 */
/*
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

  def main(args: Array[String]): Unit = {
    println("Задание с: ")
    println("Введите животное:")
    val str1 = readLine();
    println("Введите еду: ")
    val str2 = readLine();
    str1 match {
      case "cat" =>  println(Animal.cat.eats(str2));
      case "parrot" =>  println(Animal.parrot.eats(str2));
      case "goldfish" =>  println(Animal.goldfish.eats(str2));
      case _ => println(str1 + " не ест " + str2 );
    }
    println("Задание e: ")
    val str3 = readLine();
    println (Animal1.knownAnimal(str3));
    println (Animal1.apply(str3));
    println("Задание f: ")
    val str4 = readLine();
    println (Animal1.apply1(str4));
  }

  sealed trait Option[A] {

    def isEmpty: Boolean
  }

  case class Some[A](a: A) extends Option[A] {
    val isEmpty = false
  }

  case class None[A]() extends Option[A] {
    val isEmpty = true
  }
}
