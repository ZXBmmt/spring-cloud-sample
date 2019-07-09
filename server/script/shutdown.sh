#!/bin/bash
# author changbai.zheng@ipinyou.com
# date 2017.2.7
# usge
# 	shutdown.sh [timeout]
#   timeout: negative or omitted  means unlimited
# 	example: ./shutdown.sh  15 


PID=$(cat `dirname $0`/application.pid)
TIMEOUT=$1

if [ -z "$PID" ];then
	echo "no pid.file,please kill it manually"
	exit 0
fi

kill -0 $PID 2>/dev/null 
if [ $? -ne 0 ];then
   echo -e "pid \e[0;31m$PID\e[0m not exist,can't kill it"
   exit 0
fi

#default unlimited
if [ -z "$TIMEOUT" ];then
  TIMEOUT=-1
fi

if [ $TIMEOUT -gt 0 ];then
	echo "shutdown timeout is [$1] seconds"
else
	echo "shutdown timeout is [unlimited]"
    TIMEOUT=-1
fi

# kill 10 times, then force kill
count=1;
while [ $TIMEOUT -lt 0 -o $count -le $TIMEOUT ]
do
	kill -0 $PID 2>/dev/null 
	if [  $? -eq 0 ]; then
		echo kill $PID time [$count]
		kill $PID
		sleep 1
		((count++))
	else
		break
	fi
done

kill -0 $PID 2>/dev/null
if [ $? -eq 0 ];then
	echo kill -9 $PID
	kill -9 $PID
	sleep $TIMEOUT
	echo "kill $PID force"
else
	echo "kill $PID graceful"
fi
