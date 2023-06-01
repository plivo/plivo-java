.PHONY: build test run

build:
	docker-compose up --build --remove-orphans

test:
	@[ "${CONTAINER}" ] && \
		docker exec -it $$CONTAINER /bin/bash -c "/usr/src/app/gradlew test" || \
		/usr/src/app/gradlew test

run:
	@[ "${CONTAINER}" ] && \
		(docker exec -it $$CONTAINER /bin/bash -c 'cd /usr/src/app/java-sdk-test/ && javac Test.java && java Test') || \
		(cd /usr/src/app/java-sdk-test/ && javac Test.java && java Test)