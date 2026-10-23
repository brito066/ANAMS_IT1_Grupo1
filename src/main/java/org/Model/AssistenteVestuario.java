/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class AssistenteVestuario
{
    // Completar/Adaptar
    private final List<Vestuario> lstTiposVestuario;
    private final List<Cor> lstCores;
    private final List<Ocasiao> lstOcasioes;
    private final List<Estacao> lstEstacoes;

    public AssistenteVestuario()
    {
        this.lstTiposVestuario = new ArrayList<>();
        this.lstCores = new ArrayList<>();
        this.lstOcasioes = new ArrayList<>();
        this.lstEstacoes = new ArrayList<>();
    }
  
    public Vestuario novoTipoVestuario()
    {
        return new Vestuario();
    }
    public boolean especificarTipoVesturaio(Vestuario vestuario)
    {
        if (this.valida(vestuario))
        {
           adicionarTipoVestuario(vestuario);
           return true;
        }
        return false;
    }
        
    private void adicionarTipoVestuario(Vestuario vestuario){
        lstTiposVestuario.add(vestuario);
    }
    // Validação global
    public boolean valida(Vestuario vestuario)
    {
        boolean resp = false;
        if (vestuario.valida())
        {
           // Completar        
           //
           resp = true; 
        }
        return resp;
    }
   
    // ---------- Definir listagem de cores ----------

    /**
     * Cria uma nova instância de Cor (padrão Creator).
     *
     * @return nova cor com valores por omissão
     */
    public Cor novaCor()
    {
        return new Cor();
    }

    /**
     * Validação global: dados válidos e cor ainda não existente no sistema
     * nem na listagem em construção.
     *
     * @param cor cor a validar
     * @param cores cores já introduzidas na listagem em construção
     * @return true se a cor for válida
     */
    public boolean validarCor(Cor cor, List<Cor> cores)
    {
        if (!cor.validar())
        {
            return false;
        }
        return !existeCor(cor, lstCores) && !existeCor(cor, cores);
    }

    private boolean existeCor(Cor cor, List<Cor> lista)
    {
        for (Cor x : lista)
        {
            if (x.getDesignacao().equalsIgnoreCase(cor.getDesignacao()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Regista no sistema as cores da listagem definida pelo Administrador.
     *
     * @param cores cores a registar
     * @return true se as cores foram registadas
     */
    public boolean registarCores(List<Cor> cores)
    {
        if (cores.isEmpty())
        {
            return false;
        }
        addCores(cores);
        return true;
    }

    private void addCores(List<Cor> cores)
    {
        lstCores.addAll(cores);
    }

    // ---------- Definir ocasiões ----------

    /**
     * Cria uma nova instância de Ocasiao (padrão Creator).
     *
     * @return nova ocasião com valores por omissão
     */
    public Ocasiao novaOcasiao()
    {
        return new Ocasiao();
    }

    /**
     * Validação global: dados válidos e ocasião ainda não existente no sistema
     * nem na listagem em construção.
     *
     * @param ocasiao ocasião a validar
     * @param ocasioes ocasiões já introduzidas na listagem em construção
     * @return true se a ocasião for válida
     */
    public boolean validarOcasiao(Ocasiao ocasiao, List<Ocasiao> ocasioes)
    {
        if (!ocasiao.validar())
        {
            return false;
        }
        return !existeOcasiao(ocasiao, lstOcasioes) && !existeOcasiao(ocasiao, ocasioes);
    }

    private boolean existeOcasiao(Ocasiao ocasiao, List<Ocasiao> lista)
    {
        for (Ocasiao x : lista)
        {
            if (x.getDesignacao().equalsIgnoreCase(ocasiao.getDesignacao()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Regista no sistema as ocasiões da listagem definida pelo Administrador.
     *
     * @param ocasioes ocasiões a registar
     * @return true se as ocasiões foram registadas
     */
    public boolean registarOcasioes(List<Ocasiao> ocasioes)
    {
        if (ocasioes.isEmpty())
        {
            return false;
        }
        addOcasioes(ocasioes);
        return true;
    }

    private void addOcasioes(List<Ocasiao> ocasioes)
    {
        lstOcasioes.addAll(ocasioes);
    }

    // ---------- Definir estações do ano ----------

    /**
     * Cria uma nova instância de Estacao (padrão Creator).
     *
     * @return nova estação do ano com valores por omissão
     */
    public Estacao novaEstacao()
    {
        return new Estacao();
    }

    /**
     * Validação global: dados válidos e estação do ano ainda não existente no sistema
     * nem na listagem em construção, sem períodos sobrepostos.
     *
     * @param estacao estação do ano a validar
     * @param estacoes estações do ano já introduzidas na listagem em construção
     * @return true se a estação do ano for válida
     */
    public boolean validarEstacao(Estacao estacao, List<Estacao> estacoes)
    {
        if (!estacao.validar())
        {
            return false;
        }
        return !existeEstacao(estacao, lstEstacoes) && !existeEstacao(estacao, estacoes);
    }

    private boolean existeEstacao(Estacao estacao, List<Estacao> lista)
    {
        for (Estacao x : lista)
        {
            if (x.getDesignacao().equalsIgnoreCase(estacao.getDesignacao())
                    || x.sobrepoe(estacao))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Regista no sistema as estações do ano da listagem definida pelo Administrador.
     *
     * @param estacoes estações do ano a registar
     * @return true se as estações do ano foram registadas
     */
    public boolean registarEstacoes(List<Estacao> estacoes)
    {
        if (estacoes.isEmpty())
        {
            return false;
        }
        addEstacoes(estacoes);
        return true;
    }

    private void addEstacoes(List<Estacao> estacoes)
    {
        lstEstacoes.addAll(estacoes);
    }

    // Completar com outras funcionalidades
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AssistenteVestuario: \n");
        sb.append("Listagem de tipos de vestuário: "+ lstTiposVestuario.toString()+"\n");
        return sb.toString();
    }
    public String obterTiposVestuarioAsString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem de tipos de vestuário\n");
        for(Vestuario v: lstTiposVestuario){
            sb.append(v.toString());
        }
        return sb.toString();
    }
}
    
    
