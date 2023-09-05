package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.beans.Produto;
import br.com.fiap.conections.ConectionFactory;

public class ProdutoDAO {
	public Connection minhaConection;
	
	public ProdutoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConection = new ConectionFactory().conection();
	}
	
	public String inserir (Produto produto) throws SQLException {
		PreparedStatement stmt = minhaConection.prepareStatement("INSERT INTO T_FIAP_PRODUTO (?,?,?,?,?)");
		
		stmt.setInt(1, produto.getCodigo());
		stmt.setString(2, produto.getTipo());
		stmt.setString(3, produto.getMarca());
		stmt.setDouble(4, produto.getValorVenda());
		stmt.setDouble(5, produto.getValorCompra());
		stmt.execute();
		stmt.close();
		
		return "Cadastrado com sucesso!";
	}
}
