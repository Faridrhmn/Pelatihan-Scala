import play.api.libs.json.{JsValue, Json, JsObject}

object testJson extends App {
  val json : JsValue = Json.parse{
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
  
//  val jsone : JsObject = Json.parse(
//    
//  )

  println(json.isInstanceOf[JsValue])
  println(Json.prettyPrint(json))

}
