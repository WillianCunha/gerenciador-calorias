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
import javax.persistence.FetchType;
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
@Table(name = "porcao")
@NamedQueries({
    @NamedQuery(name = "Porcao.findAll", query = "SELECT p FROM Porcao p"),
    @NamedQuery(name = "Porcao.findById", query = "SELECT p FROM Porcao p WHERE p.id = :id"),
    @NamedQuery(name = "Porcao.findByQuantidade", query = "SELECT p FROM Porcao p WHERE p.quantidade = :quantidade")})
public class Porcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @JoinColumn(name = "alimento_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alimento alimento;
    @JoinColumn(name = "refeicao_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Refeicao refeicao;
    @JoinColumn(name = "unidade_padrao_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadePadrao unidadePadrao;

    /**
     *
     */
    public Porcao() {
    }

    /**
     *
     * @param id
     */
    public Porcao(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Float getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public Alimento getAlimento() {
        return alimento;
    }

    /**
     *
     * @param alimento
     */
    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    /**
     *
     * @return
     */
    public Refeicao getRefeicao() {
        return refeicao;
    }

    /**
     *
     * @param refeicao
     */
    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    /**
     *
     * @return
     */
    public UnidadePadrao getUnidadePadrao() {
        return unidadePadrao;
    }

    /**
     *
     * @param unidadePadrao
     */
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
        if (!(object instanceof Porcao)) {
            return false;
        }
        Porcao other = (Porcao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Porcao[ id=" + id + " ]";
    }
    
}
