package cz.muni.fi.pb138.log4jconverter.configuration;

import java.io.Writer;

public interface AbstractModel {

	void printXML(Writer w);
	
	void printProperties(Writer w);
}