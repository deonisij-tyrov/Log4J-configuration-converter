package cz.muni.fi.pb138.log4jconverter.configuration;

import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

public class Configuration implements AbstractModel {
    
    public enum Tresholds{
        all,trace,debug,info,warn,error,fatal,off,
    }
    
    private Tresholds treshold = null;
    private Boolean debug = null;
    private boolean reset = false;
    
    private Root root;
    private HashSet<Renderer> renderers;
    private ThrowableRender throwableRenderer;
    private HashMap<String, Appender> appenders;
    private HashMap<String, Logger> loggers;
    private HashMap<String, Plugin> plugins;
    private LoggerFactory logFactory;
    

    public Configuration() {
        renderers = new HashSet<Renderer>();
        appenders = new HashMap<String, Appender>();
        loggers = new HashMap<String, Logger>();
    }

    /* returns Appender by its name, if it does'n exists,
	 * creates new one.
     */
    public Appender getAppender(String name) { 
        if (!appenders.containsKey(name)) {
            appenders.put(name, new Appender(name));
        }
        return appenders.get(name);
    }

    /* returns Logger by its name, if it does'n exists,
	 * creates new one.
     */
    public Logger getLogger(String name) { 
        if (!loggers.containsKey(name)) {
        	loggers.put(name, new Logger(name));
        }
        return loggers.get(name);
    }
    
    /*
     * It's used in tests
     * default visibility is OK for tests
     */
    boolean isAppender(String name) {
        if (appenders.containsKey(name)) {
            return true;
        }
        return false;
    }

    public HashMap<String, Appender> getAppenders() {
        return appenders;
    }

    public void setAppenders(HashMap<String, Appender> appenders) {
        this.appenders = appenders;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public LoggerFactory getLogFactory() {
        return logFactory;
    }

    public void setLogFactory(LoggerFactory logFactory) {
        this.logFactory = logFactory;
    }

    public HashMap<String, Logger> getLoggers() {
        return loggers;
    }

    public void setLoggers(HashMap<String, Logger> loggers) {
        this.loggers = loggers;
    }

    public HashMap<String, Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(HashMap<String, Plugin> plugins) {
        this.plugins = plugins;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public Tresholds getTreshold() {
        return treshold;
    }

    public void setTreshold(Tresholds treshold) {
        this.treshold = treshold;
    }

    public HashSet<Renderer> getRenderers() {
        return renderers;
    }

    public void setRenderers(HashSet<Renderer> renderers) {
        this.renderers = renderers;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public ThrowableRender getThrowableRenderer() {
        return throwableRenderer;
    }

    public void setThrowableRenderer(ThrowableRender throwableRenderer) {
        this.throwableRenderer = throwableRenderer;
    }
    
    public void addRenderer(Renderer r) {
        renderers.add(r);
    }
    
    public void addAppender(Appender a) {
        appenders.put(a.getAppenderName(), a);
    }

    @Override
    public void printXML(Writer w) {
        // TODO Auto-generated method stub
    }

    @Override
    public void printProperties(Writer w) {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return root.toString();
    }

}
