package com.remedios.lucas.remedio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Remedio")
@Entity(name = "Remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    public Remedio(DadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private  boolean ativo;

    public void atualizarInformacoes(DadosAtualizarRemedio dados) {
        if(dados.nome() != null)
            this.nome = dados.nome();
        if(dados.via() != null)
            this.via = dados.via();
        if(dados.laboratorio() != null)
            this.laboratorio = dados.laboratorio();
    }

    public void inativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
