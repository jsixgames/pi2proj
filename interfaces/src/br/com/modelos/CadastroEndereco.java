
package br.com.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bonato
 */
@Entity
@Table(name = "cadastroEndereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadastroEndereco.findAll", query = "SELECT c FROM CadastroEndereco c"),
    @NamedQuery(name = "CadastroEndereco.findByIdEndereco", query = "SELECT c FROM CadastroEndereco c WHERE c.idEndereco = :idEndereco"),
    @NamedQuery(name = "CadastroEndereco.findByEmail", query = "SELECT c FROM CadastroEndereco c WHERE c.email = :email"),
    @NamedQuery(name = "CadastroEndereco.findByDescricaoEndereco", query = "SELECT c FROM CadastroEndereco c WHERE c.descricaoEndereco = :descricaoEndereco"),
    @NamedQuery(name = "CadastroEndereco.findByCep", query = "SELECT c FROM CadastroEndereco c WHERE c.cep = :cep"),
    @NamedQuery(name = "CadastroEndereco.findByEndereco", query = "SELECT c FROM CadastroEndereco c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "CadastroEndereco.findByNumero", query = "SELECT c FROM CadastroEndereco c WHERE c.numero = :numero"),
    @NamedQuery(name = "CadastroEndereco.findByComplemento", query = "SELECT c FROM CadastroEndereco c WHERE c.complemento = :complemento"),
    @NamedQuery(name = "CadastroEndereco.findByBairro", query = "SELECT c FROM CadastroEndereco c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "CadastroEndereco.findByCidade", query = "SELECT c FROM CadastroEndereco c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "CadastroEndereco.findByEstado", query = "SELECT c FROM CadastroEndereco c WHERE c.estado = :estado")})
public class CadastroEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "DESCRICAO_ENDERECO")
    private String descricaoEndereco;
    @Basic(optional = false)
    @Column(name = "CEP")
    private String cep;
    @Basic(optional = false)
    @Column(name = "ENDERECO")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;

    public CadastroEndereco() {
    }

    public CadastroEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public CadastroEndereco(String email, String descricaoEndereco, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado) {
        this.email = email;
        this.descricaoEndereco = descricaoEndereco;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoEndereco() {
        return descricaoEndereco;
    }

    public void setDescricaoEndereco(String descricaoEndereco) {
        this.descricaoEndereco = descricaoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadastroEndereco)) {
            return false;
        }
        CadastroEndereco other = (CadastroEndereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.modelos.CadastroEndereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
