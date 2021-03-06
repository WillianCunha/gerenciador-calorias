/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "alimento")
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findById", query = "SELECT a FROM Alimento a WHERE a.id = :id"),
    @NamedQuery(name = "Alimento.findByNome", query = "SELECT a FROM Alimento a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alimento.findByTipo", query = "SELECT a FROM Alimento a WHERE a.tipo = :tipo")})
public class Alimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimento")
    private List<CaracteristicaAlimento> caracteristicaAlimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimento")
    private List<Porcao> porcaoList;

    public Alimento() {
    }

    public Alimento(Long id) {
        this.id = id;
    }

    public Alimento(Long id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<CaracteristicaAlimento> getCaracteristicaAlimentoList() {
        return caracteristicaAlimentoList;
    }

    public void setCaracteristicaAlimentoList(List<CaracteristicaAlimento> caracteristicaAlimentoList) {
        this.caracteristicaAlimentoList = caracteristicaAlimentoList;
    }

    public List<Porcao> getPorcaoList() {
        return porcaoList;
    }

    public void setPorcaoList(List<Porcao> porcaoList) {
        this.porcaoList = porcaoList;
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
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Alimento[ id=" + id + " ]";
    }
    
}
