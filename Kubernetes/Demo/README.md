# KubernetesDemo

Inspired by [Carter Morgan](https://github.com/askcarter)'s [Best practices for orchestrating the Cloud with Kubernetes](https://www.youtube.com/watch?v=21hXNReWsUU).

## Getting Started

```bash
# build the docker image
docker build -t kubernetes-demo .

# run a docker container
docker run -p 8080:8080 -d kubernetes-demo
```

## Example URLs

```console
http://<YOUR_IP_ADDRESS>:8080/api/hi
http://<YOUR_IP_ADDRESS>:8080/api/status
```
