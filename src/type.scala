package type

abstract class Type(val t: Int){
    require( t >= 0 , "type is larger equal than 0")
    
    def in(that:Type) :Boolean
}

abstract class Type0 extends Type(0) {
    def in(that:Type) : Boolean = false
}

abstract class Type1 extends Type(1) 

abstract class Type2 extends Type(2)

