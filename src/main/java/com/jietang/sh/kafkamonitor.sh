#!/bin/bash

a=`lsof -i:3306 | wc -l`
if [ "$a" -gt "0" ];then
    echo "0"
else
    echo "1"
fi
