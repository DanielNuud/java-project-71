run-dist:
	./build/install/app/bin/app

clean:
	./gradlew clean

install:
	./gradlew installDist

reinstall:
	./gradlew clean
	./gradlew installDist

run:
	./build/install/app/bin/app file1.json file2.json

lint:
	./gradlew checkstyleMain

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

build:
	./gradlew clean build

.PHONY: build
