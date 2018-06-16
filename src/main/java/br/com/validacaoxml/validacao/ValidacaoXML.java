package br.com.validacaoxml.validacao;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidacaoXML {
	
	/**
	 * M�todo respons�vel por validar um xml de acordo com o xsd.
	 * @param xml
	 * @param xsd
	 * @throws Exception
	 */
	public void valida(File xml, File xsd) throws Exception{
		Source schemaFile = new StreamSource(xsd);
		Source xmlFile = new StreamSource(xml);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		validator.validate(xmlFile);
	}

}
