# ====================================================================== #
# Ruby Sinatra Docker Image for Kubernetes Demo Purpose
# ====================================================================== #

FROM ruby:2.5.3-alpine3.8
ADD server /srv/KubernetesDemo
WORKDIR "/srv/KubernetesDemo"
RUN bundle install
EXPOSE 8080
ENTRYPOINT ["rackup"]
