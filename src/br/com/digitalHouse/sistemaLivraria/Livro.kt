package br.com.digitalHouse.sistemaLivraria

data class Livro(override var codigo: Int,
                 val titulo: String,
                 val autor: String,
                 val anoDeLancamento: Int,
                 var quantidade: Int,
                 override var preco: Double): IProduto {
}