# 🎰 Ganhei Na Mega - Gerador de Números para Loteria  

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9-blue?style=for-the-badge&logo=kotlin" />
  <img src="https://img.shields.io/badge/Android-12-green?style=for-the-badge&logo=android" />
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange?style=for-the-badge" />
</p>

Bem-vindo ao **Ganhei Na Mega**! 🎉 Este é um aplicativo simples, desenvolvido como um **projeto de estudo**, que gera números aleatórios para apostas na **Mega-Sena** 🎰💰.

> **Objetivo do projeto**: Aprender conceitos básicos de desenvolvimento Android com Kotlin, incluindo **layouts com ConstraintLayout, manipulação de eventos de clique, validação de entrada do usuário e geração de números aleatórios**.

---

## 📱 Demonstração  

<img src="https://via.placeholder.com/300x600.png?text=Ganhei+na+Mega+App" width="250" alt="Imagem do app"/>

*(Adicione um print do aplicativo aqui! 🖼️ Se precisar de ajuda, posso explicar como tirar screenshots no emulador do Android Studio.)*

---

## ✨ Recursos  

✔️ Gera números aleatórios entre **1 e 60**.  
✔️ Permite escolher quantos números deseja gerar (**entre 6 e 15**).  
✔️ Exibe os números sorteados na tela.  
✔️ Notifica o usuário caso o valor inserido esteja fora do intervalo válido.  
✔️ Interface minimalista e responsiva.  

---

## 🚀 Tecnologias utilizadas  

- 🟠 **Linguagem:** Kotlin  
- 📱 **Framework:** Android SDK  
- 🎨 **UI:** ConstraintLayout, EditText, TextView e Button  
- 🔢 **Lógica:** Geração de números aleatórios usando `kotlin.random.Random`  
- ✅ **Validação de entrada**  

---

## 📥 Como baixar e rodar o projeto?  

### 📌 **Requisitos**  
- Android Studio **Arctic Fox (ou superior)**
- JDK **17 ou superior**
- Emulador ou dispositivo Android físico

### 🔽 **Passos para rodar**
1. Clone este repositório no seu computador:
   ```bash
   git clone https://github.com/seu-usuario/ganhei-na-mega.git
   ```
2. Abra o **Android Studio** e importe o projeto.  
3. Conecte um dispositivo físico ou inicie um emulador.  
4. Clique no botão ▶️ **Run** para compilar e executar o app!  

---

## 📝 Como funciona o código?  

A estrutura principal do app se baseia na classe `MainActivity.kt`, onde:
- Capturamos o número de entradas do usuário pelo **EditText**.
- Validamos se o valor está entre **6 e 15** antes de gerar os números.
- Criamos números **aleatórios e sem repetição** com `kotlin.random.Random`.
- Exibimos os resultados em um **TextView**.

Trecho principal do código:
```kotlin
btnGenerate.setOnClickListener {
    val text = editText.text.toString()
    if (text.isNotEmpty()) {
        val qtd = text.toIntOrNull()
        if (qtd != null && qtd in 6..15) {
            val numbers = mutableSetOf<Int>()
            while (numbers.size < qtd) {
                numbers.add(Random.nextInt(1, 61))
            }
            txtResult.text = numbers.joinToString(" - ")
        } else {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }
    }
}
```

---

## 📌 Melhorias futuras  
- 📌 **Opção para salvar números sorteados**.  
- 📌 **Modo escuro (dark mode)**.  
- 📌 **Animações para a geração dos números**.  
- 📌 **Compartilhamento dos números sorteados via WhatsApp**.  

Caso tenha alguma sugestão, **sinta-se à vontade para abrir uma issue ou enviar um pull request!** 🚀

---

## 📜 Licença  
Este projeto foi desenvolvido para fins educacionais e está disponível sob a licença **MIT**.  

Se quiser contribuir, fique à vontade! 🤝  

---

Feito com 💜 por [Wellington Damasceno](https://github.com/wellfurtado) 🚀  
