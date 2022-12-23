package br.com.allef.rh.service.promocao;

import br.com.allef.rh.ValidacaoException;
import br.com.allef.rh.model.Cargo;
import br.com.allef.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {

        Cargo cargoAtual = funcionario.getCargo();

        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        }

    }
}
