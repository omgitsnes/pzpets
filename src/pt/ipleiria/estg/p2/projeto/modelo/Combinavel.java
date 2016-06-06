/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteSuportador;

/**
 *
 * @author nes
 */
class Combinavel extends Suportado<SuporteSuportador>
{
    public Combinavel(String representacao, SuporteSuportador suporte)
    {
        super(representacao, suporte);
    }
    
}
