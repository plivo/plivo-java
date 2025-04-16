#!/bin/bash

set -e
testDir="java-sdk-test"
GREEN="\033[0;32m"
NC="\033[0m"

if [ ! $PLIVO_API_PROD_HOST ] || [ ! $PLIVO_API_DEV_HOST ] || [ ! $PLIVO_AUTH_ID ] || [ ! $PLIVO_AUTH_TOKEN ]; then
    echo "Environment variables not properly set! Please refer to Local Development section in README!"
    exit 126
fi

cd /usr/src/app

echo "Setting plivo-api endpoint to dev..."
find /usr/src/app/src/ -type f -exec sed -i "s/$PLIVO_API_PROD_HOST/$PLIVO_API_DEV_HOST/g" {} \;

if [[ $( grep uploadArchives build.gradle ) ]]; then
    echo "Modifying build.gradle..."
    sed -i '/uploadArchives/,/artifacts/{//!d}' build.gradle
    sed -i '/signing {/,/}/d' build.gradle
    echo "dependencies{
    compile 'com.fasterxml.jackson.core:jackson-core:2.10.1'
    compile 'com.fasterxml.jackson.core:jackson-annotations:2.10.1'
    compile 'com.fasterxml.jackson.core:jackson-databind:2.10.1'
    }" >> build.gradle
fi
./gradlew fatJar

mkdir -p /etc/jars
mv /usr/src/app/build/libs/*.jar /etc/jars/

if [ ! -d $testDir ]; then
    echo "Creating test dir..."
    mkdir -p $testDir
fi

echo -e "\n\nSDK setup complete! You can test changes either on host or inside the docker container:"
echo -e "\ta. To test your changes ON HOST:"
echo -e "\t\t1. Add your test code in <path_to_cloned_sdk>/$testDir/Test.java"
echo -e "\t\t2. Run your test file using: $GREEN make run CONTAINER=$HOSTNAME$NC"
echo -e "\t\t3. Run unit tests using: $GREEN make test CONTAINER=$HOSTNAME$NC"
echo
echo -e "\tb. To test your changes INSIDE CONTAINER:"
echo -e "\t\t1. Run a terminal in the container using: $GREEN docker exec -it $HOSTNAME /bin/bash$NC"
echo -e "\t\t2. Add your test code in /usr/src/app/$testDir/Test.java"
echo -e "\t\t3. Run your test file using: $GREEN make run$NC"
echo -e "\t\t4. Run unit tests using: $GREEN make test$NC"

# To keep the container running post setup
/bin/bash