abstract class Field[T](val: plus:(T,T)=>T, val dot:(T,T)=>T, val e:T, val zero:T, val invPlus:T=>T, val invDot: T=>T) extends Ring[T](plus, dot, e, invPlus)