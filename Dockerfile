FROM ibm-semeru-runtimes:open-17-jre-focal

WORKDIR /usr/app
COPY build/install/RyseInventorySupportBot ./

ENTRYPOINT ["bin/RyseInventorySupportBot"]