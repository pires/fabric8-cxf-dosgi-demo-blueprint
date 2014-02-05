cxf-dosgi-demo
======================

Simple Fabric8-oriented CXF + DOSGi demonstration code.

# Build

Clone and run

```no-highlight
git clone https://github.com/pires/cxf-dosgi-demo.git
cd cxf-dosgi-demo
mvn clean install
```

# Provisioning

*(tested on fabric8-karaf-1.0.0.redhat-336)*

```no-highlight
fabric:create --clean --wait-for-provisioning

profile-create --parents feature-dosgi billing-osgi
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-services/0.1-SNAPSHOT billing-osgi
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-billing/0.1-SNAPSHOT billing-osgi

profile-create --parents feature-dosgi --parents example-quickstarts-rest billing-cxf
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-services/0.1-SNAPSHOT billing-cxf
profile-edit --bundles mvn:com.github.pires.example.fabric8/cxf-dosgi-demo-rest/0.1-SNAPSHOT billing-cxf

container-create-child --profile billing-osgi root osgi
container-create-child --profile billing-cxf root rest
```