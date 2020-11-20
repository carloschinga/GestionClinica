/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Chinga
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByCodiDeta", query = "SELECT d FROM Detalle d WHERE d.codiDeta = :codiDeta")
    , @NamedQuery(name = "Detalle.findByPrecServ", query = "SELECT d FROM Detalle d WHERE d.precServ = :precServ")
    , @NamedQuery(name = "Detalle.findByFechAten", query = "SELECT d FROM Detalle d WHERE d.fechAten = :fechAten")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_deta")
    private Integer codiDeta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prec_serv")
    private Double precServ;
    @Column(name = "fech_aten")
    @Temporal(TemporalType.DATE)
    private Date fechAten;
    @JoinColumn(name = "cita_codi_cita", referencedColumnName = "codi_cita")
    @ManyToOne(optional = false)
    private Cita citaCodiCita;
    @JoinColumn(name = "hora_codi_hora", referencedColumnName = "codi_hora")
    @ManyToOne(optional = false)
    private Hora horaCodiHora;
    @JoinColumn(name = "servicio_codi_serv", referencedColumnName = "codi_serv")
    @ManyToOne(optional = false)
    private Servicio servicioCodiServ;

    public Detalle() {
    }

    public Detalle(Integer codiDeta) {
        this.codiDeta = codiDeta;
    }

    public Integer getCodiDeta() {
        return codiDeta;
    }

    public void setCodiDeta(Integer codiDeta) {
        this.codiDeta = codiDeta;
    }

    public Double getPrecServ() {
        return precServ;
    }

    public void setPrecServ(Double precServ) {
        this.precServ = precServ;
    }

    public Date getFechAten() {
        return fechAten;
    }

    public void setFechAten(Date fechAten) {
        this.fechAten = fechAten;
    }

    public Cita getCitaCodiCita() {
        return citaCodiCita;
    }

    public void setCitaCodiCita(Cita citaCodiCita) {
        this.citaCodiCita = citaCodiCita;
    }

    public Hora getHoraCodiHora() {
        return horaCodiHora;
    }

    public void setHoraCodiHora(Hora horaCodiHora) {
        this.horaCodiHora = horaCodiHora;
    }

    public Servicio getServicioCodiServ() {
        return servicioCodiServ;
    }

    public void setServicioCodiServ(Servicio servicioCodiServ) {
        this.servicioCodiServ = servicioCodiServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiDeta != null ? codiDeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.codiDeta == null && other.codiDeta != null) || (this.codiDeta != null && !this.codiDeta.equals(other.codiDeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Detalle[ codiDeta=" + codiDeta + " ]";
    }
    
}
