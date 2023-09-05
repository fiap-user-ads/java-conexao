package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Produto;
import br.com.fiap.exceptions.Exceptions;

public class TesteProduto {
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	static double decimal(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws Exception{
		Produto objPorduto = new Produto();
		
		try {
			objPorduto.setCodigo(inteiro("Código"));
			objPorduto.setTipo(texto("Código"));
			objPorduto.setMarca(texto("Código"));
			objPorduto.setValorVenda(decimal("Código"));
			objPorduto.setValorCompra(decimal("Código"));
		} catch (Exception e) {
			throw new Exceptions(e);
		} finally {
			
		}
		
		System.out.println("Código: " + objPorduto.getCodigo());
	}
}
