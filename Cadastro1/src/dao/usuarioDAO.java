/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.connectionFactory;
import modelo.usuario;
import java.sql.*;
import java.sql.PreparedStatement;


/**
 *
 * @author Renata
 */
//CRUD (Create, Retrieve, Update, Delete - Criar, Consultar, Alterar, deletar)
public class usuarioDAO {
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public usuarioDAO(){
       this.connection = new connectionFactory().getConnection();
    }

    public void adiciona(usuario usuario){

        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        try {

           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, usuario.getNome());
           stmt.setString(2, usuario.getCpf());
           stmt.setString(3, usuario.getEmail());
           stmt.setString(4, usuario.getTelefone());
           stmt.execute();
           stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}

