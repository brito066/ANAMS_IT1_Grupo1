/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.UI;

import java.io.IOException;

import org.Model.AssistenteVestuario;
import org.Utils.*;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuAdm_UI
{
    private AssistenteVestuario assistente;
    private String opcao;

    public MenuAdm_UI(AssistenteVestuario assistente)
    {
        this.assistente = assistente;
    }
    public void run() throws IOException
    {
        do
        {   // Completar/Adaptar
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Especificar tipo de vestuário");
            System.out.println("2. Definir listagem de cores");
            System.out.println("3. Consultar todos os tipos de vestuário");
            System.out.println("4. Definir ocasiões");
            System.out.println("5. Definir estações do ano");
            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                EspecificarTipoVestuario_UI ui = new EspecificarTipoVestuario_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("2") )
            {
                DefinirCor_UI ui = new DefinirCor_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("3") )
            {
                ConsultarTiposVestuario_UI ui = new ConsultarTiposVestuario_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("4") )
            {
                DefinirOcasiao_UI ui = new DefinirOcasiao_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("5") )
            {
                DefinirEstacao_UI ui = new DefinirEstacao_UI(assistente);
                ui.run();
            }
        }
        while (!opcao.equals("0") );
    }
}


