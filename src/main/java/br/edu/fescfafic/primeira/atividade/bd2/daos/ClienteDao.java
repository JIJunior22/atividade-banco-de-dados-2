package br.edu.fescfafic.primeira.atividade.bd2.daos;

import br.edu.fescfafic.primeira.atividade.bd2.entities.Cliente;
import br.edu.fescfafic.primeira.atividade.bd2.entities.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDao {

    public Cliente cadastroCliente(Cliente cliente) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        return cliente;
    }

    public List<Cliente> listaClientes() {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return clientes;
    }

    public Cliente buscaClientePorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.getTransaction().commit();
        em.close();
        return cliente;
    }

    public void excluirCliente(Cliente cliente) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();

    }

    public void atualizarCliente(Long id, Cliente cliente) {
        EntityManager em = JpaUtil.entityManager();
        em.getTransaction().begin();
        Cliente clienteAtual = em.find(Cliente.class, id);
        if (clienteAtual != null) {
            clienteAtual.setNome(cliente.getNome());
            clienteAtual.setEmail(cliente.getEmail());
            clienteAtual.setEndereco(cliente.getEndereco());
            em.merge(clienteAtual);
        } else {
            System.out.println("Cliente não encontrado");
        }
        em.getTransaction().commit();
        System.out.println("Cliente atualizado com sucesso: " + cliente.getNome());
        em.close();

    }
}
