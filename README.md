# Springboot

# 🚀 Projetos Java com Integração de APIs

Este repositório reúne três projetos desenvolvidos em **Java com Spring Boot**, cada um integrando uma API externa para resolver um problema específico:

- 🔍 Geolocalização por IP
- 🏠 Consulta de endereços via CEP
- 🤖 ChatBot com a API Gemini (Google AI)

---

## 📍 PROJETO 1: Geolocalização por IP

### 📘 Descrição
Esse projeto consulta a **localização geográfica de um IP** utilizando uma API pública de geolocalização (ex: [ipapi.co](https://ipapi.co), [ipstack.com](https://ipstack.com), etc).

### 🔧 Tecnologias
- Java 17
- Spring Boot
- API REST externa (Geolocalização)

### ▶️ Como executar

```bash
cd geolocalizacao-api
./mvnw spring-boot:run

## 🏠 PROJETO 2: Busca de Endereço com ViaCEP

📘 Descrição
Este projeto realiza a consulta de dados de endereço a partir de um CEP, utilizando a API pública do ViaCEP.

🔧 Tecnologias
- Java 17
- Spring Boot
- API ViaCEP

### ▶️ Como executar
```bash
cd viacep-api
./mvnw spring-boot:run

### 📥 Exemplo de requisição
GET /cep/01001000
📤 Exemplo de resposta

- json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}

