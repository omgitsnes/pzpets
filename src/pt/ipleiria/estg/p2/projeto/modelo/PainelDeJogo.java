package pt.ipleiria.estg.p2.projeto.modelo;

public class PainelDeJogo {
    private PainelDeMacas painelDeMacas;
    private PainelMovimentosEstrelas painelMovimentosEstrelas;
    private PainelDePontuacoes painelDePontuacoes;
    private PainelPrincipal painelPrincipal;
    private Objetivo objetivo;
    
    public PainelDeMacas getPainelDeMacas() {
        return painelDeMacas;
    }

    public void setPainelDeMacas(PainelDeMacas painelDeMacas) {
        this.painelDeMacas = painelDeMacas;
    }

    public PainelMovimentosEstrelas getPainelMovimentoDeEstrelas() {
        return painelMovimentosEstrelas;
    }

    public void setPainelMovimentoDeEstrelas(PainelMovimentosEstrelas painelMovimentosDeEstrelas) {
        this.painelMovimentosEstrelas = painelMovimentosDeEstrelas;
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
