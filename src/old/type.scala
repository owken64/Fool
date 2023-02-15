package type

abstract class Type(val t: Int){
    require( t >= 0 , "type is larger equal than 0")
    
    def include(that:Type) :Boolean
    def contains(that: Type):Boolean = include(that)
    def ni (that: Type): Boolean = include(that) // ni is the reverse of in
}

abstract class Type0 extends Type(0) {
    def include(that:Type) : Boolean = false
    def in(that:Type) : Boolean = that include this
}

abstract class Type1 extends Type(1) 

abstract class Type2 extends Type(2)

