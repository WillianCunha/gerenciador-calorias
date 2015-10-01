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
@Table(name = "refeicao")
@NamedQueries({
    @NamedQuery(name = "Refeicao.findAll", query = "SELECT r FROM Refeicao r"),
    @NamedQuery(name = "Refeicao.findById", query = "SELECT r FROM Refeicao r WHERE r.id = :id"),
    @NamedQuery(name = "Refeicao.findByNome", query = "SELECT r FROM Refeicao r WHERE r.nome = :nome"),
    @NamedQuery(name = "Refeicao.findByHorario", query = "SELECT r FROM Refeicao r WHERE r.horario = :horario"),
    @NamedQuery(name = "Refeicao.findByTotalCaloricoRefeicao", query = "SELECT r FROM Refeicao r WHERE r.totalCaloricoRefeicao = :totalCaloricoRefeicao")})
public class Refeicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Basic(optional = false)
    @Column(name = "total_calorico_refeicao")
    private float totalCaloricoRefeicao;
    @JoinColumn(name = "diario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Diario diario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refeicao", fetch = FetchType.LAZY)
    private List<Alimento> alimentoList;

    public Refeicao() {
    }

    public Refeicao(Long id) {
        this.id = id;
    }

    public Refeicao(Long id, String nome, Date horario, float totalCaloricoRefeicao) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.totalCaloricoRefeicao = totalCaloricoRefeicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public float getTotalCaloricoRefeicao() {
        return totalCaloricoRefeicao;
    }

    public void setTotalCaloricoRefeicao(float totalCaloricoRefeicao) {
        this.totalCaloricoRefeicao = totalCaloricoRefeicao;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public List<Alimento> getAlimentoList() {
        return alimentoList;
    }

    public void setAlimentoList(List<Alimento> alimentoList) {
        this.alimentoList = alimentoList;
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
        if (!(object instanceof Refeicao)) {
            return false;
        }
        Refeicao other = (Refeicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Refeicao[ id=" + id + " ]";
    }
    
}
