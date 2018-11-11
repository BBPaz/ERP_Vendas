/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author igors
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecta {

    /**
     * Devolve a conexï¿½o com o banco de dados
     *
     * @return
     */
    public static Connection getConexao() throws Exception {

        Connection con = null;
        //Configura servidor de Banco de Dados e nome do Banco
        String serverName = "localhost:3306";
        String mydatabase = "erp_vendas";

        //Login e senha do banco
        String username = "root";
        String password = "root";

        //Carregando o JDBC Driver
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);

        // Criando a conexï¿½o com o Banco de Dados
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC"; // a JDBC url
        con = DriverManager.getConnection(url, username, password);

        return con;
    }
}
