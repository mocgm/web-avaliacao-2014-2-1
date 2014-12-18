/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inscricao.faces.mngbeans;

import inscricao.entity.LoginStruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author a1047809
 */
@Named
@ApplicationScoped
public class AppBean {
    HashMap<String, Date> dados = new HashMap<String, Date>();
    private ArrayList<LoginStruct> arrLogin = new ArrayList<LoginStruct>();
    
    public void addDados(LoginStruct loginStruct) {
        arrLogin.add(loginStruct);
    }
    
    public ArrayList<LoginStruct> getList() {
        return arrLogin;
    }
}
