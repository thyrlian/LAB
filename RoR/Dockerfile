FROM ruby:2.7-slim

ENV RAILS_VERSION 6.1.4.4

# Install Rails
RUN gem update --system && \
    gem install bundler && \
    apt update && \
    apt install -y --no-install-recommends build-essential && \
    gem install rails -v ${RAILS_VERSION}

# Install SQLite
RUN apt install -y --no-install-recommends libsqlite3-dev

# Install Node.js
RUN apt install -y --no-install-recommends nodejs npm

# Install Yarn
RUN npm install --global yarn

ENV APP_DIR /app
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}
VOLUME ${APP_DIR}
EXPOSE 3000

# Install Rails' common dependencies
# RUN rails new temp && rm -rf temp

CMD ["rails", "server", "-b", "0.0.0.0"]

# docker build -t rails .
# docker run -it -p 80:3000 -v $(pwd)/app:/app rails /bin/bash
# rails s -b 0.0.0.0
