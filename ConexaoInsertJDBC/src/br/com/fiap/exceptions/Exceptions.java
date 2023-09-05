package br.com.fiap.exceptions;

public class Exceptions extends Exception{
	public Exceptions() {
		super();
	}
	
	public Exceptions(Exception e) {
		super();
		
		if(e.getClass().toString().equals("class java.lang.NumberFormatException")) {
			System.out.println("Erro. Digitou letra ao invés de número");
		}
	}
}
