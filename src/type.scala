package type

abstract class Type(val t: Int){
    require( t >= 0 , "type is larger equal than 0")
    
    def in(that:Type) :Boolean = {
        if (this.t - that.t == 1) true
        else false
    }
}

abstract class Type0 extends Type(0) 

abstract class Type1 extends Type(1) 

abstract class Type2 extends Type(2)

