# Read Me First

The following was discovered as part of building this project:

* No Docker Compose services found. As of now, the application won't start! Please add at least one service to
  the `compose.yaml` file.

# Getting Started

### Reference Documentation
https://api.coindesk.com/v1/bpi/historical/close.json

## Steps to Docker the Application
<ol>
<li>RUN <code><copy>mvn clean package</copy></code> </li>
<li>RUN <code><copy>docker build -t my-spring-boot-app . </copy></code> </li>
<li>RUN <code><copy>docker run -p 8080:8080 my-spring-boot-app
</copy></code> </li>
<li>RUN <code><copy>curl -X GET http://localhost:8080/v1/api/bts
</copy></code> </li>
<li>RUN <code><copy>docker logs "container_id"</copy></code> </li>

<li>docker image push docker.io/stallion49/config-server:v1</li>
</ol>