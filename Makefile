NAME=nogo

all: $(NAME)

$(NAME) : up

up :
	docker compose up -d

ps :
	docker compose ps

down :
	docker compose down

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
	rm -rf build
	docker compose down -v --rmi all
	docker system prune --volumes --all --force
	docker network prune --force
	docker volume prune --force

build :
	./gradlew build

re : clean build
	docker compose up -d --build --force-recreate

.PHONY : up, ps, down, logs, logsf, top, exec-db, exec-app, clean, build, re
