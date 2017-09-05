#!/bin/bash
docker run -it --privileged --rm --link happy_allen:webe2e -v $(pwd):/protractor  --entrypoint=/bin/bash webnicer/protractor-headless -c "npm install && /protractor.sh e2e-test/conf.js"
