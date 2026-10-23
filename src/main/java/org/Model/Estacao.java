package org.Model;

import org.Utils.Data;

/**
 * Representa uma estação do ano, definida por uma designação e por um
 * período (data de início e data de fim).
 */
public class Estacao
{
    private String designacao;
    private Data dataInicio;
    private Data dataFim;

    private static final String DESIGNACAO_POR_OMISSAO = "a definir";

    /**
     * Cria uma estação do ano com valores por omissão.
     */
    public Estacao()
    {
        this.designacao = DESIGNACAO_POR_OMISSAO;
    }

    /**
     * Define os dados da estação do ano.
     *
     * @param designacao designação da estação do ano
     * @param dataInicio data de início do período
     * @param dataFim data de fim do período
     */
    public void setDados(String designacao, Data dataInicio, Data dataFim)
    {
        this.designacao = designacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    /**
     * @return designação da estação do ano
     */
    public String getDesignacao()
    {
        return designacao;
    }

    /**
     * Validação local: designação obrigatória, datas preenchidas e data de
     * fim não anterior à data de início.
     *
     * @return true se os dados forem válidos
     */
    public boolean validar()
    {
        if (designacao == null || designacao.isBlank()
                || designacao.equals(DESIGNACAO_POR_OMISSAO))
        {
            return false;
        }
        if (dataInicio == null || dataFim == null)
        {
            return false;
        }
        return !dataInicio.isMaior(dataFim);
    }

    /**
     * Verifica se o período desta estação se sobrepõe ao de outra.
     *
     * @param outra outra estação do ano
     * @return true se os períodos se sobrepuserem
     */
    public boolean sobrepoe(Estacao outra)
    {
        return !this.dataInicio.isMaior(outra.dataFim)
                && !outra.dataInicio.isMaior(this.dataFim);
    }

    /**
     * @return dados da estação do ano em formato de texto
     */
    public String obterDados()
    {
        return toString();
    }

    @Override
    public String toString()
    {
        return "Estação do ano: " + designacao + " (" + dataInicio + " a " + dataFim + ")\n";
    }
}
