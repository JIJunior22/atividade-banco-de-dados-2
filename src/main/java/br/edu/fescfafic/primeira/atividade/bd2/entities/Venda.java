package br.edu.fescfafic.primeira.atividade.bd2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente_id;
    private String dataVenda;
    @ManyToMany
    private List<Produto> produtos;
    private Double total;

}
