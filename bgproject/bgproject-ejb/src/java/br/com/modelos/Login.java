package br.com.modelos;

public class Login {

    
    private String email;    
    private String senha;

    protected Login() {
    }

    public Login(String email) {
        this.email = email;
    }
    
    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ email=" + email + " ]" + "[ senha= " + senha + " ]";
    }
}
