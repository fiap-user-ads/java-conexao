package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Produto;
import br.com.fiap.dao.ProdutoDAO;

public class TesteCadastro {
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	static double decimal(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto objProduto = new Produto();
		
		objProduto.setCodigo(inteiro("Código"));
		objProduto.setTipo(texto("Tipo"));
		objProduto.setMarca(texto("Marca"));
		objProduto.setValorVenda(decimal("Valor de Venda"));
		objProduto.setValorCompra(decimal("Valor de Compra"));
		
		System.out.println(dao.inserir(objProduto));
	}
}
