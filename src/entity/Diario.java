/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "diario")
@NamedQueries({
    @NamedQuery(name = "Diario.findAll", query = "SELECT d FROM Diario d"),
    @NamedQuery(name = "Diario.findById", query = "SELECT d FROM Diario d WHERE d.id = :id"),
    @NamedQuery(name = "Diario.findByData", query = "SELECT d FROM Diario d WHERE d.data = :data"),
    @NamedQuery(name = "Diario.findByNumeroRefeicoes", query = "SELECT d FROM Diario d WHERE d.numeroRefeicoes = :numeroRefeicoes"),
    @NamedQuery(name = "Diario.findByTotalCalorico", query = "SELECT d FROM Diario d WHERE d.totalCalorico = :totalCalorico")})
public class Diario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "numero_refeicoes")
    private int numeroRefeicoes;
    @Basic(optional = false)
    @Column(name = "total_calorico")
    private float totalCalorico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diario", fetch = FetchType.LAZY)
    private List<Refeicao> refeicaoList;
    @JoinColumn(name = "registro_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Registro registro;

    public Diario() {
    }

    public Diario(Long id) {
        this.id = id;
    }

    public Diario(Long id, Date data, int numeroRefeicoes, float totalCalorico) {
        this.id = id;
        this.data = data;
        this.numeroRefeicoes = numeroRefeicoes;
        this.totalCalorico = totalCalorico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public float getTotalCalorico() {
        return totalCalorico;
    }

    public void setTotalCalorico(float totalCalorico) {
        this.totalCalorico = totalCalorico;
    }

    public List<Refeicao> getRefeicaoList() {
        return refeicaoList;
    }

    public void setRefeicaoList(List<Refeicao> refeicaoList) {
        this.refeicaoList = refeicaoList;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
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
        if (!(object instanceof Diario)) {
            return false;
        }
        Diario other = (Diario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Diario[ id=" + id + " ]";
    }
    
}
