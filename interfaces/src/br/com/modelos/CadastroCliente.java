package br.com.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class CadastroCliente implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String nome;   
    private String cpf;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnasc;
    private String sexo;    
    private String telefone;
    private String celular;
    private String senha;      
    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private CadastroEndereco endereco;

    public CadastroCliente() {
    }

    public CadastroCliente(String email) {
        this.email = email;
    }
    
    public CadastroCliente(String nome, String cpf, Date dnasc, String sexo, String telefone, String celular, String email, String senha, CadastroEndereco endereco) {
        this.nome = nome;        
        this.cpf = cpf;
        this.dnasc = dnasc;
        this.sexo = sexo;        
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CadastroEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(CadastroEndereco endereco) {
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDnasc() {
        return dnasc;
    }

    public void setDnasc(Date dnasc) {
        this.dnasc = dnasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadastroCliente)) {
            return false;
        }
        CadastroCliente other = (CadastroCliente) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario cadastrado: [ email=" + email + " ]" + "[ senha= " + senha + " ]";
    }
}
