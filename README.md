# Secure Drive

Secure Drive é uma aplicação Spring Boot para gerenciar moradores, veículos e horários de restrição em um condomínio.

## Sumário

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Execução](#execução)
- [Contribuição](#contribuição)


## Visão Geral

Esta aplicação foi desenvolvida para gerenciar informações sobre moradores, veículos e horários de restrição de um condomínio, permitindo operações CRUD (Create, Read, Update, Delete) através de uma API RESTful.

## Funcionalidades
- Gerenciamento de Moradores
- Gerenciamento de Veículos
- Gerenciamento de Horários de Restrição
- Tratamento de Exceções

## Pré-requisitos

- Java 17 ou superior
- Maven
- Banco de Dados Oracle

## Instalação

1. Clone o repositório:
    ```bash
    git clone  -https://github.com/LucianeC/secureDrive.git
    ```

## Execução

1. Execute a aplicação:`SecureDriveApplication`

2. A aplicação estará disponível em `http://localhost:8080`.



### Endpoints

#### Moradores

- `GET /api/moradores`: Retorna todos os moradores
- `GET /api/moradores/{id}`: Retorna um morador pelo ID
- `POST /api/moradores`: Cria um novo morador
- `PUT /api/moradores/{id}`: Atualiza um morador pelo ID
- `DELETE /api/moradores/{id}`: Deleta um morador pelo ID

#### Veículos

- `GET /api/veiculos`: Retorna todos os veículos
- `GET /api/veiculos/{id}`: Retorna um veículo pelo ID
- `POST /api/veiculos`: Cria um novo veículo
- `PUT /api/veiculos/{id}`: Atualiza um veículo pelo ID
- `DELETE /api/veiculos/{id}`: Deleta um veículo pelo ID

#### Horários de Restrição

- `GET /api/horarios-restricao`: Retorna todos os horários de restrição
- `GET /api/horarios-restricao/{id}`: Retorna um horário de restrição pelo ID
- `POST /api/horarios-restricao`: Cria um novo horário de restrição
- `PUT /api/horarios-restricao/{id}`: Atualiza um horário de restrição pelo ID
- `DELETE /api/horarios-restricao/{id}`: Deleta um horário de restrição pelo ID


