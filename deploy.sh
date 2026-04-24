#!/bin/bash
docker pull brht13/devops3:latest
docker compose -f /home/ec2-user/docker-compose.yml down
docker compose -f /home/ec2-user/docker-compose.yml up -d
