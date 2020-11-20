/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DISA - UNAB
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByCodiCita", query = "SELECT c FROM Cita c WHERE c.codiCita = :codiCita")
    , @NamedQuery(name = "Cita.findBySeriCita", query = "SELECT c FROM Cita c WHERE c.seriCita = :seriCita")
    , @NamedQuery(name = "Cita.findByNumeCita", query = "SELECT c FROM Cita c WHERE c.numeCita = :numeCita")
    , @NamedQuery(name = "Cita.findByFechGenr", query = "SELECT c FROM Cita c WHERE c.fechGenr = :fechGenr")
    , @NamedQuery(name = "Cita.findByActvCita", query = "SELECT c FROM Cita c WHERE c.actvCita = :actvCita")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_cita")
    private Integer codiCita;
    @Column(name = "seri_cita")
    private String seriCita;
    @Column(name = "nume_cita")
    private String numeCita;
    @Column(name = "fech_genr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechGenr;
    @Column(name = "actv_cita")
    private Character actvCita;
    @JoinColumn(name = "medico_codi_medi", referencedColumnName = "codi_medi")
    @ManyToOne(optional = false)
    private Medico medicoCodiMedi;
    @JoinColumn(name = "paciente_codi_paci", referencedColumnName = "codi_paci")
    @ManyToOne(optional = false)
    private Paciente pacienteCodiPaci;
    @JoinColumn(name = "usuario_codi_usua", referencedColumnName = "codi_usua")
    @ManyToOne(optional = false)
    private Usuario usuarioCodiUsua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citaCodiCita")
    private List<Detalle> detalleList;

    public Cita() {
    }

    public Cita(Integer codiCita) {
        this.codiCita = codiCita;
    }

    public Integer getCodiCita() {
        return codiCita;
    }

    public void setCodiCita(Integer codiCita) {
        this.codiCita = codiCita;
    }

    public String getSeriCita() {
        return seriCita;
    }

    public void setSeriCita(String seriCita) {
        this.seriCita = seriCita;
    }

    public String getNumeCita() {
        return numeCita;
    }

    public void setNumeCita(String numeCita) {
        this.numeCita = numeCita;
    }

    public Date getFechGenr() {
        return fechGenr;
    }

    public void setFechGenr(Date fechGenr) {
        this.fechGenr = fechGenr;
    }

    public Character getActvCita() {
        return actvCita;
    }

    public void setActvCita(Character actvCita) {
        this.actvCita = actvCita;
    }

    public Medico getMedicoCodiMedi() {
        return medicoCodiMedi;
    }

    public void setMedicoCodiMedi(Medico medicoCodiMedi) {
        this.medicoCodiMedi = medicoCodiMedi;
    }

    public Paciente getPacienteCodiPaci() {
        return pacienteCodiPaci;
    }

    public void setPacienteCodiPaci(Paciente pacienteCodiPaci) {
        this.pacienteCodiPaci = pacienteCodiPaci;
    }

    public Usuario getUsuarioCodiUsua() {
        return usuarioCodiUsua;
    }

    public void setUsuarioCodiUsua(Usuario usuarioCodiUsua) {
        this.usuarioCodiUsua = usuarioCodiUsua;
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
        hash += (codiCita != null ? codiCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.codiCita == null && other.codiCita != null) || (this.codiCita != null && !this.codiCita.equals(other.codiCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Cita[ codiCita=" + codiCita + " ]";
    }
    
}
