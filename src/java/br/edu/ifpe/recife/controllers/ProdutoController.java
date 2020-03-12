/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Produto;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ALUNO
 */
@ManagedBean
@SessionScoped
public class ProdutoController {

    private Produto cadastro;
    private Produto selected;

    @PostConstruct
    public void init() {
        this.cadastro = new Produto();
    }

    public String inserir() {

        if (cadastro.getNome().contains("select") || cadastro.getNome().contains("delete")) {
            FacesContext.getCurrentInstance().addMessage("formCadProduto:txtNome",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!!!", "Você "
                            + "tentou cadastrar um valor irregular!"));
            return null;
        }

        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Produto();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("O produto foi cadastrado com sucesso!"));
        return "index.xhtml";

    }

    public void alterar() {
        ManagerDao.getCurrentInstance().update(this.selected);
    }

    public List<Produto> recuperarTodos() {
        return ManagerDao.getCurrentInstance().read("select p from Produto p", Produto.class);
    }

    public void delete() {
        ManagerDao.getCurrentInstance().delete(this.selected);
    }

    public Produto getCadastro() {
        return cadastro;
    }

    public void setCadastro(Produto cadastro) {
        this.cadastro = cadastro;
    }

    public Produto getSelected() {
        return selected;
    }

    public void setSelected(Produto selected) {
        this.selected = selected;
    }

}
