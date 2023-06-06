package br.com.validacaoxml.util;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXParseException;

import br.com.validacaoxml.exeception.InfraExecption;
/**
 * Classe Util.
 * @author Marcos
 *
 */
public class Util {

	public static String obterMsgFormatada(SAXParseException se) {
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
	
	public static void exibirDialogoErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem,"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void exibirDialogoSucesso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem,"Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void validarArgumentos(String[] args) throws InfraExecption {
		
		if(args == null || args.length == 0) {
			throw new InfraExecption("Argumentos sao obrigatorios. Primeiro argumento caminho xml e segundo argumento caminho do xsd");	
			
		}else if(StringUtils.isNotBlank(args[0]) && StringUtils.isBlank(args[1])) {
			throw new InfraExecption("O caminho do xsd deve ser informado!");
			
		}else if(StringUtils.isBlank(args[0]) && StringUtils.isNotBlank(args[1])) {
			throw new InfraExecption("O caminho do xml deve ser informado!");
		}
	}

}
