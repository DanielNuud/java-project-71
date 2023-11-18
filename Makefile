run-dist:
	$PWD/build/install/app/bin/app

clean:
	$PWD/gradle clean

install:
	$PWD/gradle installDist

reinstall:
	$PWD/gradle clean
	$PWD/gradle installDist

run:
	$PWD/build/install/app/bin/app file1.json file2.json

lint:
	$PWD/gradlew checkstyleMain

test:
	$PWD/gradlew test

report:
	$PWD/.gradlew jacocoTestReport

build:
	cd app && ./gradlew clean build

.PHONY: build
