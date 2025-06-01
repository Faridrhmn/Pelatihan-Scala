import play.api.libs.json.{JsObject, JsValue, Json}
import ujson.*

import scala.collection.mutable

object latihan extends App{
  val json: JsValue = Json.parse {
    """
      |{
      |  "name" : "Watership Down",
      |  "location" : {
      |    "lat" : 51.235685,
      |    "long" : -1.309197
      |  },
      |  "residents" : [ {
      |    "name" : "Fiver",
      |    "age" : 4,
      |    "role" : null
      |  }, {
      |    "name" : "Bigwig",
      |    "age" : 6,
      |    "role" : "Owsla"
      |  } ]
      |}
      |""".stripMargin
  }

  val jsonString:String = json.toString;
  val jsonConvert: ujson.Value = ujson.read(jsonString)

  val address: mutable.Map[String, ujson.Value] = jsonConvert.obj
//  AKSES NAMA
  val name: String = address("name").str
  println(s"nama dari address : $name")
//  AKSES LOKASI
  val location: mutable.Map[String, ujson.Value] = address("location").obj
  println(s"location dari address : $location")
  val lat: Double = address("location")("lat").num
  val long: Double = address("location")("long").num
  println(s"isi dari location lat : $lat")
  println(s"isi dari location long : $long")
//  AKSES RESIDENT
  val residents: mutable.Buffer[ujson.Value] = address("residents").arr
  val firstResidents = residents(0)
  val nameResident: String = firstResidents("name").str
  val ageResident: Double = firstResidents("age").num
  val roleResident = firstResidents("role")
  println(s"isi dari resident : $residents")
  println(s"isi dari resident pertama: $firstResidents")
  println(s"isi dari nama resident pertama: $nameResident")
  println(s"isi dari umur resident pertama: $ageResident")
  println(s"isi dari role resident pertama: $roleResident")
  residents.map( hehe =>
    val nama = hehe("name").value
    val umur = hehe("age").value
    val role = hehe("role").value
    println(s"penduduk ke : $hehe.")
    println(s"Nama penduduk : $nama")
    println(s"Umur penduduk : $umur")
    println(s"Role penduduk : $role")
  )

//  sumber : https://docs.scala-lang.org/toolkit/json-parse.html
}
