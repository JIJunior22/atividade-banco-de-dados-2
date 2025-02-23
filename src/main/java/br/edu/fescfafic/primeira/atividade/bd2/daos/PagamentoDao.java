package br.edu.fescfafic.primeira.atividade.bd2.daos;

import br.edu.fescfafic.primeira.atividade.bd2.entities.JpaUtil;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Pagamento;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Venda;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PagamentoDao {
    public Pagamento cadastroPagamento(Pagamento pagamento) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
        em.close();
        return pagamento;
    }

    public List<Pagamento> listaPagamentos() {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        List<Pagamento> pagamentos = em.createQuery("select p from Pagamento p", Pagamento.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return pagamentos;
    }

    public Pagamento buscaPagamentoPorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Pagamento pagamento = em.find(Pagamento.class, id);
        em.getTransaction().commit();
        em.close();
        return pagamento;
    }

    public void excluirPagamento(Pagamento pagamento) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.remove(pagamento);
        em.getTransaction().commit();
        em.close();

    }

    public void atualizarPagamento(Long id, Pagamento pagamento) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Pagamento pagamentoAtual = em.find(Pagamento.class, id);
        if (pagamentoAtual != null) {
            pagamentoAtual.setFormaPagamento(pagamento.getFormaPagamento());
            pagamentoAtual.setValorPago(pagamento.getValorPago());
            pagamentoAtual.setVenda_id(pagamento.getVenda_id());
            em.merge(pagamento);
        } else {
            System.out.println("Pagamento não encontrado");
        }
        em.getTransaction().commit();
        System.out.println("Pagamento atualizado com sucesso");
        em.close();

    }
}
