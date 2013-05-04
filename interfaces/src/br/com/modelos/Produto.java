package br.com.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeProd;
    private String categProd;
    private double precoProd;
    private String descProd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nomeProd);
        hash = 71 * hash + Objects.hashCode(this.categProd);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.precoProd) ^ (Double.doubleToLongBits(this.precoProd) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.descProd);
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
        final Produto other = (Produto) obj;
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
        if (!Objects.equals(this.descProd, other.descProd)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProd=" + nomeProd + ", categProd=" + categProd + ", precoProd=" + precoProd + ", descProd=" + descProd + '}';
    }

    
    
 

    
    
}
