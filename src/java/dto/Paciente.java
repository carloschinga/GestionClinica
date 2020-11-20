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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByCodiPaci", query = "SELECT p FROM Paciente p WHERE p.codiPaci = :codiPaci")
    , @NamedQuery(name = "Paciente.findByAppaPaci", query = "SELECT p FROM Paciente p WHERE p.appaPaci = :appaPaci")
    , @NamedQuery(name = "Paciente.findByApmaPaci", query = "SELECT p FROM Paciente p WHERE p.apmaPaci = :apmaPaci")
    , @NamedQuery(name = "Paciente.findByNombPaci", query = "SELECT p FROM Paciente p WHERE p.nombPaci = :nombPaci")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codi_paci")
    private String codiPaci;
    @Basic(optional = false)
    @Column(name = "appa_paci")
    private String appaPaci;
    @Basic(optional = false)
    @Column(name = "apma_paci")
    private String apmaPaci;
    @Basic(optional = false)
    @Column(name = "nomb_paci")
    private String nombPaci;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteCodiPaci")
    private List<Cita> citaList;

    public Paciente() {
    }

    public Paciente(String codiPaci) {
        this.codiPaci = codiPaci;
    }

    public Paciente(String codiPaci, String appaPaci, String apmaPaci, String nombPaci) {
        this.codiPaci = codiPaci;
        this.appaPaci = appaPaci;
        this.apmaPaci = apmaPaci;
        this.nombPaci = nombPaci;
    }

    public String getCodiPaci() {
        return codiPaci;
    }

    public void setCodiPaci(String codiPaci) {
        this.codiPaci = codiPaci;
    }

    public String getAppaPaci() {
        return appaPaci;
    }

    public void setAppaPaci(String appaPaci) {
        this.appaPaci = appaPaci;
    }

    public String getApmaPaci() {
        return apmaPaci;
    }

    public void setApmaPaci(String apmaPaci) {
        this.apmaPaci = apmaPaci;
    }

    public String getNombPaci() {
        return nombPaci;
    }

    public void setNombPaci(String nombPaci) {
        this.nombPaci = nombPaci;
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
        hash += (codiPaci != null ? codiPaci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.codiPaci == null && other.codiPaci != null) || (this.codiPaci != null && !this.codiPaci.equals(other.codiPaci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Paciente[ codiPaci=" + codiPaci + " ]";
    }
    
}
