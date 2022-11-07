NAME=test

$(NAME) :
	docker compose up -d

ps :
	docker compose ps

down :
	docker compose down

logs :
	docker compose logs database
	docker compose logs application

exec-db :
	docker compose exec database /bin/bash

exec-app :
	docker compose exec application /bin/bash

clean : down
	docker rmi -f `docker images -q`
