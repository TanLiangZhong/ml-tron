#!/usr/bin/env bash
echo "Start up, please wait patiently..."
nohup java -jar /opt/tron/fullnode/FullNode.jar -c /opt/tron/soliditynode/config.conf >/dev/null 2>&1 &
sleep 3
FPid=`ps -ef |grep FullNode.jar |grep -v grep |awk '{print $2}'`
if [[ -n "$FPid" ]]; then
    echo "Start up FullNode, successfully"
 else
   echo "Start FullNode fail"
   exit
fi
nohup java -jar /opt/tron/soliditynode/SolidityNode.jar -c /opt/tron/soliditynode/config.conf >/dev/null 2>&1 &
sleep 3
SPid=`ps -ef |grep SolidityNode.jar |grep -v grep |awk '{print $2}'`
if [[ -n "$SPid" ]]; then
    echo "Start up SolidityNode, successfully"
 else
   echo "Start SolidityNode fail"
   exit
fi
echo "Start up Tron, successfully."