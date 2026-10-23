package org.Controller;

import org.Model.AssistenteVestuario;
/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class ConsultarTiposVestuario_Controller
{
    private final AssistenteVestuario assistente;

    public ConsultarTiposVestuario_Controller(AssistenteVestuario assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }
    public String obterTiposVestuarioAsString()
    {
        String ltv = assistente.obterTiposVestuarioAsString();
        return ltv;
    }
}