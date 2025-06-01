import scala.collection.immutable.Map.from
import scala.util.Try
import play.api

implicit var udin : String = "sedunia"

object implicitTest extends App{
//  val hehe = new coba
//  implicit val name : String = "Udin"
  implicit val namess : Integer = 2313
  implicit val age : Int = 123


//  def sayHello(implicit  name: String, age : Int):Unit={
//    println(s"Hallo $name -> $age")
//  }
//  sayHello()
//  def sayHello(name : String)(implicit age : Int):Unit={
//    println(s"Hallo $name -> $age")
//  }
////  sayHello("udin")
//  sayHello{"udin"}
//
//  val opt1 : Option[Int] = None

  val testData : List[String] = List("Udin", "2", "1", "3", "Merah", "4", "Biru")
  testData.map( hehe =>
    Try(hehe.toInt).toOption.map(x=>x*x).getOrElse(0)
  ).filter(x=>x!=0).reverse.sorted.foreach(println(_));

}
