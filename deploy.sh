#!/bin/bash
sudo systemctl start docker 2>/dev/null || true
sudo docker pull brht13/devops3:latest
sudo /usr/local/bin/docker-compose -f /home/ec2-user/docker-compose.yml down
sudo /usr/local/bin/docker-compose -f /home/ec2-user/docker-compose.yml up -d
