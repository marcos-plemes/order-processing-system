APP_NAME=order-processing-system

up:
	docker compose up -d

down:
	docker compose down

logs:
	docker compose logs -f

build:
	./gradlew clean build

run:
	./gradlew bootRun

test:
	./gradlew test

restart:
	docker compose down
	docker compose up -d

kafka-logs:
	docker logs -f kafka

postgres-logs:
	docker logs -f loomi-postgres

status:
	docker ps

clean:
	./gradlew clean