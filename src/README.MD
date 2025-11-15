🔰  - Nome: Leonardo Pacífico de Medeiros - RA: 248465  - 🔰

✔️ 1. Análise do Código (Caixa Branca Estática)
O código foi devidamente documentado?

Não. Praticamente nenhum comentário relevante foi utilizado.

As variáveis e constantes possuem boa nomenclatura?

Parcialmente.
Nomes como result, nome, conn, sql não são descritivos o suficiente.

Existem legibilidade e organização no código?

Não.
Indentação ruim, concatenação de SQL, ausência de camadas separadas e blocos catch vazios.

Todos os NullPointers foram tratados?

Não.
Se conectarBD() retornar null, ocorre exceção em conn.createStatement().

As conexões foram fechadas corretamente?

Não.
Connection, Statement e ResultSet não são fechados.




    -- Documentação User.java (Codigo corrigido) --


✅ 1. Documentação adicionada (JavaDoc)

Agora o código explica o que cada método faz.

✅ 2. Nome de variáveis padronizado

Antes: sql, result, nome público…

Depois: variáveis privadas, constantes e nomes mais claros.

✅ 3. Legibilidade e organização

Código indentado corretamente

Comentários explicativos

Separação clara das responsabilidades

✅ 4. NullPointer tratado

Antes: se a conexão desse erro, conn = null → conn.createStatement() quebrava.

Agora:

Uso de try-with-resources

Verificação automática de null

Fechamento automático dos recursos

✅ 5. Conexões fechadas corretamente

Antes: NADA era fechado.
Agora: Connection, PreparedStatement e ResultSet fecham sozinhos.

✅ 6. SQL Injection removido

Antes: concatenava strings  
Agora: usa conect PreparedStatement com ?.