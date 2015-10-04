/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//import com.sun.xml.internal.bind.v2.schemagen.Util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author visitante
 */
public class Utilitario {

    /**
     *
     * @param altura
     * @param peso
     * @param idade
     * @return
     */
    public float calcularIMC(float altura, float peso, int idade) {
        float imc = peso / (altura * altura);
        return imc;
    }

    /**
     *
     * @param dataNascimento
     * @return
     */
    public int calcularIdade(Date dataNascimento) {
        int idade = 0;
//        LocalDate data;
//        data = new LocalDate(2015, 5, 10);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
////        Date dataAtual = new Date();
////        
////        dataAtual.get
//        Calendar dataAtual = new GregorianCalendar();
//        
//        dateFormat.
//        
        return idade;

    }

    /**
     *
     * @param peso
     * @param altura
     * @param idade
     * @param genero
     * @return
     */
    public float calcularNivelMetabolicoBasal(float peso, float altura, int idade, char genero) {
        float nivelMetabolicoBasal = 0;
        switch (genero) {
            case 'm':
            case 'M':
                nivelMetabolicoBasal = (float) (10 * peso + 6.25 * altura - 5 * idade + 5);
                break;
            case 'f':
            case 'F':
                nivelMetabolicoBasal = (float) (10 * peso + 6.25 * altura - 5 * idade - 161);
                break;
            default:
                System.out.println("Gênero inválido");
        }
        
        return nivelMetabolicoBasal;
    }
}
