#!/usr/bin/env bash
echo "Start up, please wait patiently..."
nohup java -jar /data/tron/fullnode/FullNode.jar -c /data/tron/fullnode/config.conf >/dev/null 2>&1 &
sleep 3
FPid=`ps -ef |grep FullNode.jar |grep -v grep |awk '{print $2}'`
if [[ -n "$FPid" ]]; then
    echo "Start up FullNode, successfully"
 else
   echo "Start FullNode fail"
   exit
fi