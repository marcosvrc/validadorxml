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

}
