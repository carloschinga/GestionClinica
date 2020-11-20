/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Chinga
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodiUsua", query = "SELECT u FROM Usuario u WHERE u.codiUsua = :codiUsua")
    , @NamedQuery(name = "Usuario.findByNombUsua", query = "SELECT u FROM Usuario u WHERE u.nombUsua = :nombUsua")
    , @NamedQuery(name = "Usuario.findByLogiUsua", query = "SELECT u FROM Usuario u WHERE u.logiUsua = :logiUsua")
    , @NamedQuery(name = "Usuario.findByPassUsua", query = "SELECT u FROM Usuario u WHERE u.passUsua = :passUsua")
    , @NamedQuery(name = "Usuario.findByTipoUsua", query = "SELECT u FROM Usuario u WHERE u.tipoUsua = :tipoUsua")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codi_usua")
    private String codiUsua;
    @Basic(optional = false)
    @Column(name = "nomb_usua")
    private String nombUsua;
    @Basic(optional = false)
    @Column(name = "logi_usua")
    private String logiUsua;
    @Basic(optional = false)
    @Column(name = "pass_usua")
    private String passUsua;
    @Basic(optional = false)
    @Column(name = "tipo_usua")
    private int tipoUsua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioCodiUsua")
    private List<Cita> citaList;

    public Usuario() {
    }

    public Usuario(String codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Usuario(String codiUsua, String nombUsua, String logiUsua, String passUsua, int tipoUsua) {
        this.codiUsua = codiUsua;
        this.nombUsua = nombUsua;
        this.logiUsua = logiUsua;
        this.passUsua = passUsua;
        this.tipoUsua = tipoUsua;
    }

    public String getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(String codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getNombUsua() {
        return nombUsua;
    }

    public void setNombUsua(String nombUsua) {
        this.nombUsua = nombUsua;
    }

    public String getLogiUsua() {
        return logiUsua;
    }

    public void setLogiUsua(String logiUsua) {
        this.logiUsua = logiUsua;
    }

    public String getPassUsua() {
        return passUsua;
    }

    public void setPassUsua(String passUsua) {
        this.passUsua = passUsua;
    }

    public int getTipoUsua() {
        return tipoUsua;
    }

    public void setTipoUsua(int tipoUsua) {
        this.tipoUsua = tipoUsua;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Usuario[ codiUsua=" + codiUsua + " ]";
    }
    
}
