FROM ubuntu:latest
LABEL authors="andersonlopes"

ENTRYPOINT ["top", "-b"]
