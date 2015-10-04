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

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "refeicao")
@NamedQueries({
    @NamedQuery(name = "Refeicao.findAll", query = "SELECT r FROM Refeicao r"),
    @NamedQuery(name = "Refeicao.findById", query = "SELECT r FROM Refeicao r WHERE r.id = :id"),
    @NamedQuery(name = "Refeicao.findByNome", query = "SELECT r FROM Refeicao r WHERE r.nome = :nome")})
public class Refeicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "registro_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Registro registro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refeicao", fetch = FetchType.LAZY)
    private List<Porcao> porcaoList;

    /**
     *
     */
    public Refeicao() {
    }

    /**
     *
     * @param id
     */
    public Refeicao(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param nome
     */
    public Refeicao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Registro getRegistro() {
        return registro;
    }

    /**
     *
     * @param registro
     */
    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    /**
     *
     * @return
     */
    public List<Porcao> getPorcaoList() {
        return porcaoList;
    }

    /**
     *
     * @param porcaoList
     */
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
