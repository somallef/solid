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