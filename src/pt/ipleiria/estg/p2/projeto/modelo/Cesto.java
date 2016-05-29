package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Iteravel;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.Suporte;
import pt.ipleiria.estg.p2.projeto.modelo.suportes.SuporteAgua;


public class Cesto extends Suportado<SuporteAgua> implements Iteravel
{
	/* suporte, imagem, estado(cheio ou nao (altera a imagem)), tempodeEstado*/
	private Suporte suporte;
	
    public Cesto(SuporteAgua suporte) {
        super("/pt/ipleiria/estg/p2/projeto/imagens/objetivos/cesto.png",suporte);
       
    }
	
	public void verificarSeCestoTemMaca()
	{
		suporte.estadoDoCesto();
	}
    
    public void iterar(long tempo){

    }

	public boolean aceitas(Suportado suportado) {
		if(suportado instanceof Maca)
			return true;
		//iniciar temporizador
		
		return false;
		
	}
}
