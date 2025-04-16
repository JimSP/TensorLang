# TensorLang

**TensorLang** é uma linguagem funcional, vetorial e determinística baseada em tensores imutáveis.  
Projetada para análise computacional eficiente, transformações vetoriais puras e como base para frameworks de machine learning auditável e explicável.

Sua semântica se baseia em **tensores como valor universal** e **propagação semântica rigorosa** via o valor terminal `[]`.

---

## ✨ Visão Geral

TensorLang:

- Representa todos os dados como tensores numéricos imutáveis
- Possui funções puras como primeira classe
- Executa operações com broadcasting bidirecional
- Substitui exceções por um valor terminal universal (`[]`)
- É determinística, auditável e energeticamente eficiente
- Integra-se com Java via proxies, permitindo side-effects externos

---

## ✅ Exemplo de Execução Real

Script: [`program.tlang`](./program.tlang)

```tlang
x = 3 + 4
print x                    // [7.0]

a = 3
b = [1, 2, 3]
print a + b                // [4.0, 5.0, 6.0]

s = "ABC"
print s + 2                // [67.0, 68.0, 69.0]  // ASCII somado a escalar

boolTrue = true
boolFalse = false
print boolTrue && boolFalse  // [0.0]

v1 = [true, false, true]
v2 = [true, true, false]
print v1 && v2             // [1.0, 0.0, 0.0]
print v1 || v2             // [1.0, 1.0, 1.0]

double = fn(x) => x + x
print double(5)            // [10.0]
print double("hi")         // [208.0, 210.0]
print double([1,2,3])      // [2.0, 4.0, 6.0]

d = (3 + 2) && true
print d                    // [1.0]
```

### Execução:

```bash
java --enable-preview \\
  --add-modules jdk.incubator.vector \\
  -cp target/classes:target/generated-sources/antlr4:$(cat cp.txt) \\
  lang.Main program.tlang
```

---

## 🧠 Modelo Semântico

### Tudo é Tensor

```tlang
a = 3       // [3.0]
b = [1, 2, 3]
c = a + b   // [4.0, 5.0, 6.0]
```

### Valor Terminal `[]`

```tlang
x = [0.0] / [0.0]  // []
print(x)           // []
```

### Propagação Determinística

```tlang
f = fn(x) => x + 1
print(f([]))       // []
```

---

## 📁 Estrutura do Projeto

```
tensorlang/
├── program.tlang                  # Exemplo de script TensorLang
├── pom.xml                        # Build Maven
├── src/main/antlr4/TensorLang.g4  # Gramática ANTLR4
└── src/main/java/lang/            # Interpretador base em Java
    ├── Tensor.java
    ├── TensorFunction.java
    ├── UserFunction.java
    ├── Env.java
    ├── TensorLangInterpreter.java
    └── Main.java
```
## 🚀 Roadmap de Evolução

### 1. Operações Numéricas Avançadas
- `exp`, `log`, `pow`, `softmax`, `sigmoid`, `relu`
- `sum`, `mean`, `argmax`, `argmin`

### 2. Autodiferenciação
- `gradient(fn)` com rastreio semântico

### 3. Definição de Modelos e Treinamento
- `param("w")`, `train(...)`, controle funcional puro

### 4. Compilação e Exportação
- LLVM, WASM, Java bytecode

---

## 🧬 Diferenciais Estratégicos

| Critério               | TensorLang                          | Frameworks ML Tradicionais       |
|------------------------|-------------------------------------|----------------------------------|
| **Tipagem**            | Tensor puro                         | Tipos diversos, híbridos         |
| **Execução**           | Funcional, vetorial, auditável      | Imperativa ou híbrida            |
| **Controle de Fluxo**  | Composicional (`if_vec`)            | `if`, `while`, macros            |
| **Valor Terminal**     | `[]`, propagação semântica          | Exceções ou NaN                  |
| **Explicabilidade**    | Nativa (`trace`, `doc`, `memory`)   | Pós-processada (SHAP, LIME)      |
| **Federabilidade**     | Suportada via `call()`              | Inexistente                      |

---

## 📫 Contribuição

1. **Fork** deste repositório.
2. Crie uma branch:  
   `git checkout -b minha-funcionalidade`
3. Faça commit das suas alterações:  
   `git commit -m 'Nova feature'`
4. Envie um push:  
   `git push origin minha-funcionalidade`
5. Envie um **pull request**!

---

**Pronto para compor vetores com clareza, lógica e sem surpresas.**  
Explore, experimente e contribua!
