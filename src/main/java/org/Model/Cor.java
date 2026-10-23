package org.Model;

/**
 * Representa uma cor usada para caracterizar peças de vestuário.
 */
public class Cor
{
    private String designacao;

    private static final String DESIGNACAO_POR_OMISSAO = "a definir";

    /**
     * Cria uma cor com a designação por omissão.
     */
    public Cor()
    {
        this.designacao = DESIGNACAO_POR_OMISSAO;
    }

    /**
     * Define os dados da cor.
     *
     * @param designacao designação da cor
     */
    public void setDados(String designacao)
    {
        this.designacao = designacao;
    }

    /**
     * @return designação da cor
     */
    public String getDesignacao()
    {
        return designacao;
    }

    /**
     * Validação local: a designação é obrigatória.
     *
     * @return true se os dados forem válidos
     */
    public boolean validar()
    {
        return designacao != null && !designacao.isBlank()
                && !designacao.equals(DESIGNACAO_POR_OMISSAO);
    }

    /**
     * @return dados da cor em formato de texto
     */
    public String obterDados()
    {
        return toString();
    }

    @Override
    public String toString()
    {
        return "Cor: " + designacao + "\n";
    }
}
