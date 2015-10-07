/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "caracteristica_alimento")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaAlimento.findAll", query = "SELECT c FROM CaracteristicaAlimento c"),
    @NamedQuery(name = "CaracteristicaAlimento.findById", query = "SELECT c FROM CaracteristicaAlimento c WHERE c.id = :id"),
    @NamedQuery(name = "CaracteristicaAlimento.findByDescricao", query = "SELECT c FROM CaracteristicaAlimento c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CaracteristicaAlimento.findByValor", query = "SELECT c FROM CaracteristicaAlimento c WHERE c.valor = :valor")})
public class CaracteristicaAlimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @JoinColumn(name = "alimento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alimento alimento;
    @JoinColumn(name = "unidade_padrao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnidadePadrao unidadePadrao;

    public CaracteristicaAlimento() {
    }

    public CaracteristicaAlimento(Long id) {
        this.id = id;
    }

    public CaracteristicaAlimento(Long id, String descricao) {
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public UnidadePadrao getUnidadePadrao() {
        return unidadePadrao;
    }

    public void setUnidadePadrao(UnidadePadrao unidadePadrao) {
        this.unidadePadrao = unidadePadrao;
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
        if (!(object instanceof CaracteristicaAlimento)) {
            return false;
        }
        CaracteristicaAlimento other = (CaracteristicaAlimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CaracteristicaAlimento[ id=" + id + " ]";
    }
    
}
