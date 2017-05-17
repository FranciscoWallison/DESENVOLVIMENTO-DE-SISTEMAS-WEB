package br.estacio.model;

public class Usuario {

    private String nome;
    private String login;
    private String senha;
    
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;                
        this.senha =  senha;
    }
    
    public Usuario(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
        
}
