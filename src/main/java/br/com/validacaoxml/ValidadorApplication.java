package br.com.validacaoxml;

import java.io.File;

import org.xml.sax.SAXParseException;

import br.com.validacaoxml.exeception.InfraExecption;
import br.com.validacaoxml.util.Util;
import br.com.validacaoxml.validacao.ValidacaoXML;

public class ValidadorApplication {

	public static void main(String[] args) {

		ValidacaoXML validacao = new ValidacaoXML();
		try {
			//validarArgumentos(args);
			
			//String caminhoxml = args[0];
			//String caminhoxsd = args[1];
			
			File arquivoXml = new File("shiporder_sem_erro.xml");
			File arquivoXsd = new File("shiporder.xsd");
			
			validacao.valida(arquivoXml, arquivoXsd);
			
			Util.exibirDialogoSucesso("XML validado com sucesso!");
		} catch (InfraExecption ie) {
			Util.exibirDialogoErro(ie.getMessage());
		} catch (SAXParseException se) {
			Util.exibirDialogoErro(Util.obterMsgFormatada(se));
		} catch (Exception ex) {
			Util.exibirDialogoErro(ex.getMessage());
		}
	}	
}
