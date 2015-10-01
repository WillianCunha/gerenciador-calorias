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
@Table(name = "alimento")
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findById", query = "SELECT a FROM Alimento a WHERE a.id = :id"),
    @NamedQuery(name = "Alimento.findByNome", query = "SELECT a FROM Alimento a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alimento.findByTipo", query = "SELECT a FROM Alimento a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Alimento.findByCalorias", query = "SELECT a FROM Alimento a WHERE a.calorias = :calorias"),
    @NamedQuery(name = "Alimento.findByCarboidratos", query = "SELECT a FROM Alimento a WHERE a.carboidratos = :carboidratos"),
    @NamedQuery(name = "Alimento.findByProteinas", query = "SELECT a FROM Alimento a WHERE a.proteinas = :proteinas"),
    @NamedQuery(name = "Alimento.findByGorduras", query = "SELECT a FROM Alimento a WHERE a.gorduras = :gorduras"),
    @NamedQuery(name = "Alimento.findByFibras", query = "SELECT a FROM Alimento a WHERE a.fibras = :fibras"),
    @NamedQuery(name = "Alimento.findBySodio", query = "SELECT a FROM Alimento a WHERE a.sodio = :sodio")})
public class Alimento implements Serializable {
    @Basic(optional = false)
    @Column(name = "porcao")
    private int porcao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "carboidratos")
    private Float carboidratos;
    @Column(name = "proteinas")
    private Float proteinas;
    @Column(name = "gorduras")
    private Float gorduras;
    @Column(name = "fibras")
    private Float fibras;
    @Column(name = "sodio")
    private Float sodio;
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
    @Basic(optional = false)
    @Column(name = "calorias")
    private float calorias;
    @JoinColumn(name = "refeicao_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Refeicao refeicao;

    public Alimento() {
    }

    public Alimento(Long id) {
        this.id = id;
    }

    public Alimento(Long id, String nome, String tipo, float calorias, float carboidratos, float proteinas, float gorduras, float fibras, float sodio) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.calorias = calorias;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.fibras = fibras;
        this.sodio = sodio;
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

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }


    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
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

    public Float getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(Float carboidratos) {
        this.carboidratos = carboidratos;
    }

    public Float getProteinas() {
        return proteinas;
    }

    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    public Float getGorduras() {
        return gorduras;
    }

    public void setGorduras(Float gorduras) {
        this.gorduras = gorduras;
    }

    public Float getFibras() {
        return fibras;
    }

    public void setFibras(Float fibras) {
        this.fibras = fibras;
    }

    public Float getSodio() {
        return sodio;
    }

    public void setSodio(Float sodio) {
        this.sodio = sodio;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }
    
}
