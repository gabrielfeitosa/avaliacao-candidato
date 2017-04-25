#!/bin/bash
cd frontend/
npm install
rm -rf ../backend/src/main/resources/static/
mkdir ../backend/src/main/resources/static/
cp -R bower_components/ ../backend/src/main/resources/static/
cp -R src/ ../backend/src/main/resources/static/
cp index.html ../backend/src/main/resources/static/
cd ../backend/
mvn spring-boot:run
