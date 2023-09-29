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
	
	public void adicionar (Produto produto) throws SQLException {
		var sql = "INSERT INTO T_FIAP_PRODUTO VALUES (?,?,?,?,?)";
		
		PreparedStatement stmt = minhaConection.prepareStatement(sql);
		
		stmt.setInt(1, produto.getCodigo());
		stmt.setString(2, produto.getTipo());
		stmt.setString(3, produto.getMarca());
		stmt.setDouble(4, produto.getValorVenda());
		stmt.setDouble(5, produto.getValorCompra());
		stmt.execute();
		stmt.close();
	}
	
	public void atualizar (Produto produto) throws SQLException {
		var sql = "UPDATE T_FIAP_PRODUTO SET tipo = ?, marca = ?, valor_venda = ?, valor_compra = ? WHERE codigo = ?";
		
		PreparedStatement stmt = minhaConection.prepareStatement(sql);
		
		stmt.setString(1, produto.getTipo());
		stmt.setString(2, produto.getMarca());
		stmt.setDouble(3, produto.getValorVenda());
		stmt.setDouble(4, produto.getValorCompra());
		stmt.setInt(5, produto.getCodigo());
		stmt.execute();
		stmt.close();
	}
	
	public void deletar (int codigo) throws SQLException {
		var sql = "DELETE FROM T_FIAP_PRODUTO WHERE codigo = ?";
		
		PreparedStatement stmt = minhaConection.prepareStatement(sql);
		
		stmt.setInt(1, codigo);
		stmt.execute();
		stmt.close();
	}
	
	public List<Produto> buscar () throws SQLException {
		var listaProdutos = new ArrayList<Produto>();
		var sql = "SELECT * FROM T_FIAP_PRODUTO";
		
		PreparedStatement stmt = minhaConection.prepareStatement(sql);
		
		try (var resultList = stmt.executeQuery()){
			while (resultList.next()) {
				var produto = new Produto();
				produto.setCodigo(resultList.getInt("CODIGO"));
				produto.setTipo(resultList.getString("TIPO"));
				produto.setMarca(resultList.getString("MARCAR"));
				produto.setValorVenda(resultList.getDouble("VALOR_VENDA"));
				produto.setValorCompra(resultList.getDouble("VALOR_COMPRA"));
				
				listaProdutos.add(produto);
			}
		}
		
		return listaProdutos;
	}
}
