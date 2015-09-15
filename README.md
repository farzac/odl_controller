# odl_controller
This is a custom basic ODL controller

This repo offers a simple controller using OSGI bundle and a module that will be a class of mediation of network virtual.

NOTE: The mediator class still not work.

# HOW TO BUILD
In order to build it's required to have JDK 1.7+ and Maven 3+, to get a build going do this:

cd build && mvn clean install -nsu

# HOW TO RUN
Upon successful completion of a build

cd runDir && ./run.sh

Wait for the osgi console to startup and then point a browser at

http:localhost:8080/
