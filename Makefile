run-dist:
	/app./build/install/app/bin/app
clean:
	gradle clean
install:
	gradle installDist
reinstall:
	gradle clean
	gradle installDist
run:
	/app./build/install/app/bin/app file1.json file2.json
lint:
	/app./gradlew checkstyleMain
test:
	/app./gradlew test
report:
	/app.gradlew jacocoTestReport
build:
	/app./gradlew clean build
.PHONY: build

