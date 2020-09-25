package br.com.digitalHouse.sistemaLivraria

class GerenciadorLivraria {
    private val estoqueLivraria = mutableListOf<Livro>()
    private val estoqueColecaoLivraria = mutableListOf<Colecao>()

    fun cadastrarLivro(vararg livro: Livro){
        livro.forEach {
            when(this.consultarLivroPorCodigo(it.codigo,"Livro") == null){
                true -> estoqueLivraria.add(it)
                false -> println("O livro ${it.titulo} já foi cadastrado ou o código já existe")
            }
        }
        //println(estoqueLivraria)
    }
    fun cadastrarColecao(colecao: Colecao){
        when(this.consultarLivroPorCodigo(colecao.codigo,"Coleção") == null){
            true -> estoqueColecaoLivraria.add(colecao)
            false -> println("A coleção ${colecao.listaDeLivros} já foi cadastrado ou o código já existe")
        }
        //println(estoqueColecaoLivraria)
    }

    fun consultarLivroPorCodigo(codigo: Int, tipoDeProduto: String): IProduto?{
        when(tipoDeProduto){
            "Livro" -> return estoqueLivraria.find {it.codigo == codigo}
            "Coleção" -> return estoqueColecaoLivraria.find {it.codigo == codigo}
        }
        return null
    }

    fun efetuarVenda(codigo: Int, tipoDeProduto: String){
        var decisao = true
        when(tipoDeProduto){
            "Livro" -> {
                val produto = estoqueLivraria.find { it.codigo == codigo }
                when(produto != null){
                    true -> {
                        when (produto.quantidade > 0){
                            true ->{
                                produto.quantidade--
                                println("Venda no valor de R$${produto.preco}")
                            }
                            false -> println("Produto esgotado")
                        }
                    }
                    false -> println("Produto inexistente")
                }
            }
            "Coleção" -> {
                val colecao = estoqueColecaoLivraria.find { it.codigo == codigo }
                when(colecao != null){
                    true -> {
                        colecao.listaDeLivros.forEach(){
                            decisao = decisao && it.quantidade>0
                        }
                        when(decisao){
                            true -> {
                                colecao.listaDeLivros.forEach(){it.quantidade--}
                                println("Venda no valor de R$${colecao.preco}")
                            }
                            false -> println("Produto esgotado")
                        }
                    }
                    false -> println("Produto inexistente")
                }
            }
        }
        //println(estoqueLivraria)
    }
}