package Notes.EsercizioLiveKotlin

fun main(){
    val pc1 = Computer("Windows", 350, 4, "Celeron")
    val pc2 = Computer("Linux", 700, 16, "Ryzen 3")
    val pc3 = Computer("Mac", 1500, 16, "AM1")
    val pc4 = Computer("Windows", 2000, 32, "Intel i7")

    println(pc1)
    println(pc2)
    println(pc3)

    val class1 = Classroom(mutableListOf(pc1,pc2,pc4))
    class1.addPC(pc3)

    //println(class1)

    println(class1.groupByOS()["Windows"])

    //class1.addMorePC(listOf(pc1,pc2,pc3))

    //println(class1.computers.filterByRAM(16))
   // println(class1.computers.filterByOS("Linux"))


}

data class Computer(val os : String, val price : Int, val ram : Int, val cpu : String)

data class Classroom(val computers : MutableList<Computer> = mutableListOf()){

    fun addPC(computer : Computer){
        computers.add(computer)
    }

    fun addMorePC(computers : List<Computer>){
        this.computers.addAll(computers)
    }

    fun groupByOS(): Map<String, List<Computer>>{
        val map =  mutableMapOf<String, List<Computer>>()
        map["Windows"] = computers.filterByOS("Windows")
        map["Linux"] = computers.filterByOS("Linux")
        map["Mac"] = computers.filterByOS("Mac")
        return map
    }
}

fun List<Computer>.filterByRAM(ram: Int): List<Computer>{
    return this.filter{it.ram == ram}
}

fun List<Computer>.filterByOS(os: String):List<Computer>{
    return this.filter{it.os == os}
}

