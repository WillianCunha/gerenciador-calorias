package model;

import entity.Refeicao;
import java.util.Comparator;

/**
 *
 * @author Rosipetit
 */
public class RefeicaoComparator implements Comparator<Refeicao>{

    @Override
    public int compare(Refeicao o1, Refeicao o2) {
        return (o1.getId()< o2.getId() ? -1 : (o1.getId().longValue() == o2.getId()) ? 0 : 1);
    }
    
}
