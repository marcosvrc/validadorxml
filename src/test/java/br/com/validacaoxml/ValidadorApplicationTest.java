package br.com.validacaoxml;

import java.io.File;

import org.junit.Test;
import org.xml.sax.SAXParseException;

import br.com.validacaoxml.validacao.ValidacaoXML;


public class ValidadorApplicationTest{

	@Test
	public void validarXmlValidoTest() throws Exception {
		ValidacaoXML validacao = new ValidacaoXML();
		validacao.valida(new File("shiporder_sem_erro.xml"), new File("shiporder.xsd"));
	}
	
	@Test(expected=SAXParseException.class)
	public void validarXmlInvalidoTest() throws Exception {
		ValidacaoXML validacao = new ValidacaoXML();
		validacao.valida(new File("shiporder_com_erro.xml"), new File("shiporder.xsd"));
	}

}
