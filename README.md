# SOLID

## Os 3 pilares da OO

### COESÃO

uma classe coesa = uma classe cujos componentes são pertinentes ao seu dominio

"Classes não coesas tendem a crescer indefinidamente, o que as tornam difíceis de manter"

Cada classe deve ser responsável por apenas uma coisa, e deve executar esta tarefa muito bem


### ENCAPSULAMENTO

proteger uma classe de interferencias externas para garantir a consistencia das informações que ela processa

Um bom uso do encapsulamento leva em consideração o contexto das regras de negócio, pois nem sempre prover apenas acesso indireto (getter/setter) é suficiente, inclusive pode ser um risco em potencial. "Classes não encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento". O fato de criar getters e setters para tudo, na verdade, quebra o encapsulamento da nossa classe.

### ACOPLAMENTO

Classes podem conversar entre si, isso é normal e aceitável. O que não é aceitável é que elas se conheçam demais. Deve-se evitar que as classes tenham muita "intimidade". Ora, se elas estiverem bem encapsuladas, ela serão naturalmente "discretas", pois só estarão mostrando para o seu exterior aquilo que é realmente necessário mostrar. Se uma classe X "conhece" e utiliza os detalhes de implementação de outra classe Y, isso implicará em uma dependência exacerbada, o que dificultará a manutenção futura, pois certamente será necessário intervir em X quando for necessário alterar Y.

Quanto menor o ENCAPSULAMENTO, maior será o ACOPLAMENTO!

É fato que, se estamos organizando o nosso código, seguindo as recomendações da orientação a objetos, algum acoplamento acontecerá. Algumas classes precisarão de outras, para que não tenham muitas responsabilidades. Cabe a nós medir quando faz sentido adicionar tal acoplamento com as dependências e como depender do que é seguro, ao invés de classes concretas.

## Os 5 princípios

### Single Responsibility Principle
Aqui nós aumentamos a coesão da classe Funcionario ao extrair a lógica de reajuste de salário para uma classe específica. Deste modo a classe ReajusteService encapsula (protege) a lógica de reajuste (que não é pertinente para a classe Funcionario) e mantém um baixo acoplamento com a classe Funcionario.


### Open Closed Principle
Apesar de estar coesa, a classe ReajusteService poderá crescer de forma indiscriminada a cada necessidade de implementação de novas regras de validação para concessão de reajustes. Para demonstrar este princípio, vamos acrescentar uma regra que valida o tempo mínimo entre reajustes. 

Uma boa abordagem para essa necessidade é isolar a lógica de cada validação em novas classes que implementarão uma abstração (interface) do método validar, comum a ambas. Por fim, a classe ReajusteService receberá uma lista de validações. 

Desta forma, mantemos a coesão e o baixo acoplamento e futuramente não será necessário alterar o código de uma classe já existente, algo que representa um risco (é só lembrar que conforme o primeiro princípio (S), 'uma classe deveria ter apenas um único motivo para mudar', ora se ela tem uma única responsabilidade, em geral, apenas mudanças dentro deste escopo justificam a sua alteração; uma única responsabilidade, um único motivo). 

Quando for necessário adicionar uma validação, basta criar uma classe que implemente a interface ValidacaoReajuste. Perceba que o código permanece aberto para inovações, isto é, permanece extensível, porém preservado (fechado) para alterações que podem causar comportamentos inesperados e indesejados.

### Liskov Substitution Principle
Parece um pato, faz quack, porém precisa de pilha para funcionar, então talvez não estejamos falando de um pato.

Nem todo reaproveitamento é vantajoso e recomendado. No caso da classe Terceirizado, por mais que ele compartilhe características comuns com a classe Funcionario, há comportamentos obtidos através da herança que não são desejáveis.

A abordagem utilizada para resolver isso também envolve reaproveitamento, mas privilegia a composição ao invés da herança. Extraímos os atributos em comum entre Terceirizado e Funcionario para uma nova classe (DadosPessoais) que passou a ser reaproveitada por aquelas duas.

Quando se usa herança, é importante garantir que eventuais mudanças de pré-condições (comportamentos da classe mãe) nas implementações (classes filhas) não irão interferir em outras chamadas da classe mãe. Em geral, mudanças que expandem a pré-condição não causarão comportamentos indesejados, porém mudanças que a tornam mais restritiva certamente resultarão em quebra. Para saber mais: https://www.youtube.com/watch?v=tIcfvP9jf9k