/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Peso;
import java.util.Comparator;

/**
 *
 * @author winston.sonnesen
 */
public class PesoComparator implements Comparator<Peso> {

    @Override
    public int compare(Peso o1, Peso o2) {
        return (o1.getId()< o2.getId() ? -1 : (o1.getId().longValue() == o2.getId()) ? 0 : 1);
    }

}
