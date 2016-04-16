package pt.ipleiria.estg.p2.projeto.modelo;

public class PainelDeJogo {
    private PainelDeMacas painelDeMacas;
    private PainelDeMovimentosEstrelas painelDeMovimentosEstrelas;
    private PainelDePontuacoes painelDePontuacoes;
    private PainelPrincipal painelPrincipal;
    private Objetivo objetivo;
    
    public PainelDeMacas getPainelDeMacas() {
        return painelDeMacas;
    }

    public void setPainelDeMacas(PainelDeMacas painelDeMacas) {
        this.painelDeMacas = painelDeMacas;
    }

    public PainelDeMovimentosEstrelas getPainelMovimentoDeEstrelas() {
        return painelDeMovimentosEstrelas;
    }

    public void setPainelMovimentoDeEstrelas(PainelDeMovimentosEstrelas painelDeMovimentosEstrelas) {
        this.painelDeMovimentosEstrelas = painelDeMovimentosEstrelas;
    }

    public PainelDePontuacoes getPainelDePontuacoes() {
        return painelDePontuacoes;
    }

    public void setPainelDePontuacoes(PainelDePontuacoes painelDePontuacoes) {
        this.painelDePontuacoes = painelDePontuacoes;
    }

    public PainelPrincipal getPainelPrincipal() {
        return painelPrincipal;
    }

    public void setPainelPrincipal(PainelPrincipal painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }
}
