// key and map pair
// values can have duplicates, keys are not

val r1 = "m3"
val r2 = "m5"
val r3 = "m7"

val myMap = mapOf("first car" to r1, "second car" to r2, "third car" to r3)
// Map <key_type, value_type>

val r4 = "m5"

fun main(){
    println(myMap.containsKey("fourth car"))

    if (myMap.containsValue(r4)){
        val r5 = myMap.get("auf")
        // get returns a null if the specified key doesn't exist and getValue throws an exception.
        println(r5)
    } else println("Error")

    for ((x, y) in myMap){
        println("Key is $x and value is $y")
    }
    // map is immutable but mutableMap exists too

    val s1 = BMWs ("7", "330")
    val s2 = BMWs ("5","440")
    val s3 = BMWs ("3", "328")
    val s4 = BMWs ("${6}", "650")
    val s5 = BMWs ("8", "i8")
    /*
    val s1 = myCars ("7", "330")
    val s2 = myCars ("5","440")
    val s3 = myCars ("3", "328")
     */

    val bmwMap = mutableMapOf("first bmw" to s1, "second bmw" to s2)
    bmwMap.put("third bmw", s3)
    //similar to bmwMap["third bmw"] = s3
    for ((key, value) in bmwMap) println("Key is $key and value is $value")

    // if mutableMap already contains the specified key, the put fun replaces the value for that key and returns the original value
    val addBMWs = mapOf("fourth bmw" to s4, "fifth bmw" to s5)
    bmwMap.putAll(addBMWs)
    println(bmwMap)

    //bmwMap.remove("third bmw")
    //println(bmwMap) - removes anyway

    bmwMap.remove("fourth bmw", s4) //removes only if key and value associated
    println(bmwMap)
    //bmwMap.clear()

    //you can take a snapshot of a mutableMap by toMap(), toList()

    //entries property returns a Set (if it used with a MutableMap) and mutableSet if it's used with a mutableMap

    val bmwEntries = bmwMap.entries
    println(bmwEntries)
    val bmwKeys = bmwMap.keys
    val bmwValues = bmwMap.values
    println(bmwKeys)
    println(bmwValues)

    val x = mutableSetOf(1,2)
    val y: Set<Int> = x


}