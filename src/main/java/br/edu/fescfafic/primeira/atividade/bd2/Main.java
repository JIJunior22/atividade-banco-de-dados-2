package br.edu.fescfafic.primeira.atividade.bd2;

import br.edu.fescfafic.primeira.atividade.bd2.daos.ClienteDao;
import br.edu.fescfafic.primeira.atividade.bd2.daos.PagamentoDao;
import br.edu.fescfafic.primeira.atividade.bd2.daos.ProdutoDao;
import br.edu.fescfafic.primeira.atividade.bd2.daos.VendaDao;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Cliente;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Pagamento;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Produto;
import br.edu.fescfafic.primeira.atividade.bd2.entities.Venda;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ==========CLIENTE===========
        Cliente cliente = new Cliente();
        cliente.setNome("Luke");
        cliente.setEmail("luke@email.com");
        cliente.setEndereco("Rua do Luke");
//
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.cadastroCliente(cliente);
        clienteDao.listaClientes();
//        ==========FIM CLIENTE===========


//        ==========PRODUTO===========
        Produto produto = new Produto();
        produto.setDescricao("Computador");
        produto.setPreco(200.0);
        produto.setDescricao("Computador completo");

        ProdutoDao produtoDao = new ProdutoDao();
        List<Produto> totalProdutos = new ArrayList<>(List.of());
        totalProdutos.add(produto);
        double totalPago = 0.0;
        for (Produto p : totalProdutos) {
            totalPago += p.getPreco();
        }

        //produtoDao.salvarProduto(produto);
        produtoDao.listarProdutos();
//        ==========FIM PRODUTO===========

//        ==========VENDA===========
        Venda venda = new Venda();
        venda.setDataVenda("21/02/2025");
        venda.setProdutos(List.of(produto));
        venda.setCliente_id(cliente);
        venda.setTotal(totalPago);

        VendaDao vendaDao=new VendaDao();
        vendaDao.cadastroVenda(venda);
        vendaDao.listaVendas();
//        ==========FIM VENDA===========


//        ==========PAGAMENTO===========
        Pagamento pagamento = new Pagamento();

        pagamento.setVenda_id(venda);
        pagamento.setStatus(false);
        if (pagamento.isStatus()) {
            System.out.println("Pago!");
        } else {
            System.out.println("Pendente");
        }
        pagamento.setFormaPagamento("Pix");
        pagamento.setValorPago(200.0);

        PagamentoDao pagamentoDao=new PagamentoDao();
        pagamentoDao.cadastroPagamento(pagamento);
        pagamentoDao.listaPagamentos();

//        ==========FIM PAGAMENTO===========

    }
}