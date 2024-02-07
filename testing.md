### when testing using guice

**when injeting your controller in test class**

with GuiceOneAppPerSuite
declare your singleton controller class outside of tests
like:

```
TestMyApp extends PlaySpec with GuiceOneAppPerSuite with Injecting with Results{
  private val mycontroller = inject[ApplicationController]
  "ApplicationController#index" should {
     "return a HTML page" in{
       val response = mycontroller.index()
        response mustBe OK
     }
   }
}
```

with GuiceOneAppPerTest
declare your singleton controller class inside tests
like:

```
TestMyApp extends PlaySpec with GuiceOneAppPerTest with Injecting with Results{
  "ApplicationController#index" should {
     "return a HTML page"in{
       private val mycontroller = inject[ApplicationController]
       val response = mycontroller.index()
        response mustBe OK
     }
   }
}
```

If we declate wrongly we'll get `java.lang.NullPointerException` and test will be **ABORTED** 
