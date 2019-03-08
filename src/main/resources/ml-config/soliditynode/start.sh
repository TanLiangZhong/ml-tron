#!/usr/bin/env bash
echo "Start up, please wait patiently..."
SPid=`ps -ef |grep SolidityNode.jar |grep -v grep |awk '{print $2}'`
sleep 3
if [[ -n "$SPid" ]]; then
    echo "Start up SolidityNode, successfully"
 else
   echo "Start SolidityNode fail"
   exit
fi
echo "Start up Tron, successfully."