/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Produto;
import br.edu.ifpe.recife.model.classes.Usuario;
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
public class UsuarioController {

    private Usuario cadastro;
    private Usuario selected;

    @PostConstruct
    public void init() {
        this.cadastro = new Usuario();
    }

    public String inserir() {

        if (cadastro.getNome().contains("select") || cadastro.getNome().contains("delete")) {
            FacesContext.getCurrentInstance().addMessage("formCadUsuario:txtNome",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!!!", "Você "
                            + "tentou cadastrar um valor irregular!"));
            return null;
        }

        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("O usuário foi cadastrado com sucesso!"));
        return "ApresentaUsuarios.xhtml";

    }

    public void alterar() {
        ManagerDao.getCurrentInstance().update(this.selected);
    }

    public List<Usuario> recuperarTodos() {
        return ManagerDao.getCurrentInstance().read("select p from Usuario p", Usuario.class);
    }

    public void delete() {
        ManagerDao.getCurrentInstance().delete(this.selected);
    }

    public Usuario getCadastro() {
        return cadastro;
    }

    public void setCadastro(Usuario usuario) {
        this.cadastro = cadastro;
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

}
