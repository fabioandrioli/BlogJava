# BlogJava
Para aprimorar meus conhecimentos em Java resolvi criar um pequeno blog de noticas com esta linguagem.

# Criado com o Maven
Importante na criacao deste projeto, deu um problema no maven, para resolver o problema, foi simples, clicamos com bot�o direito no projeto, achamos o maven, e 
escolhemos a op��o update project.

# src/main/resource
- Se esta diret�rio n�o tiver com a pasta META-INF, � obrigat�ria cria - l�.
- dentro da pasta meta-inf criamos o arquivo xml com o nome de persistente.xml

# src/main/java
- As nossas classes ficam no arquivo.
- As logicas e padroes de projeto.

- ``` <property name="hibernat.hbm2ddl.auto" value="update"/> ```
- Caso perceba alguma coisa nova no banco, ou que n�o existe ele cria ou atualiza, obs: ele n�o recupera coisas apagas 

- ``` <property name="hibernat.hbm2ddl.auto" value="create"/> ```
- Cria o banco do zero toda vez que inicia a aplica��o.

- ``` <property name="hibernat.hbm2ddl.auto" value="create-drop"/> ```
- Cria o banco do zero toda vez que inicia a aplica��o. e depois apaga o banco

