#!/bin/bash
PATH_TO_INDEX=$1

mvn clean && mvn compile

mvn exec:java -Dexec.mainClass=com.weibo.index.WriteDataIntoRedis -Dexec.args=${PATH_TO_INDEX}