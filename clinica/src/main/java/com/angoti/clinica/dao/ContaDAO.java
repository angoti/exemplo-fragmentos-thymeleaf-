package com.angoti.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.angoti.clinica.config.FabricaDeConexao;
import com.angoti.clinica.dominio.Conta;

public class ContaDAO {

	public void inserir(Conta c) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "insert into conta" + "(titular,numero,agencia,limite,saldo)"
				+ " values (?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getTitular());
			stmt.setInt(2, c.getConta());
			stmt.setInt(3, c.getAgencia());
			stmt.setDouble(4, c.getLimite());
			stmt.setDouble(5, c.getSaldo());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Conta> listagem() {
		List<Conta> lista = new ArrayList<Conta>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from conta";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Conta c = new Conta(resultado.getInt("id"), resultado.getString("titular"),
						resultado.getInt("numero"), resultado.getInt("agencia"),
						resultado.getDouble("limite"), resultado.getDouble("saldo"));
				lista.add(c);
			}
			resultado.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Conta buscarPorId(int id) {
		Conta conta=null;
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from conta where id =?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			resultado.next();
			conta = new Conta(resultado.getInt("id"), resultado.getString("titular"),
						resultado.getInt("numero"), resultado.getInt("agencia"),
						resultado.getDouble("limite"), resultado.getDouble("saldo"));
			resultado.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conta;
	}
	
	public void excluir(int id) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "delete from conta where id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void atualizar(Conta c) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "update conta set titular=?,numero=?,agencia=?,limite=?,saldo=?"
				+ " where id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getTitular());
			stmt.setInt(2, c.getConta());
			stmt.setInt(3, c.getAgencia());
			stmt.setDouble(4, c.getLimite());
			stmt.setDouble(5, c.getSaldo());
			stmt.setInt(6, c.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
