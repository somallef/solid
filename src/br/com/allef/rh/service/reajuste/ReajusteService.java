package br.com.allef.rh.service.reajuste;

import br.com.allef.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        //para cada validação v, invoque o método validar passando funcionario e aumento
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        //se todas as validações passarem, isto é, se nenhuma exceção for lançada pelas validações, o código abaixo é executado
        BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
