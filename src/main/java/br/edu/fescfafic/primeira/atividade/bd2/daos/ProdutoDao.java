package br.edu.fescfafic.primeira.atividade.bd2.daos;

import br.edu.fescfafic.primeira.atividade.bd2.entities.JpaUtil;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDao {
    public Produto salvarProduto(Produto produto) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        return produto;
    }

    public List<Produto> listarProdutos() {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        List<Produto> produtos = em.createQuery("select p from Produto p", Produto.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return produtos;
    }

    public Produto buscarProdutoPorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        em.getTransaction().commit();
        em.close();
        return produto;
    }

    public void excluirProduto(Produto produto) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizarProduto(Long id, Produto produto) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Produto produtoAtual = em.find(Produto.class, id);

        if (produtoAtual != null) {
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setDescricao(produto.getDescricao());
            produtoAtual.setPreco(produto.getPreco());
            em.merge(produto);
        } else {
            System.out.println("Produto não encontrado!");
        }
        em.getTransaction().commit();
        System.out.println("Produto atualizado com sucesso!" + produto.getNome());
        em.close();
    }

}
