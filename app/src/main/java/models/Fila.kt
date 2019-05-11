package models

class Fila (val producto: Producto) {
    private var cantidad:Int=0
    fun setCantidad(ncant:Int){
        this.cantidad =ncant
    }
    fun getCantidad():Int{return cantidad}
    override fun toString(): String {
        return "\$producto - \$cantidad"
    }
}