/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inscricao.faces.mngbeans;

import inscricao.entity.LoginStruct;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author a1047809
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String usuario;
    private String senha;
    private boolean administrador;
    private LoginStruct loginStruct = new LoginStruct();
    private String textoAdmin = "Usuário";
    
    @Inject
    AppBean appBean;
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getTextoAdmin() {
        return textoAdmin;
    }

    public void setTextoAdmin(String textoAdmin) {
        this.textoAdmin = textoAdmin;
    }        
    
    public String loginAction() {
        String ret = null;
        if (!(usuario.equals(senha))) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Senha inválida!"));   
            ret = "login.xhtml"; //permanece na mesma pagina
        }
        else {
            //obtem data atual
            Date date = new Date();
            
            //adiciona a estrutura de dados
            loginStruct.setNome(usuario);
            loginStruct.setData(date);
            appBean.addDados(loginStruct);
            
            if (administrador) 
            {
                ret = "admin.xhtml";
                textoAdmin = usuario + " [administrador]";
            }
            else {
                ret = "cadastro.xhtml";
                
            }
                        
        }
        return ret;
    }
}
