package br.com.digitalHouse.sistemaLivraria

fun main(){
    val seboDoLeo = GerenciadorLivraria()

    val livro1 = Livro(0,"Harry Potter e a Pedra Filosofal", "J. K. Rowling",1997,10,10.00)
    val livro2 = Livro(1,"Harry Potter e a Câmara Secreta", "J. K. Rowling",1998,0,10.00)

    val colecaoHarryPotter = Colecao(2, mutableListOf(livro1,livro2),"Coleção Harry Potter", 15.00)

    seboDoLeo.cadastrarLivro(livro1,livro2)
    seboDoLeo.cadastrarColecao(colecaoHarryPotter)

    seboDoLeo.efetuarVenda(2,"Coleção")
}