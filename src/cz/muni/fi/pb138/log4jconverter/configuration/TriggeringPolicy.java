/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.log4jconverter.configuration;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Admin
 */
public class TriggeringPolicy {
    //required
    private String name;
    private String className;
    //optional 
    // moze byt bud params alebo filters nemozu byt oba naraz cize v parseroch bude treba urobit nejaku podmienku
    private HashMap<String,String> params;
    private HashSet<Filter> filters;

    public TriggeringPolicy(String name, String className) {
        this.name = name;
        this.className = className;
        this.params = new HashMap<String, String>();
        this.filters = new HashSet<Filter>();
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }
    
    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
    

    public HashSet<Filter> getFilters() {
        return filters;
    }

    public void setFilters(HashSet<Filter> filters) {
        this.filters = filters;
    }
    
    
    
}
