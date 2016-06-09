/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.Suportado;
import pt.ipleiria.estg.p2.projeto.modelo.suportaveis.animais.Animal;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

/**
 *
 * @author nes
 */
public class Combinavel extends Suportado<SuporteSuportador>
{
    public Combinavel(String representacao, SuporteSuportador suporte)
    {
        super(representacao, suporte);
    }

    public boolean combinaCom(Suportado suportado)
    {
        if (((Animal)suportado).getTipo() == ((Animal) this).getTipo()) {
            return true;
        }
        return false;
    }
    
}
