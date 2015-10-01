/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "peso")
@NamedQueries({
    @NamedQuery(name = "Peso.findAll", query = "SELECT p FROM Peso p"),
    @NamedQuery(name = "Peso.findById", query = "SELECT p FROM Peso p WHERE p.id = :id"),
    @NamedQuery(name = "Peso.findByPeso", query = "SELECT p FROM Peso p WHERE p.peso = :peso"),
    @NamedQuery(name = "Peso.findByData", query = "SELECT p FROM Peso p WHERE p.data = :data"),
    @NamedQuery(name = "Peso.findByPesoAtual", query = "SELECT p FROM Peso p WHERE p.pesoAtual = :pesoAtual")})
public class Peso implements Serializable {
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "peso")
    private float peso;
    @Column(name = "peso_atual")
    private Boolean pesoAtual;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    // Incluí a inicialização do usuario
    public Peso() {
        usuario = new Usuario();
    }

    public Peso(Long id) {
        this.id = id;
    }

    public Peso(Long id, float peso, Date data) {
        this.id = id;
        this.peso = peso;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


    public Boolean getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(Boolean pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peso)) {
            return false;
        }
        Peso other = (Peso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Peso[ id=" + id + " ]";
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
