package br.com.validacaoxml;

import br.com.validacaoxml.validacao.ValidacaoXML;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.xml.sax.SAXParseException;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ValidadorApplicationTest{


	@Test
	@DisplayName("Validar XML válido")
	public void validarXmlValidoTest() throws Exception {
		ValidacaoXML validacao = new ValidacaoXML();
		validacao.valida(new File("shiporder_sem_erro.xml"), new File("shiporder.xsd"));
	}
	
	@Test()
	@DisplayName("Validar XML inválido")
	public void validarXmlInvalidoTest()  {

		SAXParseException saxParseException = assertThrows(SAXParseException.class, () -> {
			ValidacaoXML validacao = new ValidacaoXML();
			validacao.valida(new File("shiporder_com_erro.xml"), new File("shiporder.xsd"));
		});

	}

}
