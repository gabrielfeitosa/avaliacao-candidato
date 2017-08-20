#!/bin/bash
docker run -it --privileged --rm --link e2e:webe2e -v $(pwd):/protractor  --entrypoint=/bin/bash webnicer/protractor-headless -c "npm install && /protractor.sh e2e-test/conf.js"
