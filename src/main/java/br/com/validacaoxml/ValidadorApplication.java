package br.com.validacaoxml;

import java.io.File;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXParseException;

import br.com.validacaoxml.exeception.InfraExecption;
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
			JOptionPane.showMessageDialog(null, "XML validado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (InfraExecption ie) {
			JOptionPane.showMessageDialog(null, ie.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SAXParseException se) {
			JOptionPane.showMessageDialog(null, obterMsgFormatada(se),"Erro", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.out.println("Erro: " + ex.getMessage());
		}
	}

	private static void validarArgumentos(String[] args) throws InfraExecption {
		
		if(args.length == 0) {
			throw new InfraExecption("Argumentos sao obrigatorios. Primeiro argumento caminho xml e segundo argumento caminho do xsd");	
			
		}else if(StringUtils.isNotBlank(args[0]) && StringUtils.isBlank(args[1])) {
			throw new InfraExecption("O caminho do xsd deve ser informado!");
			
		}else if(StringUtils.isBlank(args[0]) && StringUtils.isNotBlank(args[1])) {
			throw new InfraExecption("O caminho do xml deve ser informado!");
		}
	}
	
	private static String obterMsgFormatada(SAXParseException se) {
		StringBuilder msgFormatada = new StringBuilder();
		msgFormatada.append("Linha do erro: ");
		msgFormatada.append(se.getLineNumber());
		msgFormatada.append("\n");
		msgFormatada.append("Coluna do erro: ");
		msgFormatada.append(se.getColumnNumber());
		msgFormatada.append("\n");
		msgFormatada.append("Erro: ");
		msgFormatada.append(se.getMessage());
		return msgFormatada.toString();
	}
	
}
