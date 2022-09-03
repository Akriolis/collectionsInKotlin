var array = arrayOf(1,2,3)
var nullArray: Array<String?> = arrayOfNulls(5)
val size = array.size
val isIn = array.contains(2)
val sum = array.sum() // if they are numeric
val average = array.average().toInt() // in this case - (2+3+1)/3=2.0
val booleanArray: Array<Boolean> = arrayOf(true, false,true, false,true)

data class myCars (val title: String, val model: String)

class BMWs (val series: String, val model: String)

fun main(){
    println(nullArray[0])
    println(size)
    println(array[0])
    array.reverse()
    println(array[0])
    println(sum)
    println(average)
    booleanArray.sort()
    for (x in booleanArray){
        print("$x ")
    }
    array.sort() // works for number, strings, chars and booleans
    println("The array min is ${array.min()} and the array max is ${array.max()}")

    // array size cannot be changed
    // arrays can be updated which might lead to some bugs

    val myArray = arrayOf(1,2,3,4,5)
    myArray[2] = 6
    for (each in myArray){
        print("$each ")
    }

    val myArray2 = myArray.plus(6)
    for (each in myArray2){
        print("$each ")
    }
    println("")

    // Kotlin has three main types of collection - List, Set, Map.
    // Map keys can be any objects
    // Simple lists, sets and maps are immutable, which means that you can't add or remove items
    // after the collection has been initialized

    val shopping = listOf("Tea", "Eggs", "Milk")
    //similar to
    val shopping2: List<String>
    shopping2 = listOf("Tea", "Eggs", "Milk")
    if (shopping.isNotEmpty()){
        println(shopping.get(0)) // the same as shopping[0]
    }

    for (x in shopping) print("$x ")
    println("")

    if (shopping.contains("Eggs")){
        println(shopping.indexOf("Eggs"))
    }
    // shopping[1] = "Eggs" not compile because its immutable

    // if you want a list whose values you can update, you need to use a mutableList

    val mShopping = mutableListOf("Tea", "Eggs")

    // mutableList extra functions - add and remove values, or update or rearrange existing ones

    mShopping.add("Milk") // new values are add to the end of the mutableList
    println(mShopping)

    mShopping.add(0,"Bread") // add by index

    mShopping.remove("whops")
    // you can wrap it in expression
    if (mShopping.contains("Milk")){
        mShopping.remove("Milk")
    }
    println(mShopping)

    //mShopping.removeAt(1)
    if (mShopping.size > 1){
        mShopping.removeAt(0)
    }
    println(mShopping)

    mShopping.add(0,"Bread")
    mShopping.add(3,"Apple")

    println(mShopping)
    //removing a value from the MutableList causes it to shrink

    //to replace one value with another - use set function
    mShopping.set(1, "Coffee")
    println(mShopping)

    mShopping.sort()
    println(mShopping)

    mShopping.reverse()
    println(mShopping)

    mShopping.shuffle()
    println(mShopping)

    val toAdd = listOf("Cookies", "Sugar")
    mShopping.addAll(toAdd)
    //mShopping.addAll(0,toAdd)
    println(mShopping)

    val toRemove = listOf("Coffee", "Sugar")
    mShopping.removeAll(toRemove)
    println(mShopping)

    val toRetain = listOf("Apple", "Cookies")
    mShopping.retainAll(toRetain) // saves only given values and removes everything else
    println(mShopping)

    mShopping.add("Apple")

    //mShopping.clear()
    //println(mShopping)

    // it is possible to make a snapshot of mutableList state, for example

    val shoppingCopy = mShopping.toList()
    println(shoppingCopy)

    // another useful functions - sorted(), reversed(), shuffled()
    // and mutableList can be copied in another mutableList by function toMutableList()

    // a list can hold duplicate values and Set are not

    val friendSet = setOf("Jim", "Sue", "Nick", "Sue")
    println(friendSet) //one of the "Sue" string values was ignored
    // set's values are unirdered, so friendSet[0] = "Jimmy" not going to work

    val isFredGoing = friendSet.contains("Fred") //isFredGoing returns false
    if (isFredGoing) println ("he is going") else println ("he is not going")
    for (each in friendSet) print ("$each ")
    println("")
    //set is immutable, so it isn't possible to add values or remove


    val carSet = setOf(
        myCars("Honda", "Sivic"),
        myCars("Toyota", "Camry"),
        myCars("BMW", "738"),
        myCars("Toyota", "Camry")) //myCars is data class,equals and hashCode functions already overwritten

    println(carSet)

    val bmwSet = setOf(
        BMWs("7", "738"),
        BMWs("5", "525"),
        BMWs ("7", "738")) //bmwSet is a plain class, so it use standard equals and hashCode functions
    println(bmwSet)

    /*
    rules for overriding
    - if two objects are equal they must have matching hash codes
    - if objects are equal, calling equals on either object must return true
    - if two objects have the same hash code value they are not required to be equal
    - if you are override equals, you must override hashCode
    - the default behavior of the hashCode function is to generate a unique integer for each object
    - the default behavior of the equal function is to do a === comparison, which tests whether the two references refer to a single object
    */

    //mutableSet
    val mFriendSet = mutableSetOf("Jim", "Josh")
    mFriendSet.add ("Nick")
    println(mFriendSet)
    mFriendSet.add ("Jim")
    println(mFriendSet)

    val friendSetCopy = mFriendSet.toSet()
    val friendList = mFriendSet.toList()

    if (mShopping.size > mShopping.toSet().size){
        println("mShopping contains duplicates")
    }

    //btw it is possible to copy an array: toList(), toMutableList(), toSet(), toMutableSet().
    // and copy any List or Set intro array by toTypedArray() function
    val testArray = mFriendSet.toTypedArray()
    println(testArray[0])

    val a = setOf(1,2,3)
    val b = setOf(3,2,1)
    val b2 = mutableSetOf(2,3,1)

    if (a == b) println(true) else println(false)

    if (a == b2) println(true) else println(false)

    // same for the Lists and mutableLists

}