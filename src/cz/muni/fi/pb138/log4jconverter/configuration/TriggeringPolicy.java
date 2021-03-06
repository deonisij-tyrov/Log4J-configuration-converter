package cz.muni.fi.pb138.log4jconverter.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class represents the TriggeringPolicy configuration from Abstract Model 
 * Each field represent every single component of Log4j triggeringPolicy  configuration
 * 
 * @author Steve
 */
public class TriggeringPolicy {
    //required

    private String name;
    private String className;
    //optional 
    // moze byt bud params alebo filters nemozu byt oba naraz cize v parseroch bude treba urobit nejaku podmienku
    private HashMap<String, String> params;
    private HashSet<Filter> filters;

    public TriggeringPolicy() {

        this.params = new LinkedHashMap<String, String>();
        this.filters = new LinkedHashSet<Filter>();
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public void addParam(String key, String value) {
        params.put(key, value);
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

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void generateXML(Document doc, Element appender) {
        Element triggPolicy = doc.createElement("triggeringPolicy");
        triggPolicy.setAttribute("name", name);
        triggPolicy.setAttribute("class", className);

        if (!params.isEmpty()) {
            Iterator<Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
            	Entry<String, String> e = it.next();
                Element param = doc.createElement("param");

                param.setAttribute("name", e.getKey());
                param.setAttribute("value", e.getValue());
                triggPolicy.appendChild(param);

            }

        } else {
            for (Filter filter : filters) {
                filter.generateXML(doc, triggPolicy);
            }
        }

        appender.appendChild(triggPolicy);
    }
}
