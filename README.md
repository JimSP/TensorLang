
# TensorLang

**TensorLang** é uma linguagem funcional, vetorial e determinística baseada em tensores imutáveis.  
Projetada para **análise computacional eficiente**, **transformações vetoriais puras**, e como base para frameworks de **machine learning funcional e sustentável**, sua semântica se baseia em **tensores como valor universal** e propagação semântica rigorosa via o valor terminal `[]`.

---

## ✨ Visão Geral

TensorLang:

- Representa **todos os dados como tensores numéricos imutáveis**
- Possui **funções puras** como primeira classe
- Executa **operações com broadcasting bidirecional**
- Substitui exceções por um **valor terminal universal** (`[]`)
- É **determinística, auditável e energeticamente eficiente**
- Integra-se com **Java via proxies**, permitindo side-effects externos

---

## 📦 Estrutura Atual do Projeto

```
tensorlang/
├── program.tlang                  # exemplo de script TensorLang
├── pom.xml                        # build Maven
├── src/main/antlr4/TensorLang.g4 # gramática ANTLR4 da linguagem
└── src/main/java/lang/            # interpretador base em Java
    ├── Tensor.java                # estrutura de dados tensorial
    ├── TensorFunction.java        # funções internas e built-ins
    ├── UserFunction.java          # definição de funções do usuário
    ├── Env.java                   # ambiente de execução
    ├── TensorLangInterpreter.java# interpretador da linguagem
    └── Main.java                  # ponto de entrada
```

---

## ✅ Funcionalidades Implementadas

- [x] Tipos unificados: tudo é tensor (`[1]`, `[1, 2]`, `"ABC"`, `true`)
- [x] Coerções explícitas: `boolean()`, `string()`, `void()`, etc.
- [x] Valor terminal `[]`: representa erro sem lançar exceções
- [x] Operadores aritméticos e lógicos com broadcasting
- [x] Funções do usuário (`fn(x) => x + x`)
- [x] Execução via JVM (Java 17+)
- [x] Interoperabilidade com Java via proxies para side-effects

---

## 🧠 Modelo Semântico

### Tudo é Tensor

```tlang
a = 3       // [3]
b = [1, 2, 3]
c = a + b   // [4, 5, 6]
```

### Valor Terminal

```tlang
x = [0.0] / [0.0]   // []  ← divisão indefinida
print(x)           // []
```

### Propagação determinística

```tlang
f = fn(x) => x + 1
print(f([]))       // []
```

---

## 🔭 Roadmap de Evolução

### 1. Operações Numéricas Avançadas
- [ ] `exp`, `log`, `pow`, `softmax`, `sigmoid`, `relu`
- [ ] `sum`, `mean`, `argmax`, `argmin`

### 2. Autodiferenciação
- [ ] Rastrear operações para gerar gráfico computacional
- [ ] Implementar `gradient(fn)` com regra da cadeia

### 3. Definição de Modelos
- [ ] `param("w")` → define tensor registrável
- [ ] `Model = fn(x) => x * w + b`

### 4. Otimizadores
- [ ] `sgd(w, grad, lr)` como operador nativo
- [ ] Suporte a atualização de parâmetros com controle funcional

### 5. Suporte a Dataset + Treinamento
- [ ] Iterator funcional para batches
- [ ] Função `train(model, data, labels, loss, optimizer)`

### 6. Compilação e Exportação
- [ ] Geração de código LLVM, WASM ou Java bytecode
- [ ] Exportação de modelos para execução embarcada

---

## 🌱 Diferença Estratégica em Relação a TensorFlow

| Critério               | TensorFlow                | TensorLang Framework                   |
|------------------------|---------------------------|----------------------------------------|
| Tipos                  | Diversos (`Tensor`, etc.) | Um único tipo: `Tensor`                |
| Controle de fluxo      | Imperativo híbrido        | Nenhum (`[]` como semântica terminal)  |
| Vetorização            | Parcial via API           | Nativa e total                         |
| Exceções               | Sim (NaN, erro, etc.)     | Não (erro → `[]`)                      |
| Produtividade          | Média                     | Alta (declarações puras e seguras)     |
| Energia e eficiência   | Alta com tuning           | Muito alta nativamente                 |

---

## 🤝 Contribuindo

Estamos em uma fase de estruturação do runtime e DSL. Sugestões e melhorias são bem-vindas!

---

## 📜 Licença

MIT – uso livre com atribuição. Ideal para aplicações educacionais, científicas e comerciais com propósito ético e sustentável.


