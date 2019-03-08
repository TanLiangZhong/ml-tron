#!/usr/bin/env bash
while true; do
  FPid=`ps -ef |grep FullNode.jar |grep -v grep |awk '{print $2}'`
  SPid=`ps -ef |grep SolidityNode.jar |grep -v grep |awk '{print $2}'`
  if [-n ${FPid} || -n ${SPid}]; then
    if [-n ${FPid}]; then
        kill -15 ${FPid}
        echo "The FullNode process is exiting, it may take some time, forcing the exit may cause damage to the database, please wait patiently..."
        sleep 1
    fi
    if [-n ${SPid}]; then
        kill -15 ${SPid}
        echo "The SolidityNode process is exiting, it may take some time, forcing the exit may cause damage to the database, please wait patiently..."
        sleep 1
    fi
  else
    echo "java-tron killed successfully!"
    break
  fi
done