/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.log4jconverter.configuration;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class ConnectionSource {
    //required
    private String className;
    
    //optional
    private HashMap<String,String> params;

    public ConnectionSource(String className) {
        this.className = className;
        this.params = new HashMap<String, String>();
    }

    public String getClassName() {
        return className;
    }
    
    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
    
    
    
    
}
