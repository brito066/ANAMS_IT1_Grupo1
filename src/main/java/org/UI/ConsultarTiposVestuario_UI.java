package org.UI;

import org.Controller.ConsultarTiposVestuario_Controller;
import org.Model.AssistenteVestuario;

public class ConsultarTiposVestuario_UI {
    private AssistenteVestuario assistente;
    private ConsultarTiposVestuario_Controller controller;

    public ConsultarTiposVestuario_UI(AssistenteVestuario assistenteDigital) {
        this.assistente = assistenteDigital;
        controller = new ConsultarTiposVestuario_Controller(assistenteDigital);
    }

    public void run() {
        String ltv = controller.obterTiposVestuarioAsString();
        System.out.println(ltv);
    }
}
