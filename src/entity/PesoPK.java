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
public class PesoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private long usuarioId;

    /**
     *
     */
    public PesoPK() {
    }

    /**
     *
     * @param id
     * @param usuarioId
     */
    public PesoPK(long id, long usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
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
    public long getUsuarioId() {
        return usuarioId;
    }

    /**
     *
     * @param usuarioId
     */
    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoPK)) {
            return false;
        }
        PesoPK other = (PesoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PesoPK[ id=" + id + ", usuarioId=" + usuarioId + " ]";
    }
    
}
