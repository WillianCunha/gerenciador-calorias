/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author winston.sonnesen
 */
@Embeddable
public class CaracteristicaAlimentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "alimento_id")
    private long alimentoId;

    /**
     *
     */
    public CaracteristicaAlimentoPK() {
    }

    /**
     *
     * @param id
     * @param alimentoId
     */
    public CaracteristicaAlimentoPK(long id, long alimentoId) {
        this.id = id;
        this.alimentoId = alimentoId;
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public long getAlimentoId() {
        return alimentoId;
    }

    /**
     *
     * @param alimentoId
     */
    public void setAlimentoId(long alimentoId) {
        this.alimentoId = alimentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) alimentoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaAlimentoPK)) {
            return false;
        }
        CaracteristicaAlimentoPK other = (CaracteristicaAlimentoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.alimentoId != other.alimentoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CaracteristicaAlimentoPK[ id=" + id + ", alimentoId=" + alimentoId + " ]";
    }
    
}
