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
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByCodiServ", query = "SELECT s FROM Servicio s WHERE s.codiServ = :codiServ")
    , @NamedQuery(name = "Servicio.findByNombServ", query = "SELECT s FROM Servicio s WHERE s.nombServ = :nombServ")
    , @NamedQuery(name = "Servicio.findByPrecServ", query = "SELECT s FROM Servicio s WHERE s.precServ = :precServ")
    , @NamedQuery(name = "Servicio.findByActvServ", query = "SELECT s FROM Servicio s WHERE s.actvServ = :actvServ")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codi_serv")
    private String codiServ;
    @Basic(optional = false)
    @Column(name = "nomb_serv")
    private String nombServ;
    @Basic(optional = false)
    @Column(name = "prec_serv")
    private double precServ;
    @Basic(optional = false)
    @Column(name = "actv_serv")
    private Character actvServ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioCodiServ")
    private List<Detalle> detalleList;

    public Servicio() {
    }

    public Servicio(String codiServ) {
        this.codiServ = codiServ;
    }

    public Servicio(String codiServ, String nombServ, double precServ, Character actvServ) {
        this.codiServ = codiServ;
        this.nombServ = nombServ;
        this.precServ = precServ;
        this.actvServ = actvServ;
    }

    public String getCodiServ() {
        return codiServ;
    }

    public void setCodiServ(String codiServ) {
        this.codiServ = codiServ;
    }

    public String getNombServ() {
        return nombServ;
    }

    public void setNombServ(String nombServ) {
        this.nombServ = nombServ;
    }

    public double getPrecServ() {
        return precServ;
    }

    public void setPrecServ(double precServ) {
        this.precServ = precServ;
    }

    public Character getActvServ() {
        return actvServ;
    }

    public void setActvServ(Character actvServ) {
        this.actvServ = actvServ;
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
        hash += (codiServ != null ? codiServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.codiServ == null && other.codiServ != null) || (this.codiServ != null && !this.codiServ.equals(other.codiServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Servicio[ codiServ=" + codiServ + " ]";
    }
    
}
