Projeto Auri Finance
🚀 Projeto Auri Finance é uma aplicação Java totalmente containerizada com Docker, ideal para desenvolvimento e testes sem a necessidade de configurar JDK ou ambiente local.

📋 Visão Geral
Este projeto fornece uma estrutura base para aplicações Java, com foco em facilitar o desenvolvimento no Visual Studio Code utilizando Docker.
Todo o ambiente de execução é configurado via contêiner, garantindo portabilidade e facilidade de uso.

⚠️ Este projeto está em constante desenvolvimento.

📂 Estrutura do Projeto
python
Copiar
Editar
.
├── .devcontainer/          # Configurações do ambiente de desenvolvimento em contêiner
├── .vscode/                # Configurações específicas do VS Code
├── bin/                    # Binários compilados
├── lib/                    # Bibliotecas externas (.jar)
├── src/                    # Código-fonte Java
├── docker-compose.yml      # Orquestração do ambiente com Docker
└── README.md
⚙️ Requisitos
Docker instalado

(Opcional) Visual Studio Code com a extensão Dev Containers

🚀 Como Executar
Usando Visual Studio Code (Recomendado)
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/Ryanpmb/Projeto-Auri-Finance.git
cd Projeto-Auri-Finance
Abra no VS Code
Certifique-se de ter a extensão Dev Containers instalada.

Reabra no Container
O VS Code vai sugerir reabrir o projeto dentro do container. Aceite.

Execute o projeto
Após o ambiente estar pronto, rode este comando no terminal do container:

bash
Copiar
Editar
java -cp out:lib/postgresql-42.6.0.jar main.App
Usando Docker manualmente
css
Copiar
Editar
docker-compose up --build
📌 Funcionalidades (em desenvolvimento)
Estrutura modular em Java

Suporte a bibliotecas externas (.jar)

Integração com PostgreSQL (via lib/postgresql-42.6.0.jar)

Base para funcionalidades financeiras futuras

💡 Observações
O diretório lib/ pode ser usado para adicionar dependências externas (.jar)

Toda execução e compilação ocorre dentro do container

Nenhuma dependência Java precisa estar instalada localmente no seu sistema operacional

🤝 Contribuições
Contribuições são bem-vindas!
Faça um fork, crie uma branch, commit e depois um pull request.

📄 Licença
Este projeto ainda não possui uma licença definida.
