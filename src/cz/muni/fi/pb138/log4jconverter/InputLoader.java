/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.log4jconverter;

import java.io.*;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * This class represents basic operations for loading
 * files. 
 * 
 * @author fivekeyem
 */
public class InputLoader {
    
    
    public enum Type {
        XML, PROPERTIES, OTHER
    }
    
    private Document xmlDoc = null;
    private Properties propertiesDoc = null;
    
    private String nameOfFile;
    private InputStream is;
    
    
    public InputLoader(InputStream is) {
        this.is = is;
    }
    
    public InputLoader(String nameOfFile) {
        if (nameOfFile == null) {
            throw new NullPointerException("No name of file");
        }
        if (nameOfFile.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }  
        this.nameOfFile = nameOfFile;
        try {            
            this.is = new FileInputStream(new File(nameOfFile));       
        } catch (FileNotFoundException ex) {
            System.out.println("File doesnt exist");
        }
    }
    
    
    // for now we recognize typ of input according to extension of file
    // in the future we'll do it according content
    public Type getType() {
        String extension = FilenameUtils.getExtension(nameOfFile);
        if (extension.equals("xml")) {
            return Type.XML;
        } else if (extension.equals("properties")) {
            return Type.PROPERTIES;
        }
        return Type.OTHER;
    }
    
    
    public Document getDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        xmlDoc = builder.parse(this.is);
        return xmlDoc;
    }
    
    
    public Properties getProperties() throws IOException {
        Properties p = new Properties();
        p.load(this.is);
        return p;
    }
    
}
