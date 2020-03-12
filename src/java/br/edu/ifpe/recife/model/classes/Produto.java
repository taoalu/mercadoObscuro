/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ALUNO
 */

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nome_produto", length = 60, nullable = false, unique = true)
    private String nome;
    private String marca;
    private String categoria;
    private String descricao;
    @OneToMany
    private List<Avaliacao> avaliacoes;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    private double getPontuacaoGeral(){
        double cont = 0;
        
        for(Avaliacao a: avaliacoes){
            cont += (double)a.getPontuacao();
        }
        
        return cont/avaliacoes.size();
    }
    
    private List<Avaliacao> getAvaliacoes(int quantidade){
        
        if(quantidade>=avaliacoes.size())
            return avaliacoes;
        
        return avaliacoes.subList(0, quantidade);
        
    }
    
}
