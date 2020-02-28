package com.test.tarea1
import kotlin.math.absoluteValue
/*
Nombre: Abraham Lemus Ruiz
Matrícula: A01207538

Problemas a resolver:

P21 (*) Insert an element at a given position into a list.

    function insertAt (value: <T>, index: Int, list: List): List{
        List myList = []
        for i in range 0, list.length :
            if i == index:
                myList.push(value)
            myList.push(list[i])
         return myList
    }

    Casos de prueba:

    > insertAt('X', 1, "abcd".toList())
    [a, X, b, c, d]

    > insertAt('12', 4, "rtyui".toList())
    [r, t, y, u, 12, i]

    > insertAt('QQ', 0, "abcd".toList())
    [QQ, a, b, c, d]

P36 (*) Determine the prime factors of a given positive integer (2).

    function getPrimeFactors (value: int): List{
        List list = ()
        Int factor = 2
        while value != 1:
            if value mod factor == 0: //factor
                value/=factor
                list.push(factor)
            else:  //sigue buscando
                factor++
        return list
    }

    function getPrimeFactorMultiplicity(val: Int): List(Pair(int, int)){
        list =getPrimeFactors(val)
        Map map = ()
        list result = ()
        //construir mapa con multiplicidades
        for i in list:
            if i in map.keys:
                map[i] += 1
            else:
                map[i] = 1

        //pasar mapa a lista de pares
        for key, value in map:
            result.add( (key, value) )
        return result
    }

    Casos de prueba:
    > 315.primeFactorMultiplicity()
    [(3, 2), (5, 1), (7, 1)]
    > 727.primeFactorMultiplicity()
    [(727, 1)]
    > 56781.primeFactorMultiplicity()
    [(3, 4), (701, 1)]

*/

fun <T> insertAt(v: T, i: Int, list: List<T>):List<T>{
    val mutable = mutableListOf<T>()
    var encontrado: Int = 0
    for ((index, value) in list.withIndex()) {
        if(index == i){
            mutable.add(i, v)
            encontrado = 1
        }
        mutable.add(index+encontrado, value)
    }
    return mutable
}




fun Int.primeFactors(): List<Int>{
    val mutable = mutableListOf<Int>()
    var num : Int = this.absoluteValue
    var counter = 2
    while(num!=1){
        if(num%counter == 0){
            mutable.add(counter)
            num/=counter
        }else{
            counter++
        }
    }
    return mutable
}


fun Int.primeFactorMultiplicity():List<Pair<Int, Int>>{
    var list: List<Int> = this.primeFactors()
    var map = mutableMapOf<Int, Int>()
    val final = mutableListOf<Pair<Int, Int>>()

    for (value in list) {
        map.put(value, map.getOrDefault(value, 0) + 1)
    }

    for ((k, v) in map) {
        final.add(Pair(k, v))
    }
    return final
}

println(insertAt('X', 1, "abcd".toList()))
println(insertAt("12", 4, "rtyui".toList()))
println(insertAt("QQ", 0, "abcd".toList()))

println(315.primeFactorMultiplicity())
println(727.primeFactorMultiplicity())
println(56781.primeFactorMultiplicity())