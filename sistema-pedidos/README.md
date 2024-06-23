> Feito por Caio Pereira Farias \
> Criado em 22/06/2024


### Estrutura
- `src/main/resources/internal` - Arquivos internos do sistema
- `src/main` - Pasta com controladores e inicializador Spring
- `src/test` - Pasta com testes feitos em JUnit

### Configurações
- Codificação UTF-8

### Rotas

#### [GET] `/clientes`
- Lista todos os objetos do tipo `Cliente` dentro do sistema

#### [GET] `/clientes/{id}`
- Retorna o objeto `Cliente` que possui o `id` fornecido, caso contrário, retorna o código 404 (Não encontrado)

#### [GET] `/produtos`
- Lista todos os objetos do tipo `Produto` dentro do sistema

#### [GET] `/produtos/{id}`
- Retorna o objeto `Produto` que possui o `id` fornecido, caso contrário, retorna o código 404 (Não encontrado)

---

#### Exemplo de response (200)
```json
{
  "mensagem": "Produto encontrado",
  "data": {
    "idProduto": 1,
    "nome": "Celular",
    "descricao": "Smartphone com tela de 6.5 polegadas",
    "preco": 1500.0,
    "estoque": 100
  }
}
```

#### Exemplo de response (404)
```json
{
  "mensagem": "Produto não encontrado",
  "data": null
}
```