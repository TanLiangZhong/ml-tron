#!/usr/bin/env bash
echo "Start up, please wait patiently..."
nohup java -jar /data/tron/soliditynode/SolidityNode.jar -c /data/tron/soliditynode/config.conf >/dev/null 2>&1 &
sleep 3
FPid=`ps -ef |grep SolidityNode.jar |grep -v grep |awk '{print $2}'`
if [[ -n "$FPid" ]]; then
    echo "Start up SolidityNode, successfully"
 else
   echo "Start SolidityNode fail"
fi