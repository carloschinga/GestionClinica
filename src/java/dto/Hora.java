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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "hora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hora.findAll", query = "SELECT h FROM Hora h")
    , @NamedQuery(name = "Hora.findByCodiHora", query = "SELECT h FROM Hora h WHERE h.codiHora = :codiHora")
    , @NamedQuery(name = "Hora.findByNombHora", query = "SELECT h FROM Hora h WHERE h.nombHora = :nombHora")})
public class Hora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_hora")
    private Integer codiHora;
    @Column(name = "nomb_hora")
    private String nombHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horaCodiHora")
    private List<Detalle> detalleList;

    public Hora() {
    }

    public Hora(Integer codiHora) {
        this.codiHora = codiHora;
    }

    public Integer getCodiHora() {
        return codiHora;
    }

    public void setCodiHora(Integer codiHora) {
        this.codiHora = codiHora;
    }

    public String getNombHora() {
        return nombHora;
    }

    public void setNombHora(String nombHora) {
        this.nombHora = nombHora;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiHora != null ? codiHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hora)) {
            return false;
        }
        Hora other = (Hora) object;
        if ((this.codiHora == null && other.codiHora != null) || (this.codiHora != null && !this.codiHora.equals(other.codiHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Hora[ codiHora=" + codiHora + " ]";
    }
    
}
