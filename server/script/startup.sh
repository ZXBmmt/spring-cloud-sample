#!/bin/bash -e
# -Dloader.path="./patch", 用于补丁路径
# 命令行结尾要有重定向到文件，以及错误输出也重定向到文件，否则jenkins调用时会堵塞！
# 即要采用：nohup ... >> nohup.out 2>&1 & 这种形式
nohup  /data/jdk-11/bin/java -server -Xmx200m -jar -Dloader.path="./patch" -Dspring.profiles.active=___app_profile___,prod-server  ___package_jar___ >> nohup.out 2>&1 &