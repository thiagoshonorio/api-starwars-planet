# api-starwars-planet


Funcionalidades: 
- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

Desenvolvido em JAVA + SPRING + MAVEN + MONGODB

**Listar todos os planetas no banco de dados**

http://localhost:8080/api/starwars/planets

**Listar todos os planetas na API Externa https://swapi.co/**

http://localhost:8080/api/starwars/planets/swapi

**Listar o planeta por ID**

http://localhost:8080/api/starwars/planets/id/{id}

**Listar o planeta por nome**

http://localhost:8080/api/starwars/planets/nome/{nome}

**Inserir novo planeta e grava no banco de dados MongoDB com Json**

http://localhost:8080/api/starwars/planets

Exemplo:
 {
    "nome": "nomePlaneta",
    "clima": "climaPlaneta",
    "terreno": "terrenoPlaneta"
  }
  
  **Editar um planeta já inserido no Banco de Dados:**
  
  http://localhost:8080/api/starwars/planets/atualizar/{id}
  
 **Remover um planeta que foi inserido no Banco de Dados:**
  
  http://localhost:8080/api/starwars/planets/deletar/{id}
  
  
  
  
  
