object Main {
  def main(args: Array[String]):Unit= {
    println("Compositions")
    println("testCompose", Compositions.testCompose((a:Int)=> a*3)((b:Int)=>b*2)((c:Int)=>Math.pow(c,2))(1))
    println("testMapFlatMap", Compositions.testMapFlatMap((a:Int)=> Some(a.toString))((b:String)=> Some(b.isBlank))((c:Boolean)=> c.toString)(Some(0)))
    println("testForComprehension", Compositions.testForComprehension((a:Int)=> Some(a.toString))((b:String)=> Some(!b.isBlank))((c:Boolean)=> c.toString)(Some(5)))
    println("Recursive-Functions")
    println("testReverse", RecursiveFunctions.testReverse(Cons(1,Cons(2, Cons(3, Nil())))))
    println("testMap", RecursiveFunctions.testMap(Cons(1,Cons(2, Cons(3, Nil()))), (a:Int)=>a*2))
    println("testFlatMap", RecursiveFunctions.testFlatMap(Cons(1,Cons(2, Cons(3, Nil()))),(a:Int)=>Cons(a*2,Nil())))
    println("Recursive-Data")
    println("testListIntEmpty", RecursiveData.testListIntEmpty(Cons(1,Nil())))
    println("testListIntEmpty", RecursiveData.testListIntEmpty(Nil()))
    println("testListIntHead", RecursiveData.testListIntHead(Cons(1,Nil())))
  }
}