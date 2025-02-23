package br.edu.fescfafic.primeira.atividade.bd2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;


}
