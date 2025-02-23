package br.edu.fescfafic.primeira.atividade.bd2.daos;

import br.edu.fescfafic.primeira.atividade.bd2.entities.JpaUtil;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Produto;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Venda;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VendaDao {
    public Venda cadastroVenda(Venda venda) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.persist(venda);
        System.out.println("Venda: Cliente - " + venda.getCliente_id().getNome());
        System.out.println("Venda: Valor - " +  venda.getTotal());
        em.close();
        return venda;
    }

    public List<Venda> listaVendas() {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        List<Venda> vendas = em.createQuery("select c from Venda c", Venda.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return vendas;
    }

    public Venda buscaVendaPorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Venda venda = em.find(Venda.class, id);
        em.getTransaction().commit();
        em.close();
        return venda;
    }

    public void excluirVenda(Venda venda) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.remove(venda);
        em.getTransaction().commit();
        em.close();

    }

    public void atualizarVenda(Long id, Venda venda) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Venda vendaAtual = em.find(Venda.class, id);
        if (vendaAtual != null) {
            vendaAtual.setCliente_id(venda.getCliente_id());
            vendaAtual.setProdutos(venda.getProdutos());
            vendaAtual.setDataVenda(venda.getDataVenda());
            vendaAtual.setTotal(venda.getTotal());
            em.merge(vendaAtual);
        } else {
            System.out.println("Venda não encontrada");
        }
        em.getTransaction().commit();
        System.out.println("Venda atualizado com sucesso");
        em.close();

    }
    public void somarValores(List<Produto> produtos) {
        Double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Soma"+total);

        }

    }
}
