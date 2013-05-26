package br.com.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idProduto;
    private String nomeProd;
    private String categProd;
    private double precoProd;
    private int qtd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getCategProd() {
        return categProd;
    }

    public void setCategProd(String categProd) {
        this.categProd = categProd;
    }

    public double getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(double precoProd) {
        this.precoProd = precoProd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nomeProd);
        hash = 41 * hash + Objects.hashCode(this.categProd);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.precoProd) ^ (Double.doubleToLongBits(this.precoProd) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estoque other = (Estoque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nomeProd, other.nomeProd)) {
            return false;
        }
        if (!Objects.equals(this.categProd, other.categProd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoProd) != Double.doubleToLongBits(other.precoProd)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProd=" + nomeProd + ", categProd=" + categProd + ", precoProd=" + precoProd+'}';
    }

    
    
 

    
    
}
