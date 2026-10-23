package org.Model;

/**
 * Representa uma ocasião usada para caracterizar peças de vestuário.
 */
public class Ocasiao
{
    private String designacao;

    private static final String DESIGNACAO_POR_OMISSAO = "a definir";

    /**
     * Cria uma ocasião com a designação por omissão.
     */
    public Ocasiao()
    {
        this.designacao = DESIGNACAO_POR_OMISSAO;
    }

    /**
     * Define os dados da ocasião.
     *
     * @param designacao designação da ocasião
     */
    public void setDados(String designacao)
    {
        this.designacao = designacao;
    }

    /**
     * @return designação da ocasião
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
     * @return dados da ocasião em formato de texto
     */
    public String obterDados()
    {
        return toString();
    }

    @Override
    public String toString()
    {
        return "Ocasião: " + designacao + "\n";
    }
}
