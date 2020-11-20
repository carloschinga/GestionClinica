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
 * @author DISA - UNAB
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByCodiMedi", query = "SELECT m FROM Medico m WHERE m.codiMedi = :codiMedi")
    , @NamedQuery(name = "Medico.findByAppaMedi", query = "SELECT m FROM Medico m WHERE m.appaMedi = :appaMedi")
    , @NamedQuery(name = "Medico.findByApmaMedi", query = "SELECT m FROM Medico m WHERE m.apmaMedi = :apmaMedi")
    , @NamedQuery(name = "Medico.findByNombMedi", query = "SELECT m FROM Medico m WHERE m.nombMedi = :nombMedi")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codi_medi")
    private String codiMedi;
    @Column(name = "appa_medi")
    private String appaMedi;
    @Column(name = "apma_medi")
    private String apmaMedi;
    @Column(name = "nomb_medi")
    private String nombMedi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoCodiMedi")
    private List<Cita> citaList;

    public Medico() {
    }

    public Medico(String codiMedi) {
        this.codiMedi = codiMedi;
    }

    public String getCodiMedi() {
        return codiMedi;
    }

    public void setCodiMedi(String codiMedi) {
        this.codiMedi = codiMedi;
    }

    public String getAppaMedi() {
        return appaMedi;
    }

    public void setAppaMedi(String appaMedi) {
        this.appaMedi = appaMedi;
    }

    public String getApmaMedi() {
        return apmaMedi;
    }

    public void setApmaMedi(String apmaMedi) {
        this.apmaMedi = apmaMedi;
    }

    public String getNombMedi() {
        return nombMedi;
    }

    public void setNombMedi(String nombMedi) {
        this.nombMedi = nombMedi;
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
        hash += (codiMedi != null ? codiMedi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.codiMedi == null && other.codiMedi != null) || (this.codiMedi != null && !this.codiMedi.equals(other.codiMedi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Medico[ codiMedi=" + codiMedi + " ]";
    }
    
}
