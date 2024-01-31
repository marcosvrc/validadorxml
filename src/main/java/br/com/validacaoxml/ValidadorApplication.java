package br.com.validacaoxml;

import java.io.File;

import org.xml.sax.SAXParseException;

import br.com.validacaoxml.exeception.InfraExecption;
import br.com.validacaoxml.util.Util;
import br.com.validacaoxml.validacao.ValidacaoXML;

public class ValidadorApplication {

	private static final String FILE_XSD = "shiporder.xsd";
	private static final String FILE_XML_SEM_ERROS = "shiporder_sem_erro.xml";
	private static final String FILE_XML_COM_ERROS = "shiporder_com_erro.xml";
	private static final String MSG_VALIDACAO_SUCESSO = "XML validado com sucesso!";

	public static void main(String[] args) {

		ValidacaoXML validacao = new ValidacaoXML();
		try {

			// Para usar o arquivo sem erros, basta trocar o arquivoXml
			File arquivoXml = new File(FILE_XML_SEM_ERROS);

			// Para usar o arquivo com erros, basta trocar o arquivoXml
			//File arquivoXml = new File(FILE_XML_COM_ERROS);
			File arquivoXsd = new File(FILE_XSD);
			
			validacao.valida(arquivoXml, arquivoXsd);
			
			Util.exibirDialogoSucesso(MSG_VALIDACAO_SUCESSO);
		} catch (InfraExecption ie) {
			Util.exibirDialogoErro(ie.getMessage());
		} catch (SAXParseException se) {
			Util.exibirDialogoErro(Util.obterMsgFormatada(se));
		} catch (Exception ex) {
			Util.exibirDialogoErro(ex.getMessage());
		}
	}	
}
