NAME=nogo

all: $(NAME)

$(NAME) :
	docker compose up -d --build --force-recreate

ps :
	docker compose ps

down :
	docker compose down -v --rmi all

logs :
	docker compose logs database
	docker compose logs application

logsf :
	docker compose logs database -f
	docker compose logs application -f
top :
	docker compose top database
	docker compose top application

exec-db :
	docker compose exec database /bin/bash

exec-app :
	docker compose exec application /bin/bash


clean : down
	docker system prune --volumes --all --force
	docker network prune --force
	docker volume prune --force

re : clean all

build :
	./gradlew build

.PHONY : ps, down, logs, logsf, top, exec-db, exec-app, clean, re, build
