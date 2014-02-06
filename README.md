cxf-dosgi-demo
======================

Simple Fabric8-oriented CXF + DOSGi demonstration code.

# Pre-requisites

* JDK 7
* Maven 3.1.0 or newer
* Git

# Build

Clone and run

```no-highlight
git clone https://github.com/pires/cxf-dosgi-demo.git
cd cxf-dosgi-demo
mvn clean install
```

# Provisioning

Download [latest build](https://repository.jboss.org/nexus/content/repositories/ea/io/fabric8/fabric8-karaf/) for ```fabric-karaf``` and extract it.
*(tested on fabric8-karaf-1.0.0.redhat-336)*

## Start Fabric

```no-highlight
bin/fusefabric
```

If everything goes well, you should get a Fabric shell that looks like this:

```no-highlight
Please wait while Fabric8 is loading...
100% [========================================================================]

______    _          _      _____
|  ___|  | |        (_)    |  _  |
| |_ __ _| |__  _ __ _  ___ \ V /
|  _/ _` | '_ \| '__| |/ __|/ _ \
| || (_| | |_) | |  | | (__| |_| |
\_| \__,_|_.__/|_|  |_|\___\_____/
  Fabric8 Container (1.0.0-SNAPSHOT)
  http://fabric8.io/

Type 'help' to get started
and 'help [cmd]' for help on a specific command.
Hit '<ctrl-d>' or 'osgi:shutdown' to shutdown this container.

Open a browser to http://localhost:8181 to access the management console

Create a new Fabric via 'fabric:create'
or join an existing Fabric via 'fabric:join [someUrls]'

Fabric8:karaf@root>
```

## Start Fabric Ensemble
```no-highlight
fabric:create --clean --wait-for-provisioning
```

## Define our own profiles
```no-highlight
profile-create --parents feature-dosgi billing-osgi
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-services/0.1-SNAPSHOT billing-osgi
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-billing/0.1-SNAPSHOT billing-osgi

profile-create --parents feature-dosgi --parents example-quickstarts-rest billing-cxf
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-services/0.1-SNAPSHOT billing-cxf
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-rest/0.1-SNAPSHOT billing-cxf
```

## Deploy new containers with created profiles

```no-highlight
container-create-child --profile billing-osgi root osgi
container-create-child --profile billing-cxf root rest
```