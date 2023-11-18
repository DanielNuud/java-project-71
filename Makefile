run-dist:
	./build/install/app/bin/app
clean:
	gradle clean
install:
	gradle installDist
reinstall:
	gradle clean
	gradle installDist
run:
	./build/install/app/bin/app file1.json file2.json
lint:
	./gradlew checkstyleMain
test:
	./gradlew test
build:
	./gradlew build
.PHONY: build
