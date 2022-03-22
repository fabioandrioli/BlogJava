# BlogJava
Para aprimorar meus conhecimentos em Java resolvi criar um pequeno blog de noticas com esta linguagem.

# Criado com o Maven
Importante na criacao deste projeto, deu um problema no maven, para resolver o problema, foi simples, clicamos com botão direito no projeto, achamos o maven, e 
escolhemos a opção update project.

# src/main/resource
- Se esta diretório não tiver com a pasta META-INF, é obrigatória cria - lá.
- dentro da pasta meta-inf criamos o arquivo xml com o nome de persistente.xml

# src/main/java
- As nossas classes ficam no arquivo.
- As logicas e padroes de projeto.

- ``` <property name="hibernat.hbm2ddl.auto" value="update"/> ```
- Caso perceba alguma coisa nova no banco, ou que não existe ele cria ou atualiza, obs: ele não recupera coisas apagas 

- ``` <property name="hibernat.hbm2ddl.auto" value="create"/> ```
- Cria o banco do zero toda vez que inicia a aplicação.

- ``` <property name="hibernat.hbm2ddl.auto" value="create-drop"/> ```
- Cria o banco do zero toda vez que inicia a aplicação. e depois apaga o banco


#Tipos de carregamentos Lazy e EAGER
- Todo relacionamento que termina em ToOne, exemplo ManyToOne, a JPA faz um join na tabela, isso pode gerar um gargalo na apliação.
	Os relacionamentos que não terminam com toMany exemplo OneToMany, a JPA não executa esse join. Para evitar que aconteça um gargalho, temos que definir uma propriedade para nossa anotação
 -	```@ManyToOne(fecth = FetchType.LAZY)```
