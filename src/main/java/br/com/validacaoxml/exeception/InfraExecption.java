package br.com.validacaoxml.exeception;

public class InfraExecption extends Exception{
	
	/**
     * importante caso a exceção seja serializada
     */
    private static final long serialVersionUID = 1149241039409861914L;

    public InfraExecption(String msg){
        super(msg);
    }

    public InfraExecption(String msg, Throwable cause){
        super(msg, cause);
    }

}
