package something

import logic

abstract class Something {
    val name: Option[String]
    val typeName: String
    val logic: List[LogicalFormula]

    override def toString(): String = {
        if !name.isEmpty then{
            name.get + ":" + this.typeName
        }
        else {
            "Anon" + ":" + this.typeName
        }
    }
}

class AnonymousSomething(t: String)