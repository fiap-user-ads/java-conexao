package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.conections.ConectionFactory;

public class TesteConection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection c = new ConectionFactory().conection();
		
		System.out.println("Conectrado com o Banco de Dados");
		c.close();
	}
}
