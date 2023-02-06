class Relation[T](op: (T,T)=>Boolean) extends Function[(T, T), Boolean](op)
