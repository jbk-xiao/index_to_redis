#!/bin/bash

INPUT_PATH=$1
INDEX_PATH=$(cd "$(dirname "$0")";pwd)/temp

rm -rf $INDEX_PATH
mkdir $INDEX_PATH

for file in `ls $INPUT_PATH`
do
	index=$(echo $file | awk -F '_' '{split($3,val,".");{print val[1]}}')
	cat $INPUT_PATH/$file | awk -F ',' '{line[NR]=$3};END{i=NR;{print NR};while(i>0){print line[i];i=i-1}}' \
	>> $INDEX_PATH/${index}.txt
	echo ${index}.txt" has been created"
	echo $INDEX_PATH
	mvn exec:java -Dexec.mainClass=com.weibo.index.WriteDataIntoRedis -Dexec.args="$index $INDEX_PATH/${index}.txt"
done
