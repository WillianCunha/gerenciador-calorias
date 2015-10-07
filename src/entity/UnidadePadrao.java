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
@Table(name = "unidade_padrao")
@NamedQueries({
    @NamedQuery(name = "UnidadePadrao.findAll", query = "SELECT u FROM UnidadePadrao u"),
    @NamedQuery(name = "UnidadePadrao.findById", query = "SELECT u FROM UnidadePadrao u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadePadrao.findByDescricao", query = "SELECT u FROM UnidadePadrao u WHERE u.descricao = :descricao")})
public class UnidadePadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadePadrao")
    private List<CaracteristicaAlimento> caracteristicaAlimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadePadrao")
    private List<Porcao> porcaoList;

    public UnidadePadrao() {
    }

    public UnidadePadrao(Long id) {
        this.id = id;
    }

    public UnidadePadrao(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof UnidadePadrao)) {
            return false;
        }
        UnidadePadrao other = (UnidadePadrao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UnidadePadrao[ id=" + id + " ]";
    }
    
}
