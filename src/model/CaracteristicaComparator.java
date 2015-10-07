/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.CaracteristicaAlimento;
import java.util.Comparator;

/**
 *
 * @author visitante
 */
public class CaracteristicaComparator implements Comparator<CaracteristicaAlimento> {

    @Override
    public int compare(CaracteristicaAlimento o1, CaracteristicaAlimento o2) {
        return (o1.getId() < o2.getId() ? -1 : (o1.getId().longValue() == o2.getId()) ? 0 : 1);
    }

}
