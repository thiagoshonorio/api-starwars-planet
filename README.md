# api-starwars-planet

![alt text](https://ci6.googleusercontent.com/proxy/hH3anIPi37J_hCimvXvvnpbIHogCKfBEOTV8H8irArtqxgzatfPmcNSjT9lCKfKCeAlK9KzI5fqPGG-_XSAD4h1tdWZgOpySfceRpT2WuZ-2_GRS2czq7lTjNO3wnl3OtzRd3U1EWMzDlg0HRfg6YfLzUvwbFotn=s0-d-e1-ft#http://img.americanas.com.br/gentegestao/2018/Com-interna/G&G/Recrutamento/Desafio_Star-Wars_back.png)

DESAFIO AMEDIGITAL

- A API deve ser REST
- Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente:
Nome
Clima
Terreno
- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.co/


Funcionalidades: 
- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

Desenvolvido em JAVA + SPRING + MAVEN + MONGODB

Listar todos os planetas no banco de dados
http://localhost:8080/api/starwars/planets

Listar todos os planetas na API Externa https://swapi.co/
http://localhost:8080/api/starwars/planets/swapi

Listar o planeta por ID
http://localhost:8080/api/starwars/planets/id/{id}

Listar o planeta por nome
http://localhost:8080/api/starwars/planets/nome/{nome}

Inserir novo planeta e grava no banco de dados MongoDB com Json
http://localhost:8080/api/starwars/planets
Exemplo:
 {
            "nome": "nomePlaneta",
            "clima": "climaPlaneta",
             "terreno": "terrenoPlaneta"
  }
  
  Editar um planeta já inserido no Banco de Dados:
  http://localhost:8080/api/starwars/planets/atualizar/{id}
  
  Remover um planeta que foi inserido no Banco de Dados:
  http://localhost:8080/api/starwars/planets/deletar/{id}
  
  
  
  
  
